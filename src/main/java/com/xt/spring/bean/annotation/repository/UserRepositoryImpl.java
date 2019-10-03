package com.xt.spring.bean.annotation.repository;


import com.xt.spring.bean.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository(value = "userRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired(required = false)
    private TestObject testObject;
    public void save() {
        System.out.println("UserRepositoryImpl save ...");
        System.out.println(testObject);
    }
}
