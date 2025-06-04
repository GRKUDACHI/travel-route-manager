package net.travels.travels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "travel_history")
public class TravelHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String travelerName;
    private String destination;
    private String source;
    private LocalDate travelDate;
    private String modeOfTransport; // e.g., Bus, Train, Flight
    private double distance; // in kilometers
    private double cost;

    private String purpose; // Business, Vacation, etc.

    // Optional: Timestamps
    private LocalDate createdAt;
    private LocalDate updatedAt;

//    public TravelHistory() {}

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

     public Long getId()
    {
        return id;
    }
}
