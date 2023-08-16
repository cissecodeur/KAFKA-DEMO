package com.sid.services;

import com.sid.dtos.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String , Object> kafkaTemplate;

    public void sendMessageToTopic(String message){
     CompletableFuture<SendResult<String,Object>> completableFuture = kafkaTemplate.send("new-topic-from-code",message);
        completableFuture.whenComplete((result,ex)->{
                     if(ex == null){
                         System.out.println("message envoyé [" + message  + "] , with offset [" + result.getRecordMetadata().offset());
                     }
                     else{
                         System.out.println("Erreur du message" + ex.getMessage()  );
                     }
        });
    }



    public void sendMessageToTopicWithPartitions(String message){
        CompletableFuture<SendResult<String,Object>> completableFuture = kafkaTemplate.send("new-topic-from-code",message);
        completableFuture.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("message envoyé [" + message  + "] , with offset [" + result.getRecordMetadata().offset());
            }
            else{
                System.out.println("Erreur du message" + ex.getMessage()  );
            }
        });
    }


    public void sendCustomerToTopicWithPartitions(Customer customer){
        CompletableFuture<SendResult<String,Object>> completableFuture = kafkaTemplate.send("new-topic-from-code-2",customer);
        completableFuture.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("message envoyé [" + customer.toString()  + "] , with offset [" + result.getRecordMetadata().offset());
            }
            else{
                System.out.println("Erreur du message" + ex.getMessage()  );
            }
        });
    }
}
