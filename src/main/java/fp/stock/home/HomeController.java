package fp.stock.home;


import fp.stock.share.Share;
import fp.stock.share.ShareRepository;
import fp.stock.share.ShareService;
import fp.stock.user.User;
import fp.stock.user.UserRepository;
import fp.stock.user.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        userService.save(user);
        return "home";
    }

    @GetMapping("/admin")
    public String userInfo(@AuthenticationPrincipal UserDetails customUser, Model model) {
        User user = userService.findByName(customUser.getUsername());
        model.addAttribute("user", customUser);
        model.addAttribute("realUser", user);
        model.addAttribute("shares", shareRepository.findAll());
        return "userPanel";

    }


    @PostMapping("/buy/{id}")
    public String buyStock(@PathVariable Long id, @AuthenticationPrincipal UserDetails customUser, Model model) {
        Share share = shareRepository.getOne(id);
        User user = userService.findByName(customUser.getUsername());
        userService.buyShares(user, share);
        return "redirect:/admin";
    }

    @PostMapping("/sell/{id}")
    public String sellStock(@PathVariable Long id, @AuthenticationPrincipal UserDetails customUser, Model model) {
        Share share = shareRepository.getOne(id);
        User user = userService.findByName(customUser.getUsername());
        userService.sellShares(user, share);
        return "redirect:/admin";
    }



}
