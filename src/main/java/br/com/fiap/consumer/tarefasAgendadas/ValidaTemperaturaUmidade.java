package br.com.fiap.consumer.tarefasAgendadas;

import br.com.fiap.consumer.consumer.QueueConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ValidaTemperaturaUmidade {
    Random temperaturaaleatoria = new Random();
    Random umidadealeatoria = new Random();
    int id_drone = 1;
    public static final Logger log =LoggerFactory.getLogger(QueueConsumer.class);

    @Scheduled(fixedRate = 4000)
  public void verificaTemperaturaUmidade(){
      float temperatura = temperaturaaleatoria.nextFloat()*50-20;
      float umidade = umidadealeatoria.nextFloat()*40-20;
      if((temperatura >= 35 || temperatura <= 0)||(umidade <= 15)){
          log.info("Temperatura: "+temperatura + " Umidade: "+ umidade+" ID Drone: "+ id_drone);

      }
  }
}
