package fp.stock.user;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user1){
        User user = new User();
        user.setName(user1.getName());
        user.setPassword(passwordEncoder.encode(user1.getPassword()));
        user.setFinancialResources(user1.getFinancialResources());

        user.setEnabled(1);
        userRepository.save(user);
    }

    public User findByName(String name){
       return userRepository.findByName(name);
    }

}
