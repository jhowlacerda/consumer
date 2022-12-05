# CONSUMER

---

## OVERVIEW

![Overview](docs/images/overview.PNG)

---

### GRUPO

- RM346315: Lais Kagawa
- RM346511: Jônatha Lacerda Gonzaga
- RM346958: Thiago de Souza Zanella
- <del> RM347277: Gustavo de Oliveira Freitas</del> (Desistiu do curso)

---

### REPOSITÓRIOS RELACIONADOS

- https://github.com/lakagawa/drone
- https://github.com/zanella86/producer

---

### FERRAMENTAS DE INTEGRAÇÃO

- Slack
- Github
- Trello
- RabbitMQ
- Draw.io

---

## PARA TESTAR

### Configure o ambiente

#### Versão do java
![JDK](docs/images/config_java.PNG)

#### Execução com o spring boot/maven
![Maven](docs/images/config_maven.PNG)


#### RabbitMQ 

Verifique os procedimentos descritos em "RabbitMQ" no repositório [producer](https://github.com/zanella86/producer).


##### Configure o endereço do broker

No arquivo [application.yml](src/main/resources/application.yml) preencha o valor do atributo 
`spring.rabbitmq.addresses`


#### Execute o teste!

Verifique os procedimentos descritos em "Execute o teste!" no repositório [producer](https://github.com/zanella86/producer).


---

### Resultado esperado

#### Relatório de alertas

![AlertReport](docs/images/result_report_alerts01.PNG)
![AlertReport](docs/images/result_report_alerts02.PNG)

--- 

#### REFERÊNCIAS

- [CloudAMQP - RabbitMQ](https://customer.cloudamqp.com/instance/)
- [Draw.io](https://app.diagrams.net)
