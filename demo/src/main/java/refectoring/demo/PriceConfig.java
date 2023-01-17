package refectoring.demo;

public class PriceConfig {

    public Price getPricePolicy(MovieType type){
        if(type == MovieType.CHILDRENS) return new ChildrenPrice();
        if(type == MovieType.REGULAR) return new RegularPrice();
        if(type == MovieType.NEW_RELEASE) return new NewReleasePrice();
        throw new IllegalArgumentException("대여료 가격 정책을 찾지 못했습니다.");
    }
}
