package net.travels.travels.controller;

import net.travels.travels.entity.users;
import net.travels.travels.service.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class usercontroller
{
   @Autowired
   private UsersServices UsersServices;

   @PostMapping
    public  boolean Save_users(@RequestBody  users users)
   {
       UsersServices.Save_users(users);
       return true;
   }

   @GetMapping
   public List<users> get_all_users()
   {
       return UsersServices.get_All_users();
   }

   @GetMapping("id/Myid")
    public Optional<users>user_byid(@PathVariable long Myid)
   {
       return UsersServices.get_user_byid(Myid);
   }

   @PutMapping("/{username}")
    public boolean update_user(@RequestBody users users, @PathVariable String userName)
   {
       users userdb = UsersServices.findbyuser(userName);

       if(userdb != null)
       {
           userdb.setUserName(users.getUserName());
           userdb.setPassword(users.getPassword());

           UsersServices.Save_users(userdb);
           return true;
       }
       else
       {
           return false;
       }
   }

   @DeleteMapping("id/myid")
    public boolean delete_user(@PathVariable long myid)
   {
       UsersServices.delete_user(myid);
       return true;
   }

    //    @PostMapping("/register")
    //    public ResponseEntity register(@RequestBody users user)
    //    {
    //        return ResponseEntity.ok(UsersServices.Save_users(user));
    //    }

    //    @PostMapping("/login")
    //    public ResponseEntity<String> login(@RequestBody users user)
    //    {
    //        Optional<users> validUser = UsersServices.login(user.getUserName(), user.getPassword());
    //        if (validUser.isPresent())
    //        {
    //            return ResponseEntity.ok("Login successful! User ID: " + validUser.get().getId());
    //        }
    //        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    //    }
}
