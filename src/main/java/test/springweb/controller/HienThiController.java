package test.springweb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HienThiController {


    @RequestMapping({"/","index"})
    public String home(){
        return "index";
    }

    @RequestMapping("/test")
    public String index(){
        return "test";
    }
    @RequestMapping("/home")
    public String home1(){
        return "home";
    }
    @RequestMapping("/search-calculator")
    public String search_calculator(){
        return "search-calculator";
    }
    @RequestMapping("/search-info")
    public String search_info(){
        return "search-info";
    }
    @RequestMapping("/new")
    public String news(){
        return "new";
    }
    @RequestMapping("/question")
    public String question(){
        return "question";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/organizations-taxpayer")
    public String organizationsTaxpayer(){
        return "admin/organizations-taxpayer";
    }


}
