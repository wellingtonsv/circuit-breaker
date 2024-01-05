package com.vieira.publication.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationRequest {

    @NotBlank
    private String title;

    private String imageUrl;

    @NotBlank
    private String text;
}
