package javeriana.ms.sumador.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;

import javeriana.ms.sumador.entities.SumRecord;

public interface SumRecordRepository extends MongoRepository<SumRecord, String> {
    
}
