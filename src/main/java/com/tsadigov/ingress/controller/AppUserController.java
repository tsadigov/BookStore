package com.tsadigov.ingress.controller;

import com.tsadigov.ingress.dao.AppUserRepo;
import com.tsadigov.ingress.dto.AppUserDTO;
import com.tsadigov.ingress.dto.ResponseDTO;
import com.tsadigov.ingress.dto.SignUpDTO;
import com.tsadigov.ingress.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tsadigov.ingress.bootstrap.Constants.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        AppUserDTO appUserDTO = userService.signUp(signUpDTO);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(CREATED_CODE)
                .message(CREATED)
                .response(appUserDTO)
                .build();

        return ResponseEntity.ok()
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getPublishers() {

        List<AppUserDTO> publishers = userService.getPublishers();
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS)
                .response(publishers)
                .build();

        return ResponseEntity.ok()
                .body(responseDTO);
    }
}