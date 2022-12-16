package ca.nsidetech.lab03.service;

import ca.nsidetech.lab03.entity.Give;
import ca.nsidetech.lab03.repository.GiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GiveService {
    @Autowired
    private GiveRepository giveRepository;

    public void saveGive(Give give) {
        giveRepository.save(give);
    }

    public List<Give> getGive() {
        return (List<Give>) giveRepository.findAll();
    }
}

