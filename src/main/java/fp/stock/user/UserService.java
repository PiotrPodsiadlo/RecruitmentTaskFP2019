package fp.stock.user;


import fp.stock.role.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
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
        user.setQuantityFP(user1.getQuantityFP());
        user.setQuantityFPA(user1.getQuantityFPA());
        user.setQuantityDL24(user1.getQuantityDL24());
        user.setQuantityFPC(user1.getQuantityFPC());
        user.setQuantityFPL(user1.getQuantityFPL());
        user.setQuantityPGB(user1.getQuantityPGB());
        user.setEnabled(1);
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        Role userRole = new Role();
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public User findByName(String name){
       return userRepository.findByName(name);
    }

}
