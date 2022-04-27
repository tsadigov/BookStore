package com.tsadigov.ingress.dto;

import com.tsadigov.ingress.utils.Validator;
import lombok.Data;
import org.springframework.security.authentication.BadCredentialsException;

import static com.tsadigov.ingress.bootstrap.Constants.WRONG_EMAIL_FORMAT;

@Data
public class SignUpDTO {

    private String username;
    private String email;
    private String password;
    private String name;

    public void setEmail(String email) {
        Boolean isValid = Validator.isValidEmailFormat(email);
        if (isValid)
            this.email = email;
        else
            throw new BadCredentialsException(WRONG_EMAIL_FORMAT);
    }
}
