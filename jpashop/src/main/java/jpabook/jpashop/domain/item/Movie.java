package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.item.ItemForm;
import jpabook.jpashop.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DiscriminatorValue("MOVIE")
@NoArgsConstructor(access = PROTECTED)
@DynamicUpdate // [add] 변경된 필드의 값만 업데이트
public class Movie extends Item{
    private String director;
    private String actor;

    public static Movie createMovie(Member member, String name, int price, int stockQuantity, String director, String actor){
        Movie movie = new Movie();
        movie.member = member;
        movie.name = name;
        movie.price = price;
        movie.stockQuantity = stockQuantity;
        movie.director = director;
        movie.actor = actor;
        return movie;
    }

    @Override
    public void updateItem(ItemForm form) {
        super.updateBaseItem(form.getName(), form.getPrice(), form.getStockQuantity());
        this.director = form.getDirector();
        this.actor = form.getActor();
    }
}
