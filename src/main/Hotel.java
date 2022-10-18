package main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class Hotel {
    private final double weekdayRate;
    private final double weekEndRate;
    private final String name;

    public Hotel(double weekdayRate, double weekEndRate, String name) {
        this.weekdayRate = weekdayRate;
        this.weekEndRate = weekEndRate;
        this.name = name;
    }

    public double getWeekdayRate() {
        return weekdayRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Double.compare(hotel.getWeekdayRate(), getWeekdayRate()) == 0 &&
                Objects.equals(name, hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeekdayRate(), name);
    }

    public double getRate(LocalDate givenDate) {
        if (givenDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) || givenDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return weekEndRate;
        }
        return weekdayRate;
    }
}
