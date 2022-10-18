package test;

import main.CustomerType;
import main.Hotel;
import main.HotelRates;
import main.ReservationSystem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestHotelTest {

/*    @Test
    public void findCheapestHotel() {
        Hotel MiamiBeach = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 80, 80)), "Miami Beach");
        Hotel MiamiDowntown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 120, 120)), "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 100, 100)), "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel();
        assertEquals(MiamiBeach, cheapestHotel);
    }*/

    /*@Test
    public void hotelShouldGiveRateBasedOnWeekDay() {
        double baseRate = 80;
        double weekEndRate = 110;
        Hotel miamiBeach = new Hotel(baseRate, weekEndRate, "Miami Beach");

        LocalDate weekDay = LocalDate.of(2022, 10, 18);
        double calculatedRate = miamiBeach.getRate(weekDay);

        assertEquals(baseRate, calculatedRate);
    }

    @Test
    public void hotelShouldGiveRateBasedOnWeekendDay() {
        double baseRate = 80;
        double weekEndRate = 110;
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
    }*/

    @Test
    public void calculateRatesBasedOnRegularCustomerTypeAndWeekday() {
        HotelRates hotelRatesRegularCustomer = new HotelRates(CustomerType.REGULAR, 80, 110);
        HotelRates hotelRatesRewardedCustomer = new HotelRates(CustomerType.REWARD, 50, 90);

        Hotel miamiBeach = new Hotel(Arrays.asList(hotelRatesRegularCustomer, hotelRatesRewardedCustomer), "Miami Beach");

        LocalDate weekDay = LocalDate.of(2022, 10, 18);
        double calculatedRate = miamiBeach.getRate(weekDay, CustomerType.REGULAR);

        assertEquals(80, calculatedRate);
    }


    @Test
    public void findCheapestHotelForRegularCustomerAndWeekend() {
        LocalDate weekEndDay = LocalDate.of(2022, 10, 16);

        Hotel MiamiBeach = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 80, 110),
                new HotelRates(CustomerType.REWARD, 50, 90)), "Miami Beach");
        Hotel MiamiDowntown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 120, 90),
                new HotelRates(CustomerType.REWARD, 100, 80)), "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 100, 150),
                new HotelRates(CustomerType.REWARD, 70, 130)), "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(weekEndDay, CustomerType.REGULAR);
        assertEquals(MiamiDowntown, cheapestHotel);
    }

    @Test
    public void findCheapestHotelForRegularCustomerAndWeekday() {
        LocalDate weekday = LocalDate.of(2022, 10, 18);

        Hotel MiamiBeach = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 80, 110),
                new HotelRates(CustomerType.REWARD, 50, 90)), "Miami Beach");
        Hotel MiamiDowntown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 120, 90),
                new HotelRates(CustomerType.REWARD, 100, 80)), "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 100, 150),
                new HotelRates(CustomerType.REWARD, 70, 130)), "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(weekday, CustomerType.REGULAR);
        assertEquals(MiamiBeach, cheapestHotel);
    }

    @Test
    public void findCheapestHotelForRewardedCustomerAndWeekend() {
        LocalDate weekEndDay = LocalDate.of(2022, 10, 16);

        Hotel MiamiBeach = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 80, 110),
                new HotelRates(CustomerType.REWARD, 50, 90)), "Miami Beach");
        Hotel MiamiDowntown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 120, 90),
                new HotelRates(CustomerType.REWARD, 100, 80)), "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 100, 150),
                new HotelRates(CustomerType.REWARD, 70, 130)), "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(weekEndDay, CustomerType.REWARD);
        assertEquals(MiamiDowntown, cheapestHotel);
    }

    @Test
    public void findCheapestHotelForRewardedCustomerAndWeekday() {
        LocalDate weekEndDay = LocalDate.of(2022, 10, 18);

        Hotel MiamiBeach = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 80, 110),
                new HotelRates(CustomerType.REWARD, 50, 90)), "Miami Beach");
        Hotel MiamiDowntown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 120, 90),
                new HotelRates(CustomerType.REWARD, 100, 80)), "Miami Downtown");
        Hotel MiamiMidtown = new Hotel(Arrays.asList(new HotelRates(CustomerType.REGULAR, 100, 150),
                new HotelRates(CustomerType.REWARD, 70, 130)), "Miami Midtown");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(MiamiDowntown);
        hotelList.add(MiamiBeach);
        hotelList.add(MiamiMidtown);
        ReservationSystem reservationSystem = new ReservationSystem(hotelList);
        Hotel cheapestHotel = reservationSystem.findCheapestHotel(weekEndDay, CustomerType.REWARD);
        assertEquals(MiamiBeach, cheapestHotel);
    }

    //Miami Beach has weekday rates 80$ for regular customer and 50$ for reward customer. Weekend rates for regular are 110$ and 90$ for reward customer.
    //Miami Downtown has weekday rates 120$ for regular customer and 100$ for reward customer. Weekend rates for regular customer are 90$ and 80$ reward customer.
    //Miami Midtown has weekday rates 100$ for regular customer and 70$ for reward customer. Weekend rates for regular customer are 150$ and 130$ for reward customer.

}
