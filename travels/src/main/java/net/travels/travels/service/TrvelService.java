package net.travels.travels.service;
import jdk.dynalink.linker.LinkerServices;
import net.travels.travels.Repository.TravelRepo;

import net.travels.travels.entity.TravelHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class TrvelService
{
    @Autowired
    private TravelRepo TravelRepo;

    public TravelHistory Save_travels(TravelHistory TravelHistory)
    {
        if (TravelHistory.getTravelDate() == null)
        {
            TravelHistory.setTravelDate(LocalDate.now());
        }
        return TravelRepo.save(TravelHistory);
    }

    public List<TravelHistory> getAll()
    {
        return TravelRepo.findAll();
    }

    public Optional<TravelHistory> get_travel_byid(long id)
    {
        return TravelRepo.findById(id);
    }

    public boolean Delete_travel(long id)
    {
        TravelRepo.deleteById(id);
        return  true;
    }
}
