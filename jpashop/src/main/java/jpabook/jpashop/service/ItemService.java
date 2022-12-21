package jpabook.jpashop.service;

import jpabook.jpashop.controller.item.ItemForm;
import jpabook.jpashop.domain.item.*;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Optional<Item> findOne(Long id){
        return itemRepository.findById(id);
    }

    @Transactional
    public void updateItem(Long itemId, ItemForm form){
        // `itemId`에 해당하는 객체(`Item`)를 영속 상태로 정의
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));

        item.updateItem(form);
//        if(item instanceof Album){
//            Album album = (Album) item; // down casting
//            album.updateAlbum(form.getName(), form.getPrice(), form.getStockQuantity(), form.getArtist(), form.getEtc()); // dirty checking
//        } else if (item instanceof Book) {
//            Book book = (Book) item;
//            book.updateBook(form.getName(), form.getPrice(), form.getStockQuantity(), form.getAuthor(), form.getIsbn());
//        } else if (item instanceof Movie) {
//            Movie movie = (Movie) item;
//            movie.updateMovie(form.getName(), form.getPrice(), form.getStockQuantity(), form.getDirector(), form.getActor());
//        }
    }

    public Page<ItemDto> findAll(Pageable pageable){
        return itemRepository.findAll(pageable).map(p -> new ItemDto(p));
    }
}
