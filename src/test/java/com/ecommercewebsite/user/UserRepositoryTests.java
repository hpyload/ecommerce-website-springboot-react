package com.ecommercewebsite.user;

import com.ecommercewebsite.entity.user.Role;
import com.ecommercewebsite.entity.user.User;
import com.ecommercewebsite.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUser() {
        Role roleAdmin = entityManager.find(Role.class, 1);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Lavish");
        user.setEmail("john@gmail.com");
        user.setPassword("password");
        user.addRole(null);

        User savedUser = userRepository.save(user);

        //Complete the tests
    }

}
