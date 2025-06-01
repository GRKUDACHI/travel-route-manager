package net.travels.travels.Repository;

import net.travels.travels.entity.TravelHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<TravelHistory,Long>
{

}
