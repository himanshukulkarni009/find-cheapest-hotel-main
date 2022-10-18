package main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Hotel {
    private final List<HotelRates> hotelRatesList;
    private final String name;

    public Hotel(List<HotelRates> hotelRatesList, String name) {
        this.hotelRatesList = hotelRatesList;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelRatesList.equals(hotel.hotelRatesList) && name.equals(hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelRatesList, name);
    }

    public double getRate(LocalDate givenDate, CustomerType customerType) {
        Optional<HotelRates> hotelRate = hotelRatesList.stream().filter(rate -> rate.getCustomerType().equals(customerType)).findFirst();

        if(hotelRate.isPresent()) {
            if (givenDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) || givenDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                return hotelRate.get().getWeekEndRate();
            }
            return hotelRate.get().getWeekDayRate();
        } else {
            throw new RuntimeException("Customer not supported");
        }

    }
}
