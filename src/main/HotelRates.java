package main;

public class HotelRates {
    final private CustomerType customerType;
    final private double weekDayRate;
    final private double weekEndRate;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public double getWeekDayRate() {
        return weekDayRate;
    }

    public double getWeekEndRate() {
        return weekEndRate;
    }

    public HotelRates(CustomerType customerType, double weekDayRate, double weekEndRate) {
        this.customerType = customerType;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
    }
}
