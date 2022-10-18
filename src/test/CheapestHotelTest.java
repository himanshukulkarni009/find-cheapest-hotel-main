package test;

import main.Hotel;
import main.ReservationSystem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestHotelTest {

    @Test
    public void findCheapestHotel() {
        Hotel MiamiBeach = new Hotel(80, 80, "Miami Beach");
        Hotel MiamiDowntown = new Hotel(120, 120, "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(100, 100, "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel();
        assertEquals(MiamiBeach, cheapestHotel);
    }

    @Test
    public void hotelShouldGiveRateBasedOnWeekDay() {
        int baseRate = 80;
        int weekEndRate = 110;
        Hotel miamiBeach = new Hotel(baseRate, weekEndRate, "Miami Beach");

        LocalDate weekDay = LocalDate.of(2022, 10, 18);
        double calculatedRate = miamiBeach.getRate(weekDay);

        assertEquals(baseRate, calculatedRate);
    }

    @Test
    public void hotelShouldGiveRateBasedOnWeekendDay() {
        int baseRate = 80;
        int weekEndRate = 110;
        Hotel miamiBeach = new Hotel(baseRate, weekEndRate, "Miami Beach");

        LocalDate weekEndDay = LocalDate.of(2022, 10, 16);
        double calculatedRate = miamiBeach.getRate(weekEndDay);

        assertEquals(weekEndRate, calculatedRate);
    }

    @Test
    public void findCheapestHotelForWeekday() {
        LocalDate weekDay = LocalDate.of(2022, 10, 18);

        Hotel MiamiBeach = new Hotel(80, 110, "Miami Beach");
        Hotel MiamiDowntown = new Hotel(120, 90, "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(100, 150, "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(weekDay);
        assertEquals(MiamiBeach, cheapestHotel);
    }

    @Test
    public void findCheapestHotelForWeekend() {
        LocalDate weekEndDay = LocalDate.of(2022, 10, 16);

        Hotel MiamiBeach = new Hotel(80, 110, "Miami Beach");
        Hotel MiamiDowntown = new Hotel(120, 90, "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(100, 150, "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(weekEndDay);
        assertEquals(MiamiDowntown, cheapestHotel);
    }
    //Miami Beach has weekday rates 80$ and weekend rates 110$.
    //Miami Downtown has weekday rates 120$ and weekend rates 90$.
    //Miami Midtown has weekday rates 100$ and weekend rates 150$.
}
