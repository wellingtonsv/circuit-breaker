package com.vieira.publication.repository;

import com.vieira.publication.repository.entity.PublicationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends MongoRepository<PublicationEntity,String> {
}
