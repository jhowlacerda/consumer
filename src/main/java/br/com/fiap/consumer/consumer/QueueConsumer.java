package br.com.fiap.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class QueueConsumer {


    public static final Logger log =LoggerFactory.getLogger(QueueConsumer.class);
    ArrayList<String> dadosqueue = new ArrayList();
    Random temperaturaaleatoria = new Random();
    Random umidadealeatoria = new Random();
    int id_drone = 1;

   @RabbitListener(queues = "${queue.drone}")
    public void receiveMessage(@Payload String fileBody){
        dadosqueue.add(fileBody);
    }

    @Scheduled(fixedRate = 4000)
    public void Relatório(){
        float temperatura = temperaturaaleatoria.nextFloat()*50-20;
        float umidade = umidadealeatoria.nextFloat()*40-20;
        for (int i = 0; i<dadosqueue.size(); i++){
        log.info("Dados do drone: " + dadosqueue.get(i) +  "Temperatura: "+temperatura + " Umidade: "+ umidade+" ID Drone: "+ id_drone);
        }

    }


    }


