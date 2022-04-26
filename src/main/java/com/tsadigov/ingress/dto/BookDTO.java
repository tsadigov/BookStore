package com.tsadigov.ingress.dto;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String bookName;
    private String bookDetails;
    private AppUserDTO author;

}
