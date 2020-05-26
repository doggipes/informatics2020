package ru.informaticsprac.own_aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Tests implements CommandLineRunner {
    @Autowired
    PUXL9 puxl9;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(puxl9.test("123"));
        System.out.println(puxl9.test2("456", 5000, 51));
    }
}
