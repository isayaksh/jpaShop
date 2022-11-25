package jpabook.jpashop.controller.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieForm {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String director;
    private String actor;

    public static MovieForm createMovieForm(Long id, String name, int price, int stockQuantity, String director, String actor){
        MovieForm form = new MovieForm();
        form.id = id;
        form.name = name;
        form.price = price;
        form.stockQuantity = stockQuantity;
        form.director = director;
        form.actor = actor;
        return form;
    }
    public MovieForm(){
    }
}
