package net.journal.journalApp.repository;

import net.journal.journalApp.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {
}
