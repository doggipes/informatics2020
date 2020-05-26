package ru.informaticsprac.own_aspects;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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

    @Pointcut("@annotation(MyTransaction) && args(uuid, ..)")
    public void callMyTransaction(String uuid){}

    @Around(value = "callMyTransaction(uuid)")
    public Object aroundCallMyTransaction(ProceedingJoinPoint joinPoint, String uuid) throws Throwable {
        Object[] args = joinPoint.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder parameters = new StringBuilder();
        for (Object arg: args) {
            parameters.append(objectMapper.writeValueAsString(arg)).append(",");
        }
        parameters.deleteCharAt(parameters.length() - 1);

        Optional<Method> method_by_uuid = methodRepository.findEntityByUuidAndParametersAndName(uuid, parameters.toString(), joinPoint.getSignature().toString());

            if (method_by_uuid.isPresent()) {
                if(method_by_uuid.get().getParameters().equals(parameters.toString()) && method_by_uuid.get().getName().equals(joinPoint.getSignature().toString())){
                    System.out.println("Достали");
                    return objectMapper.readValue(method_by_uuid.get().getReturn_object(), ((MethodSignature) joinPoint.getSignature()).getReturnType());
                }
            }

                methodRepository.save(Method.builder()
                        .name(joinPoint.getSignature().toString())
                        .uuid(uuid)
                        .parameters(parameters.toString())
                        .return_object(objectMapper.writeValueAsString(joinPoint.proceed()))
                        .build());

                System.out.println("Записался");
                return joinPoint.proceed();
    }

}
