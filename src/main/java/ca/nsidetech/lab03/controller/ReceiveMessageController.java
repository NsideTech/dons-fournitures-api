package ca.nsidetech.lab03.controller;

import ca.nsidetech.lab03.entity.ReceiveMessage;
import ca.nsidetech.lab03.service.ReceiveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ReceiveMessageController {

    @Autowired
    private ReceiveMessageService receiveMessageService;

    @GetMapping(value = "/allMessages")
    public ResponseEntity<List<ReceiveMessage>> getReceiveMessage() {
        List<ReceiveMessage> receiveMessages = receiveMessageService.getReceiveMessage();
        return ResponseEntity.ok().body(receiveMessages);
    }


    @PostMapping(value = "/messages")
    public ResponseEntity<Object> saveReceiveMessage(@RequestBody ReceiveMessage receiveMessage) {
        receiveMessageService.saveReceiveMessage(receiveMessage);

        String message = "Mr/Mmme" + receiveMessage.getNom() + "Votre message a été envoyé ";
        return ResponseEntity.ok().body(message);
    }
}
