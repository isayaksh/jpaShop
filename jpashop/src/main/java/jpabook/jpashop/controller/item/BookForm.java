package jpabook.jpashop.controller.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm{

    private Long id;
    private Long memberId;

    private String dtype;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;

    public static BookForm createBookForm(Long id, Long memberId, String name, int price, int stockQuantity, String author, String isbn){
        BookForm form = new BookForm();
        form.id = id;
        form.memberId = memberId;
        form.name = name;
        form.price = price;
        form.stockQuantity = stockQuantity;
        form.author = author;
        form.isbn = isbn;
        return form;
    }
    public BookForm() {
        this.dtype = "B";
    }
}
