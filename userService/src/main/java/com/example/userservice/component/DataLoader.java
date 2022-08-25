package com.example.userservice.component;

import com.example.userservice.entity.*;
import com.example.userservice.repository.CategoryRepository;
import com.example.userservice.repository.ProductRepository;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Value("${spring.sql.init.mode}")
    private String mode;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")){
            Role user = roleRepository.save(new Role(1L, "USER", false, true, null));
            Category category = categoryRepository.save(new Category(1L, "Lavash", false, true, null, null));
            productRepository.save(new Product(1L,"Sirli Lavash",false,true,category,null,26000D,"Zor",null));
            userRepository.save(new User(1L,false,true,null,null,"+998900108665","123","Ismoil Nigmatov",5,null,null,null,true,false,false,false,user));
        }
    }
}
