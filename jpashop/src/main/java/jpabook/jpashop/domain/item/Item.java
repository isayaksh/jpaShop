package jpabook.jpashop.domain.item;

import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor(access = PROTECTED)
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    protected String name;
    protected int price;
    protected int stockQuantity;

    /** 비지니스 로직 **/

    /** 재고 수량 증가 **/
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /** 재고 수량 감소 **/
    public void removeStock(int quantity){
        if(this.stockQuantity < quantity){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity -= quantity;
    }

    /** Item 객체 업데이트 **/
    public void updateItem(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
