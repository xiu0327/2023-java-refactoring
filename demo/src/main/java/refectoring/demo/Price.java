package refectoring.demo;

abstract class Price {
    abstract MovieType getPriceCode();
    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}

class ChildrenPrice extends Price{
    @Override
    MovieType getPriceCode() {
        return MovieType.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        if(daysRented > 2) return (daysRented - 2) * 1.5 + 2;
        return 2;
    }
}

class NewReleasePrice extends Price{
    @Override
    MovieType getPriceCode() {
        return MovieType.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) return 2;
        return 1;
    }
}

class RegularPrice extends Price{
    @Override
    MovieType getPriceCode() {
        return MovieType.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        if(daysRented > 3) return (daysRented - 3) * 1.5 + 1.5;
        return 1.5;
    }
}


