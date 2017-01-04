package com.omexit.malipo.paymentbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:integration-context.xml")
public class PaymentBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentBridgeApplication.class, args);
	}
}
