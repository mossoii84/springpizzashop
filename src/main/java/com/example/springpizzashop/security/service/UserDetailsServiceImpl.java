package com.example.springpizzashop.security.service;

import com.example.springpizzashop.security.model.User;
import com.example.springpizzashop.security.model.UserPrincipal;
import com.example.springpizzashop.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;
    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(s);
        if (user == null)
        throw new UsernameNotFoundException("User with name\"" + s + "\" not found");
        return UserPrincipal.build(user);
    }
}


