package refectoring.demo.price;

import refectoring.demo.MovieType;
import refectoring.demo.price.PriceInterface;

public class ChildrenPriceImpl implements PriceInterface {
    @Override
    public MovieType getPriceCode() {
        return MovieType.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        if(daysRented > 2) return (daysRented - 2) * 1.5 + 2;
        return 2;
    }
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
