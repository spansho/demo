package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	private final Calculator calculator;
	 public DemoApplication(@Qualifier("calculator") Calculator calculator)
	 {
		 this.calculator=calculator;
	 }
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		double a,b;


	}

	@Bean
	public boolean outToConsole() throws  Exception
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите число a");
		double a=scanner.nextDouble();
		System.out.println("Введите число b");
		double b=scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Введите тип операции: " + calculator.getSupportedOperations());
		String operationType = scanner.nextLine();
		calculator.calc(operationType,a,b);
		return true;
	}



}


