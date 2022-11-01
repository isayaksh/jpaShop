package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DiscriminatorValue("M")
@NoArgsConstructor(access = PROTECTED)
public class Movie extends Item{
    private String director;
    private String actor;

    public static Movie createMovie(String name, int price, int stockQuantity, String director, String actor){
        Movie movie = new Movie();
        movie.name = name;
        movie.price = price;
        movie.stockQuantity = stockQuantity;
        movie.director = director;
        movie.actor = actor;
        return movie;
    }
}
