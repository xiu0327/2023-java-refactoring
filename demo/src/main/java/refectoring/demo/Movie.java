package refectoring.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Movie {

    private String title;
    private MovieType type;
    private Price price;

    private PriceConfig priceConfig = new PriceConfig();

    @Builder
    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
        this.price = priceConfig.getPricePolicy(getType());
    }

    public int getFrequentRenterPoints(int daysRented){
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        return this.price.getFrequentRenterPoints(daysRented);
    }

    public double getCharge(int daysRented){
        // 비디오 종류별 대여료 계산
        return price.getCharge(daysRented);
    }
}
