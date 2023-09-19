package mvc.controller;

import mvc.model.Gender;
import mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final String[] countries={"Vietnam", "United States", "Germany"};

    @RequestMapping(value = "/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("countries", countries);
        return "User/Form";
    }

    @RequestMapping(value = "/result")
    public String processUser(User user){
        return "User/Result";
    }
}
