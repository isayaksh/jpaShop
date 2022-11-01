package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DiscriminatorValue("A")
@NoArgsConstructor(access = PROTECTED)
public class Album extends Item{
    private String artist;
    private String etc;

    public static Album createAlbum(String name, int price, int stockQuantity, String artist, String etc){
        Album album = new Album();
        album.name = name;
        album.price = price;
        album.stockQuantity = stockQuantity;
        album.artist = artist;
        album.etc = etc;
        return album;
    }
}
