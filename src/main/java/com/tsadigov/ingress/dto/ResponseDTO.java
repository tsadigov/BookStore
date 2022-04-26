package com.tsadigov.ingress.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDTO {
    private Integer code;
    private String message;
    private Object response;
}
