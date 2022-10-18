package main;

import java.time.LocalDate;
import java.util.List;

public class ReservationSystem {
    private final List<Hotel> hotels;

    public ReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

/*    public Hotel findCheapestHotel() {
//        return hotels.stream().sorted(Comparator.comparingDouble(Hotel::getRate)).findFirst().get();
//        return hotels.stream().min(Comparator.comparingDouble(Hotel::getRate)).get();
        return hotels.stream().reduce((hotel1, hotel2) -> hotel1.getRegularWeekDay() < hotel2.getRegularWeekDay() ? hotel1 : hotel2).get();
    }*/

    public Hotel findCheapestHotel(LocalDate givenDay, CustomerType customerType) {
        return hotels.stream().reduce((hotel1, hotel2) -> hotel1.getRate(givenDay, customerType) < hotel2.getRate(givenDay, customerType) ? hotel1 : hotel2).get();
    }
}
