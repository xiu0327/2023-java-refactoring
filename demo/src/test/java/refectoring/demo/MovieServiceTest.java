package refectoring.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieServiceTest {

    @Test
    void 대여_테스트(){
        // given - 회원 생성 및 영화 대여
        Customer customer = Customer.builder()
                .name("회원A").build();

        customer.addRental(Rental.builder()
                .movie(Movie.builder()
                        .title("영화1")
                        .type(MovieType.CHILDRENS).build())
                .daysRented(4).build());

        customer.addRental(Rental.builder()
                .movie(Movie.builder()
                        .title("영화2")
                        .type(MovieType.NEW_RELEASE).build())
                .daysRented(3).build());

        customer.addRental(Rental.builder()
                .movie(Movie.builder()
                        .title("영화2")
                        .type(MovieType.REGULAR).build())
                .daysRented(1).build());

        // when
        customer.statement();
    }

    @Test
    void 대여_테스트_에러(){
        Customer customer = Customer.builder()
                .name("회원A").build();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.addRental(Rental.builder()
                .movie(Movie.builder()
                        .title("영화1").build())
                .daysRented(4).build()));
    }
}
