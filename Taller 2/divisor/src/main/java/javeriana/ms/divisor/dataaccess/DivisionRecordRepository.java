package javeriana.ms.divisor.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import javeriana.ms.divisor.entities.DivisionRecord;


public interface DivisionRecordRepository extends MongoRepository<DivisionRecord, String> {
    
}
