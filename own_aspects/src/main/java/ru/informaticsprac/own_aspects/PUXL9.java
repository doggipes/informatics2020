package ru.informaticsprac.own_aspects;


import org.springframework.stereotype.Service;

@Service
public class PUXL9 {

    @MyTransaction
    public String test(String uuid) {
        return uuid;
    }

    @MyTransaction
    public int test2(String uuid, int first, int second){
        return first + second;
    }
}
