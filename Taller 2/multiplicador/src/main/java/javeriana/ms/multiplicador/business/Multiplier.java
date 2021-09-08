package javeriana.ms.multiplicador.business;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.multiplicador.dataaccess.MultiplicationRecordRepository;
import javeriana.ms.multiplicador.entities.MultiplicationRecord;
import javeriana.ms.multiplicador.serviceaccess.SumClient;

@Service
public class Multiplier {
    
    @Autowired
    MultiplicationRecordRepository repository;

    @Autowired
    SumClient sumClient;

    public int execute(int a, int b, String userName) {
        MultiplicationRecord record = new MultiplicationRecord(LocalDateTime.now(), userName);
        repository.save(record);
        boolean negative = false;
        if (b < 0) {
            b = -b;
            negative = true;
        }
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = sumClient.execute(result, a, userName);
        }
        if (negative) {
            result = -result;
        }
        return result;
    }
}
