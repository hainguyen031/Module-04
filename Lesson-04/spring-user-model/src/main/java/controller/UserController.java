package controller;

import dao.UserDao;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home(@ModelAttribute("message") String message, RedirectAttributes redirectAttributes) {
        System.out.println(message);
        redirectAttributes.getAttribute("message");
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        Login login2= (Login) modelAndView.getModel().get("login");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDao.checkLogin(login);
        user=null;
        if(user == null){
            String message = "failed to login";
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            modelAndView.addObject("message",message);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
