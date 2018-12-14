package com.example.user.management;

import com.example.user.management.model.User;
import com.example.user.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.Instant;
import java.time.LocalDate;

@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initDummyData() {
        userRepository.save(User.builder().birthday(LocalDate.of(1992,2,22)).name("Tom").surname("Sawyer").build());
        userRepository.save(User.builder().birthday(LocalDate.of(1989,7,1)).name("Andy").surname("White").build());
        userRepository.save(User.builder().birthday(LocalDate.of(1990,1,12)).name("Jack").surname("Cooper").build());
        userRepository.save(User.builder().birthday(LocalDate.of(1991,11,5)).name("John").surname("Smith").build());
        userRepository.save(User.builder().birthday(LocalDate.of(1987,9,9)).name("Jane").surname("Tomson").build());
        userRepository.save(User.builder().birthday(LocalDate.of(1979,6,10)).name("Rick").surname("Morthy").build());
        userRepository.save(User.builder().birthday(LocalDate.of(1961,10,25)).name("Marry").surname("Jane").build());
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

