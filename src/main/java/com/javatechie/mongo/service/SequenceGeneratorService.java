package com.javatechie.mongo.service;

import com.javatechie.mongo.entity.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {


    @Autowired
    private MongoOperations mongoOperations;
     
     /*
        collection_storing_db_sequence
        ----------
         _id (collectionId): 'user_sequence' (collectionIdVal)
         userId: 0 (generatedIdVal)
    */
    /**
     * @param collectionId 
     * @param generatedIdValue 
     * @param collectionIdVal 
     * @return
     */

    public int getSequenceNumber(String collectionId, String generatedIdValue, String collectionIdVal) {
        //get sequence no
        Query query = new Query(Criteria.where(collectionId).is(collectionIdVal));
        //update the sequence no
        Update update = new Update().inc(generatedIdValue, 1);
        //modify in document
        DbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequence.class);
        return Objects.isNull(counter) ? 1 : counter.getSeq();
    }
}
