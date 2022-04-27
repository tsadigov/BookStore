package com.tsadigov.ingress.dto;

import lombok.Data;

@Data
public class BookAndPublisherDTO {

    private Long id;
    private String bookName;
    private String bookDetails;
    private String author;
    private AppUserDTO publisher;

}
