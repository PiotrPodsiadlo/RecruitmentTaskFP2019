package fp.stock.home;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "userPanel";
    }



    @GetMapping("/create")
    public String createUser() {
        return "registerForm";
    }
    @PostMapping("/create")
    public String addUser() {
        return "userPanel";
    }


}
