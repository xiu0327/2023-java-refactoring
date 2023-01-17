package refectoring.demo.price;

import refectoring.demo.MovieType;

public interface PriceInterface {
    MovieType getPriceCode();
    double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
