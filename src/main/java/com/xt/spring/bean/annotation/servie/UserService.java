package com.xt.spring.bean.annotation.servie;

import com.xt.spring.bean.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;

    public void add() {
        System.out.println("UserService add ...");
        userRepository.save();
    }

}
