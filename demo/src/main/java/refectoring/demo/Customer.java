package refectoring.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    @Builder
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public void statement(){
        System.out.println("<<" + getName() + " 님의 대여 기록 >>");
        for (Rental rental : getRentals()) {
            System.out.println("대여 영화 : " + rental.getMovie().getTitle());
            System.out.println("대여료 : " + rental.getCharge());
            System.out.println("적립 포인트 : " + rental.getFrequentRenterPoints());
            System.out.println("====================\n");
        }
        System.out.println("누적 대여료 : " + getTotalCharge());
        System.out.println("적립 포인트 : " + getTotalFrequentRenterPoints());
    }

    public double getTotalCharge(){
        return getRentals().stream().mapToDouble(i -> i.getCharge()).sum();
    }

    public int getTotalFrequentRenterPoints(){
        return getRentals().stream().mapToInt(i -> i.getFrequentRenterPoints()).sum();
    }

}
