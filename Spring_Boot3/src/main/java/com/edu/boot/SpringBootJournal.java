package com.edu.boot;

import com.edu.boot.domain.Journal;
import com.edu.boot.repository.JournalRepositroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Sergey Zhernovoy
 * create on 05.01.2018.
 */

import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

@SpringBootApplication(exclude = {ActiveMQAutoConfiguration.class})
public class SpringBootJournal {

    @Bean
    InitializingBean saveData(JournalRepositroy repo){
        return ()->{
            repo.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","18/01/2018"));
            repo.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2018"));
            repo.save(new Journal("Spring Boot Reading","Read more about Spring Boot","20/01/2018"));
            repo.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","25/01/2018"));
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournal.class,args);
    }

}

    