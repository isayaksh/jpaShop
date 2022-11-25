package jpabook.jpashop.controller.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;

    public static BookForm createBookForm(Long id, String name, int price, int stockQuantity, String author, String isbn){
        BookForm form = new BookForm();
        form.id = id;
        form.name = name;
        form.price = price;
        form.stockQuantity = stockQuantity;
        form.author = author;
        form.isbn = isbn;
        return form;
    }

    public BookForm() {
    }

    @Override
    public String toString() {
        return "BookForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
