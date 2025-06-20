package net.travels.travels.Repository;

import net.travels.travels.entity.TravelHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRepo extends JpaRepository<TravelHistory,Long>
{
    List<TravelHistory> findByUserId(Long userId);
}
