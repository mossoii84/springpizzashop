package com.example.springpizzashop.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


@Data
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }
}
