package net.travels.travels.controller;

import net.travels.travels.entity.TravelHistory;
import net.travels.travels.service.TrvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/TravelHistory")
@CrossOrigin(origins = "*")
public class Travelcontroller
{
    @Autowired
    private TrvelService TrvelService;

    @PostMapping
    public ResponseEntity<String> Save_travel(@RequestBody TravelHistory TravelHistory)
    {
        TrvelService.Save_travels(TravelHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");

    }

    @GetMapping
    public List<TravelHistory> get_travel()
    {
        List<TravelHistory> history_list = TrvelService.getAll();
        history_list.sort(Comparator.comparingLong(TravelHistory::getId));
        return history_list;
    }

    @GetMapping("id/{myid}")
    public Optional<TravelHistory>get_travel_byid(@PathVariable long myid)
    {
        return TrvelService.get_travel_byid(myid);
    }

    @PutMapping("id/{myid}")
    public boolean update_travel(@PathVariable long myid, @RequestBody TravelHistory TravelHistory)
    {
        TravelHistory old_travelData = TrvelService.get_travel_byid(myid).orElse(null);

        if(old_travelData != null)
        {
            old_travelData.setTravelerName(TravelHistory.getTravelerName());
            old_travelData.setDestination(TravelHistory.getDestination());
            old_travelData.setSource(TravelHistory.getSource());
            old_travelData.setModeOfTransport(TravelHistory.getModeOfTransport());
            old_travelData.setTravelDate(TravelHistory.getTravelDate());
            old_travelData.setDistance(TravelHistory.getDistance());
            old_travelData.setCost(TravelHistory.getCost());
            old_travelData.setPurpose(TravelHistory.getPurpose());


            TrvelService.Save_travels(old_travelData);
            return  true;
        }
        else
        {
            return false;
        }
    }

    @DeleteMapping("id/{myid}")
    public boolean delete_travel(@PathVariable long myid)
    {
        TrvelService.Delete_travel(myid);
        return true;
    }



}
