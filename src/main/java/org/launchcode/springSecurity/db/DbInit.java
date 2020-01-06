package org.launchcode.springSecurity.db;

import org.launchcode.springSecurity.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args)  {

        this.userRepository.deleteAll();

        User brewer = new User("brewer", passwordEncoder.encode("Holiday12806!"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");


        List<User> users = Arrays.asList(brewer,admin,manager);

        this.userRepository.saveAll(users);



    }
}
