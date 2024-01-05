package com.vieira.publication.mapper;

import com.vieira.publication.controller.request.PublicationRequest;
import com.vieira.publication.domain.Publication;
import com.vieira.publication.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);

    Publication toPublication(PublicationRequest publicationRequest);

}
