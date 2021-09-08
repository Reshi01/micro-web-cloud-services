package javeriana.ms.multiplicador.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.multiplicador.dataaccess.MultiplicationRecordRepository;
import javeriana.ms.multiplicador.entities.MultiplicationRecord;


@Service
public class HistoryObtainer {
    
    @Autowired
    MultiplicationRecordRepository repository;

    public List<MultiplicationRecord> execute(){
        return repository.findAll();
    }

}
