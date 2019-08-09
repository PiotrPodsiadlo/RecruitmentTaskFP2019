package fp.stock.home;


import fp.stock.share.ShareRepository;
import fp.stock.share.ShareService;
import fp.stock.user.User;
import fp.stock.user.UserDto;
import fp.stock.user.UserRepository;
import fp.stock.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserService userService;
    private UserRepository userRepository;
    private ShareService shareService;
    private ShareRepository shareRepository;

    @Autowired
    public HomeController(UserService userService, UserRepository userRepository, ShareService shareService, ShareRepository shareRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.shareService = shareService;
        this.shareRepository = shareRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "userPanel";
    }


    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }
    @PostMapping("/create")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "registerForm";
        }
//        userService.save(user);
        return "userPanel";
    }


}
