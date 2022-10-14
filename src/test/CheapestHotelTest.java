package test;

import main.Hotel;
import main.ReservationSystem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestHotelTest {

    @Test
    public void findCheapestHotel(){
        Hotel MiamiBeach = new Hotel(80, "Miami Beach");
        Hotel MiamiDowntown = new Hotel(120, "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(100, "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel();
        assertEquals(MiamiBeach, cheapestHotel);
    }
}
