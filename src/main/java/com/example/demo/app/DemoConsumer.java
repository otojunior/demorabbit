/**
 * 
 */
package com.example.demo.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Slf4j
@Component
public class DemoConsumer {
	/**
	 * 
	 * @param msg
	 */
	@RabbitListener(queues = "${demo.queue}")
	public void receive(String msg) {
		log.info("Consumido: {}", msg);
		
		/*
		 * Simulação de erro
		 */
		if (msg.equals("Mensagem RabbitMQ 4")) {
			log.error("Erro (simulado) na integração MSG 4");
			throw new RuntimeException("Simulando erro no consumo");
		}
	}
}
