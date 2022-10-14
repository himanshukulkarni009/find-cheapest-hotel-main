package main;

import java.util.Comparator;
import java.util.List;

public class ReservationSystem {
    private final List<Hotel> hotels;

    public ReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Hotel findCheapestHotel() {
        return hotels.stream().sorted(Comparator.comparingDouble(Hotel::getRate)).findFirst().get();
    }
}
