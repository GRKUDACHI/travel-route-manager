package net.journal.journalApp.controller;

import net.journal.journalApp.entity.journalEntry;
import net.journal.journalApp.entity.user;
import net.journal.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Users")
public class UsersController
{
    @Autowired
    private UserService UserService;

    @GetMapping
    public List<user> getAll()
    {
        return UserService.getAll();
    }

    @PostMapping
    public boolean creatuser(@RequestBody  user user)
    {
        UserService.saveUser(user);
        return true;
    }

    @GetMapping("id/{myId}")
    public user getUserServiceById(@PathVariable Long myId)
    {
        return UserService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteuserByid(@PathVariable long myId)
    {
        UserService.deleteById(myId);
        return true;
    }
}
