package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Slf4j
@SpringBootApplication
public class DemorabbitApplication implements CommandLineRunner {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemorabbitApplication.class, args);
	}
	
	/**
	 * 
	 */
	@Autowired
	private DemoProducer producer;

	/**
	 * 
	 */
	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			producer.send("Mensagem RabbitMQ " + i);
			
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { log.error(e.getMessage()); }
		}
	}
}
