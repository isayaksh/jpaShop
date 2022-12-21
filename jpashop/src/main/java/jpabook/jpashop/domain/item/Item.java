package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.item.ItemForm;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor(access = PROTECTED)
@DynamicUpdate
public abstract class Item extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    protected Member member;

    protected String name;
    protected int price;
    protected int stockQuantity;

    @Column(insertable = false, updatable = false)
    private String dtype;

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
    public void updateBaseItem(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    /** 하위 객체 업데이트 **/
    public abstract void updateItem(ItemForm form);

}
