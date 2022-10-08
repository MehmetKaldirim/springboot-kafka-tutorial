package com.zerotohero.controller;

import com.zerotohero.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

   private KafkaProducer kafkaProducer;

   public MessageController(KafkaProducer kafkaProducer) {
       this.kafkaProducer = kafkaProducer;
   }

   //http:localhost:8089/api/v1/kafka/publish?message= at cinegi
   @GetMapping("/publish")
   public ResponseEntity<String> publish (@RequestParam("message") String message){
       kafkaProducer.sendMessage(message);
       return ResponseEntity.ok("Message sent to the Topic in KAFKA");
   }

}
