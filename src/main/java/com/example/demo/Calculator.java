package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class Calculator {
	Operation operation;
	private Map<String, Operation> methods=new HashMap();
	public Calculator(Map<String, Operation> operations) {
		this.methods = operations;
	}

	public void calc(String operationType, double a, double b) throws Exception {
		double result = Optional.ofNullable(methods.get(operationType))
				.orElseThrow(() -> new Exception("Unsupported operation"))
				.getResult(a, b);
		System.out.println(result);
	}

	public String getSupportedOperations() {
		return methods.keySet().toString();
	}
}
