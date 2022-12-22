package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.item.AlbumForm;
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
@DiscriminatorValue("ALBUM")
@NoArgsConstructor(access = PROTECTED)
@DynamicUpdate // [add] 변경된 필드의 값만 업데이트
public class Album extends Item{
    private String artist;
    private String etc;

    public static Album createAlbum(Member member, String name, int price, int stockQuantity, String artist, String etc){
        Album album = new Album();
        album.member = member;
        album.name = name;
        album.price = price;
        album.stockQuantity = stockQuantity;
        album.artist = artist;
        album.etc = etc;
        return album;
    }

    @Override
    public void updateItem(ItemForm form) {
        super.updateBaseItem(form.getName(), form.getPrice(), form.getStockQuantity());
        this.artist = form.getArtist();
        this.etc = form.getEtc();
    }
}
