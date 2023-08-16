package com.sid.controllers;


import com.sid.dtos.Customer;
import com.sid.services.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
   private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable  String message) {
        try {
            kafkaMessagePublisher.sendMessageToTopic(message);
            return ResponseEntity.ok("Operation effectué avec succès");
        } catch (Exception ex) {
            return ResponseEntity.ok("Erreur lors de la requete" + ex.getMessage());
        }
    }

        @GetMapping("/publishBulkMessage/{message}")
        public ResponseEntity<?> publishBulkMessage(@PathVariable  String message){
            try{
                for (int i= 0 ; i<10000;i++){
                    kafkaMessagePublisher.sendMessageToTopicWithPartitions(message + i);
                }

                return  ResponseEntity.ok("Operation effectué avec succès");
            }
            catch (Exception ex){
                return  ResponseEntity.ok("Erreur lors de la requete"+ ex.getMessage());
            }

        }


    @PostMapping("/publish/customer")
    public ResponseEntity<?> publishCustomer(@RequestBody Customer customer) {
        try {
            kafkaMessagePublisher.sendCustomerToTopicWithPartitions(customer);
            return ResponseEntity.ok("Operation effectué avec succès");
        } catch (Exception ex) {
            return ResponseEntity.ok("Erreur lors de la requete" + ex.getMessage());
        }
    }
}
