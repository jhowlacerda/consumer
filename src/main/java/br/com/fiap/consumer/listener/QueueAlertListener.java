package br.com.fiap.consumer.listener;

import br.com.fiap.consumer.domain.ReportStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class QueueAlertListener {

    List<ReportStatus> listStatusAlert = new ArrayList<>();
    List<ReportStatus> listReportAlert = new ArrayList<>();

    @RabbitListener(queues = "${queue.alert}")
    public void receiveAlert(@Payload ReportStatus reportStatus) {
        log.info("Mensagem recebida: {}", reportStatus.toString());
        listStatusAlert.add(reportStatus);
    }

    @Scheduled(fixedRateString = "${queue.fixedRate}")
    public void prepareReport() {
        this.listReportAlert.clear();
        this.listReportAlert.addAll(this.listStatusAlert);
        this.listStatusAlert.removeAll(this.listReportAlert);
        //this.listStatusAlert.clear();
        sendReport();
    }

    public void sendReport() {
        Collections.sort(this.listReportAlert);
        log.info("Status recolhidos: " + this.listReportAlert.size());
        for(ReportStatus statusAlert: this.listReportAlert) {
            log.info(statusAlert.toString());
        }
    }

}
