package net.travels.travels.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.travels.travels.Repository.UserRepo;
import net.travels.travels.entity.users;

import java.util.List;
import java.util.Optional;


@Component
public class UsersServices
{
    @Autowired
    private UserRepo UserRepo;


    public users Save_users(users users)
    {
        return UserRepo.save(users);
    }

    public List<users>get_All_users()
    {
        return UserRepo.findAll();
    }

    public Optional<users>get_user_byid(long id)
    {
        return UserRepo.findById(id);
    }

            public users findbyuser(String userName)
            {
                return UserRepo.findByuserName(userName);
            }

//    public Optional<users> login(String userName, String password)
//    {
//        Optional<users> user = UserRepo.findByUsername(userName);
//        return user.filter(u -> u.getPassword().equals(password));
//    }

    public void delete_user(long id)
    {
        UserRepo.deleteById(id);
    }
}
