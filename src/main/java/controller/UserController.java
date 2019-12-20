package controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String index(@NotNull Model model,
                        @NotNull Principal principal) {
        model.addAttribute("login", principal.getName());
        return "user/index";
    }
}