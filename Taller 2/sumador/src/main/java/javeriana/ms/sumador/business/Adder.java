package javeriana.ms.sumador.business;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.sumador.dataaccess.SumRecordRepository;
import javeriana.ms.sumador.entities.SumRecord;

@Service
public class Adder {
    
    @Autowired
    SumRecordRepository repository;

    public int execute(int a, int b, String userName) {
        SumRecord record = new SumRecord(LocalDateTime.now(), userName);
        repository.save(record);
        int result = a + b;
        return result;
    }
}
