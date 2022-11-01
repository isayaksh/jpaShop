package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DiscriminatorValue("B")
@NoArgsConstructor(access = PROTECTED)
public class Book extends Item{
    private String author;
    private String isbn;

    public static Book createBook(String name, int price, int stockQuantity, String author, String isbn){
        Book book = new Book();
        book.name = name;
        book.price = price;
        book.stockQuantity = stockQuantity;
        book.author = author;
        book.isbn = isbn;
        return book;
    }

}
