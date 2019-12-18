package controller;

import exception.UserIdNotFoundException;
import model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(@NotNull Model model) {
        model.addAttribute("userList", userService.findAll());
        return "admin/userList";
    }

    @GetMapping("/add")
    public String add() {
        return "admin/userAdd";
    }

    @PostMapping("/add")
    public String add(@RequestParam(name = "login") String login,
                      @RequestParam(name = "name") String name,
                      @RequestParam(name = "password") String password) {
        if (!userService.existsByLogin(login)) {
            User user = new User(login, name, password);
            userService.save(user);
        }
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @NotNull Model model) {
        User user = userService.findById(id)
                .orElseThrow(UserIdNotFoundException::new);

        model.addAttribute("user", user);
        return "admin/userEdit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       @RequestParam(name = "login") String login,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "password") String password) {
        User user = userService.findById(id)
                .orElseThrow(UserIdNotFoundException::new);

        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);

        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}