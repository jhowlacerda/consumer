package br.com.fiap.scjr.rabbitconsumer.consumer;

import br.com.fiap.scjr.rabbitconsumer.tarefasAgendadas.ValidaTemperaturaUmidade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class QueueConsumer {


    public static final Logger log =LoggerFactory.getLogger(QueueConsumer.class);


    @RabbitListener(queues = "${queue.fiap}")
    public void receiveMessage(@Payload String fileBody){
        ValidaTemperaturaUmidade a = new ValidaTemperaturaUmidade();
    }

    }


