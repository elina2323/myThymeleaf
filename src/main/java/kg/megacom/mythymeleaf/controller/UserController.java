package kg.megacom.mythymeleaf.controller;

import kg.megacom.mythymeleaf.dao.UserDao;
import kg.megacom.mythymeleaf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userDao.index());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(@ModelAttribute("user") User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userDao.save(user);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        User user = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        model.addAttribute("user", userDao.show(id));
        return "update-user";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid @ModelAttribute("user") User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "update-user";
        }

        userDao.updateUser(id, user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDao.deleteUser(id);
        return "redirect:/index";
    }
}
