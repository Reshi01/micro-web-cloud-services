package javeriana.ms.restador.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.restador.entities.SubstractionRecord;
import javeriana.ms.restador.dataaccess.SubstractionRecordRepository;


@Service
public class HistoryObtainer {
    
    @Autowired
    SubstractionRecordRepository repository;

    public List<SubstractionRecord> execute(){
        return repository.findAll();
    }

}
