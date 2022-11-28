package br.com.fiap.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
@Slf4j
public class EnvioEmail implements CommandLineRunner{

    private final EnviaEmailService enviaEmailService;

    public EnvioEmail(EnviaEmailService enviaEmailService) {
        this.enviaEmailService = enviaEmailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EnvioEmail.class, args);
    }


@Override
public void run(String... args) throws MessagingException {
        enviaEmailService.enviar("jonatha.lacerda@outlook.com", "FELTEX - Serviço de Email",
                "Conteúdo do email aqui!");
    }
}
