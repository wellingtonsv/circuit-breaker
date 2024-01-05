package com.vieira.publication.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "publications")
public class PublicationEntity {
    @MongoId
    private String id;

    private String title;

    private String ImageUrl;

    private String text;
}
