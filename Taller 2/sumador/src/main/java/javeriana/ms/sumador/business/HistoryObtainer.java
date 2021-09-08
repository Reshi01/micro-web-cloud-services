package javeriana.ms.sumador.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.sumador.dataaccess.SumRecordRepository;
import javeriana.ms.sumador.entities.SumRecord;

@Service
public class HistoryObtainer {
    
    @Autowired
    SumRecordRepository repository;

    public List<SumRecord> execute(){
        return repository.findAll();
    }

}
