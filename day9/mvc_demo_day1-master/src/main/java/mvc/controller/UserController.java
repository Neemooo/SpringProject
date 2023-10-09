package mvc.controller;

import mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/result")
    public String goFormUser(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

//    @RequestMapping("/result")
//    public String processUser(User user, HttpSession session){
//        session.setAttribute("username",user.getName());
//        return "regisForm/userResult";
//    }
    
//    @RequestMapping("/session-test")
//    public String showSessionTest(Model model, HttpServletRequest request){
//      String username= (String) request.getSession().getAttribute("username");
//      model.addAttribute("username",username);
//      return "regisForm/session";
//    }
//
//
//
//    @RequestMapping("/remove-session")
//    public String removeSession(Model model, HttpServletRequest request){
//        request.getSession().removeAttribute("username");
//        return "redirect:/sessions";
//    }
}
