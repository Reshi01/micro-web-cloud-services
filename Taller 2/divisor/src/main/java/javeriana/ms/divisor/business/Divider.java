package javeriana.ms.divisor.business;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.divisor.dataaccess.DivisionRecordRepository;
import javeriana.ms.divisor.entities.DivisionRecord;

@Service
public class Divider {
    
    @Autowired
    DivisionRecordRepository repository;

    public int execute(int a, int b, String userName) {
        DivisionRecord record = new DivisionRecord(LocalDateTime.now(), userName);
        repository.save(record);
        int result = a / b;
        return result;
    }
}
