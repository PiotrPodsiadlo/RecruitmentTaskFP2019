package fp.stock.share;


import fp.stock.user.UserRepository;
import fp.stock.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/share")
public class ShareController {

    private UserService userService;
    private UserRepository userRepository;
    private ShareService shareService;
    private ShareRepository shareRepository;

    @Autowired
    public ShareController(UserService userService, UserRepository userRepository, ShareService shareService, ShareRepository shareRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.shareService = shareService;
        this.shareRepository = shareRepository;
    }


    @GetMapping("/buy")
    public String buyShare() {
        return "confirmation";
    }

    @GetMapping("/sell")
    public String sellShare() {
        return "confirmation";
    }
}
