package javeriana.ms.restador.business;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.restador.dataaccess.SubstractionRecordRepository;
import javeriana.ms.restador.entities.SubstractionRecord;

@Service
public class Substracter {
    
    @Autowired
    SubstractionRecordRepository repository;

    public int execute(int a, int b, String userName) {
        SubstractionRecord record = new SubstractionRecord(LocalDateTime.now(), userName);
        repository.save(record);
        int result = a - b;
        return result;
    }
}
