package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.item.ItemForm;
import jpabook.jpashop.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DiscriminatorValue("B")
@NoArgsConstructor(access = PROTECTED)
@DynamicUpdate // [add] 변경된 필드의 값만 업데이트
public class Book extends Item{
    private String author;
    private String isbn;


    public static Book createBook(Member member, String name, int price, int stockQuantity, String author, String isbn){
        Book book = new Book();
        book.member = member;
        book.name = name;
        book.price = price;
        book.stockQuantity = stockQuantity;
        book.author = author;
        book.isbn = isbn;
        return book;
    }

    @Override
    public void updateItem(ItemForm form) {
        super.updateBaseItem(form.getName(), form.getPrice(), form.getStockQuantity());
        this.author = form.getAuthor();
        this.isbn = form.getIsbn();
    }
}
