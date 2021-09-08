package javeriana.ms.divisor.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.divisor.dataaccess.DivisionRecordRepository;
import javeriana.ms.divisor.entities.DivisionRecord;

@Service
public class HistoryObtainer {
    
    @Autowired
    DivisionRecordRepository repository;

    public List<DivisionRecord> execute(){
        return repository.findAll();
    }

}
