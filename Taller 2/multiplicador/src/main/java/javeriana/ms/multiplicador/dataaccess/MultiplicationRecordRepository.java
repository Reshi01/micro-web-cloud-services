package javeriana.ms.multiplicador.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import javeriana.ms.multiplicador.entities.MultiplicationRecord;


public interface MultiplicationRecordRepository extends MongoRepository<MultiplicationRecord, String> {
    
}
