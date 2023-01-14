package jpabook.jpashop.controller.item;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlbumForm{

    private Long id;
    private Long memberId;

    private String dtype;

    private String name;
    private int price;
    private int stockQuantity;

    private String artist;
    private String etc;

    public static AlbumForm createAlbumForm(Long id, Long memberId, String name, int price, int stockQuantity, String artist, String etc){
        AlbumForm form = new AlbumForm();
        form.artist = artist;
        form.etc = etc;
        return form;
    }
}
