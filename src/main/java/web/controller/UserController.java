package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printListUsers(ModelMap model) {
        // получим всех людей
        model.addAttribute("users", userService.getAllUsers());
        return "helloList";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model) {
        // получим 1 чела по айди
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String create(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute(userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
