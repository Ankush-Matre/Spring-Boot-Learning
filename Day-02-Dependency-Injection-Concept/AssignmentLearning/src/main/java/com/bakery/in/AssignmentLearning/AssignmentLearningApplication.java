package com.bakery.in.AssignmentLearning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentLearningApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentLearningApplication.class, args);
	}

    private final CakeBaker cake;

    public AssignmentLearningApplication(CakeBaker cake){
        this.cake = cake;
    }

    @Override
    public void run(String... args) throws Exception {
        cake.bakeCake();
    }
}
