package fp.stock.user;


import fp.stock.restScheduler.StockFixtures;
import fp.stock.share.Share;
import fp.stock.share.ShareRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ShareRepository shareRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, ShareRepository shareRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.shareRepository = shareRepository;
    }

    public void save(User user1){
        User user = new User();
        user.setName(user1.getName());
        user.setPassword(passwordEncoder.encode(user1.getPassword()));
        user.setFinancialResources(user1.getFinancialResources());

        user.setEnabled(1);
        userRepository.save(user);
    }

    public void update(User user1, UserDetails customUser){
        User user = findByName(customUser.getUsername());
//        user.setId(user1.getId());
        user.setName(user1.getName());
        user.setPassword(passwordEncoder.encode(user1.getPassword()));
        user.setFinancialResources(user1.getFinancialResources());

        user.setEnabled(1);
        userRepository.save(user);
    }


    public User findByName(String name){
       return userRepository.findByName(name);
    }


    public boolean buyShares(User user, Share share){
        if(share.getQuantity()>0 && user.getFinancialResources()>=share.getUnitPrice()) {
            user.addShares(share);
            user.setFinancialResources(user.getFinancialResources()-share.getUnitPrice());
            share.setQuantity(share.getQuantity()-1);
            userRepository.save(user);
            shareRepository.save(share);
            return true;
        }else{
           return false;
        }
    }


    public void sellShares(User user, Share share){

        List<Share> shareList = user.getShares();
        shareList.remove(share);
        user.setShares(shareList);

        user.setFinancialResources(user.getFinancialResources()+share.getUnitPrice());
        share.setQuantity(share.getQuantity()+1);
        userRepository.save(user);
        shareRepository.save(share);

    }
    @Scheduled(fixedRate = 2000)
    public void dupa(){
        RestTemplate restTemplate = new RestTemplate();
        StockFixtures stockFixtures = restTemplate.getForObject("http://webtask.future-processing.com:8068/stocks", StockFixtures.class);
        System.out.println(stockFixtures.getItems());

    }

}
