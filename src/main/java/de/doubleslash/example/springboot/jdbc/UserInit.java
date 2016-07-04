package de.doubleslash.example.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import de.doubleslash.example.springboot.jdbc.User.Role;

@Component
public class UserInit implements CommandLineRunner {

   @Autowired
   private UserRepository userRepo;

   @Override
   public void run(final String... args) throws Exception {
      
	   // create a user
	   final User user = new User("ben",
            // Passwort hashen
            new BCryptPasswordEncoder().encode("jdbc"), //
            true, Role.USER);
      userRepo.save(user);
 
   }
   

}
