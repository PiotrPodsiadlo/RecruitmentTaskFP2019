package fp.stock.user;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user1){
        User user = new User();
        user.setName(user1.getName());
        user.setPassword(user1.getPassword());
        user.setFinancialResources(user1.getFinancialResources());

        user.setQuantityFP(user1.getQuantityFP());
        user.setQuantityFPA(user1.getQuantityFPA());
        user.setQuantityDL24(user1.getQuantityDL24());
        user.setQuantityFPC(user1.getQuantityFPC());
        user.setQuantityFPL(user1.getQuantityFPL());
        user.setQuantityPGB(user1.getQuantityPGB());
        userRepository.save(user);
    }

}
