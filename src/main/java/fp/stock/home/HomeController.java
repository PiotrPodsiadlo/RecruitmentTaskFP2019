package fp.stock.home;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
   // @ResponseBody
    public String home() {
        log.info("info");
        log.warn("warn");
        return "home";
    }

}
