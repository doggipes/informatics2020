package ru.informaticsprac.own_aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AspectExample {
    @Autowired
    MethodRepository methodRepository;

    @Pointcut("@annotation(MyTransaction)")
    public void callMyTransaction(){}

    @Around(value = "callMyTransaction()")
    public Object aroundCallMyTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Optional<Method> method_by_uuid = methodRepository.findEntityByUuid(args[0].toString());
        Optional<Method> method_by_name = methodRepository.findEntityByName(joinPoint.getSignature().getName());

        if(!method_by_name.isPresent()) {
            if (!method_by_uuid.isPresent()) {
                methodRepository.save(Method.builder()
                        .name(joinPoint.getSignature().getName())
                        .uuid(args[0].toString())
                        .return_object(joinPoint.proceed().toString())
                        .build());
                System.out.println("Записался");
                return joinPoint.proceed();
            } else {
                return null;
            }
        } else
        {
            if(!method_by_uuid.isPresent()){
                return null;
            } else {
                if(method_by_name.get().getUuid().equals(method_by_uuid.get().getUuid())){
                    Method method = methodRepository.findEntityByUuid(args[0].toString()).get();
                    System.out.println("Достали");
                    return method.getReturn_object();
                } else
                    return null;
            }
        }
    }

}
