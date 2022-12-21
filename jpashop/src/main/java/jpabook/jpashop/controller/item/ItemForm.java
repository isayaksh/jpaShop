package jpabook.jpashop.controller.item;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemForm {
    private Long id;
    private Long memberId;

    private String dtype;

    private String name;
    private int price;
    private int stockQuantity;

    private String artist;
    private String etc;

    private String author;
    private String isbn;

    private String director;
    private String actor;

    public static ItemForm createItemForm(Item item){
        ItemForm form = new ItemForm();
        form.id = item.getId();
        form.memberId = item.getMember().getId();
        form.name = item.getName();
        form.price = item.getPrice();
        form.stockQuantity = item.getStockQuantity();

        if(item instanceof Album){
            Album album = (Album) item;
            form.dtype = "A";
            form.artist = album.getArtist();
            form.etc = album.getEtc();
        } else if (item instanceof Book) {
            Book book = (Book) item;
            form.dtype = "B";
            form.author = book.getAuthor();
            form.isbn = book.getIsbn();
        } else if (item instanceof Movie) {
            Movie movie = (Movie) item;
            form.dtype = "M";
            form.director = movie.getDirector();
            form.actor = movie.getActor();
        }
        return form;
    }

}
