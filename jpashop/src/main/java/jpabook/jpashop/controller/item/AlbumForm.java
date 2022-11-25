package jpabook.jpashop.controller.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlbumForm {
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String artist;
    private String etc;

    public static AlbumForm createAlbumForm(Long id, String name, int price, int stockQuantity, String artist, String etc){
        AlbumForm form = new AlbumForm();
        form.id = id;
        form.name = name;
        form.price = price;
        form.stockQuantity = stockQuantity;
        form.artist = artist;
        form.etc = etc;
        return form;
    }
}
