/**
 * 
 */
package com.example.demo.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Slf4j
@Component
public class DemoProducer {
	@Value("${demo.queue}")
	private String destinationQueue;

	@Autowired
	private RabbitTemplate template;

	/**
	 * 
	 * @param msg
	 */
	public void send(String msg){
		template.convertAndSend(destinationQueue, msg);
		log.info("Enviado: {}", msg);
	}
}
