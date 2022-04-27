package com.tsadigov.ingress.service;

import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.dto.AppUserDTO;
import com.tsadigov.ingress.dto.ResponseDTO;
import com.tsadigov.ingress.dto.SignUpDTO;

public interface AppUserService {

    void addRoleToUser(String username, String roleName);
    AppUserDTO signUp(SignUpDTO signUpDTO);

}
