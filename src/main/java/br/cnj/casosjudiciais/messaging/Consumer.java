package br.cnj.casosjudiciais.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.cnj.casosjudiciais.config.QueueConfig;

@Component
public class Consumer {
    
    @RabbitListener(queues = {QueueConfig.NOME_FILA})
    public void receive(@Payload String fileBody) {
        System.out.println("RECEBI ESSA MENSAGEM: "+fileBody);
    }
}
