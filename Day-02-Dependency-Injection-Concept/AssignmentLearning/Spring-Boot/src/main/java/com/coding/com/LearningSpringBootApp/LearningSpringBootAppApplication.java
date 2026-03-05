package com.coding.com.LearningSpringBootApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class
LearningSpringBootAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootAppApplication.class, args);
	}

    private final PaymenetType payment;

    //This is called we inject the dependency of the the object
    public LearningSpringBootAppApplication(PaymenetType payment){
        this.payment = payment;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(payment.pay());
    }
}
