package br.com.fiap.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class QueueAlertListener {

    List<Message> listStatusAlert = new ArrayList<>();
    List<Message> listReportAlert = new ArrayList<>();

    @RabbitListener(queues = "${queue.alert}")
    public void receiveAlert(Message reportStatus) {
        log.info("Mensagem recebida: {}", reportStatus.toString());
        listStatusAlert.add(reportStatus);
    }

    @Scheduled(fixedRateString = "${queue.fixedRate}")
    public void prepareReport() {
        this.listReportAlert.clear();
        for(Message statusAlert: this.listStatusAlert) {
            this.listReportAlert.add(statusAlert);
            //this.listStatusAlert.remove(statusAlert); // FIXME Concurrency access!
        }
        sendReport();
    }

    public void sendReport() {
        //Collections.sort(this.listReportAlert);   // TODO É necessário ordenar os dados por drone?
        log.info("Status recolhidos: " + this.listReportAlert.size());
        for(Message statusAlert: this.listReportAlert) {
            log.info(statusAlert.toString());
        }
    }

}
