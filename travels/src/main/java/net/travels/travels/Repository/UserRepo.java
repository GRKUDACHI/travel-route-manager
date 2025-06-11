package net.travels.travels.Repository;

import net.travels.travels.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<users, Long>
{
    users findByuserName (String username);

//    Optional<users> findByUsername(String username);
}
