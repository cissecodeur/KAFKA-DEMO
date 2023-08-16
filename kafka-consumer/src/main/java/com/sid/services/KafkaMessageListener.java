package com.sid.services;


import com.sid.dtos.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
     Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);



     // Je cree les consumers devant appartenir a un meme group
 /*   @KafkaListener(topics = "new-topic-from-code", groupId = "new-topic-from-code-GID")
    public void consume1(String message){
        log.info("Consommation1 du message {} : " + message);

    }
    @KafkaListener(topics = "new-topic-from-code", groupId = "new-topic-from-code-GID")
    public void consume2(String message){
        log.info("Consommation2 du message {} : " + message);

    }

    @KafkaListener(topics = "new-topic-from-code", groupId = "new-topic-from-code-GID")
    public void consume3(String message){
        log.info("Consommation3 du message {} : " + message);

    }

    @KafkaListener(topics = "new-topic-from-code", groupId = "new-topic-from-code-GID")
    public void consume4(String message){
        log.info("Consommation4 du message {} :" + message);

    }

    @KafkaListener(topics = "new-topic-from-code", groupId = "new-topic-from-code-GID")
    public void consume5(String message){
        log.info("Consommation5 du message {} : " + message);

    }


  */

    @KafkaListener(topics = "new-topic-from-code-2", groupId = "new-topic-from-code-GID-2")
    public void consumeCustomerEvent(Customer customer){
        log.info("Consommation du message {} : " + customer);

    }


}
