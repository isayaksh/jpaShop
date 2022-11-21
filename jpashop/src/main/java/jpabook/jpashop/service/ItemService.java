package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
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
    public void updateItem(Long itemId, String name, int price, int stockQuantity){
        Optional<Item> findItem = itemRepository.findById(itemId);
        Item item = findItem.orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));
        item.updateItem(name,price,stockQuantity);
    }
}
