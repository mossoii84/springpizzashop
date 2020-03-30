package com.example.springpizzashop.security.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class RegForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
