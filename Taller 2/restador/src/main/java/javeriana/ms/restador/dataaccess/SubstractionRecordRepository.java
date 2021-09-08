package javeriana.ms.restador.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import javeriana.ms.restador.entities.SubstractionRecord;

public interface SubstractionRecordRepository extends MongoRepository<SubstractionRecord, String> {
    
}
