package jpabook.jpashop.controller.item;

import jpabook.jpashop.controller.item.BookForm;
import jpabook.jpashop.domain.item.*;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createBookForm(Model model){
        model.addAttribute("albumForm", new AlbumForm());
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("movieForm", new MovieForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new/album")
    public String createAlbum(AlbumForm form){
        Album album = Album.createAlbum(form.getName(), form.getPrice(), form.getStockQuantity(), form.getArtist(), form.getEtc());
        itemService.saveItem(album);
        return "redirect:/items";
    }

    @PostMapping("/items/new/book")
    public String createBook(BookForm form){
        Book book = Book.createBook(form.getName(), form.getPrice(), form.getStockQuantity(), form.getAuthor(), form.getIsbn());
        itemService.saveItem(book);
        return "redirect:/items";
    }

    @PostMapping("/items/new/movie")
    public String createMovie(MovieForm form){
        Movie movie = Movie.createMovie(form.getName(), form.getPrice(), form.getStockQuantity(), form.getDirector(), form.getActor());
        itemService.saveItem(movie);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String items(@PageableDefault(size = 8, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("items",itemService.findAll(pageable));
        return "items/itemList";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){
        Optional<Item> findItem = itemService.findOne(itemId);
        Book item = (Book)findItem.orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));
        BookForm form = BookForm.createBookForm(item.getId(), item.getName(), item.getPrice(), item.getStockQuantity(), item.getAuthor(), item.getIsbn());
        model.addAttribute("form",form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {
        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());
        return "redirect:/items";
    }
}
