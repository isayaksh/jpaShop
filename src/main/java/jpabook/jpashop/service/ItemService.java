package jpabook.jpashop.service;

import jpabook.jpashop.controller.item.ItemForm;
import jpabook.jpashop.domain.item.*;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.repository.item.ItemRepository;
import jpabook.jpashop.repository.item.ItemSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));
        item.updateItem(form);
    }

    public Page<ItemDto> findAll(ItemSearch itemSearch, Pageable pageable){
        return itemRepository.findAll(itemSearch, pageable).map(ItemDto::new);
    }
}
