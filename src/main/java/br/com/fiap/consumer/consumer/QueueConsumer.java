package br.com.fiap.consumer.consumer;

import br.com.fiap.consumer.tarefasAgendadas.ValidaTemperaturaUmidade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {


    public static final Logger log =LoggerFactory.getLogger(QueueConsumer.class);


    @RabbitListener(queues = "${queue.fiap}")
    public void receiveMessage(@Payload String fileBody){
        ValidaTemperaturaUmidade a = new ValidaTemperaturaUmidade();
    }

    }


