package ca.nsidetech.lab03.service;

import ca.nsidetech.lab03.entity.ReceiveMessage;
import ca.nsidetech.lab03.repository.ReceiveMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveMessageService {

    @Autowired
    private ReceiveMessageRepository receiveMessageRepository;

    public void saveReceiveMessage(ReceiveMessage receiveMessage) {
        receiveMessageRepository.save(receiveMessage);
    }

    public List<ReceiveMessage> getReceiveMessage() {
        return (List<ReceiveMessage>) receiveMessageRepository.findAll();
    }
}
