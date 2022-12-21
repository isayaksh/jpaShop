package jpabook.jpashop.controller.item;

import jpabook.jpashop.controller.SessionConst;
import jpabook.jpashop.controller.item.BookForm;
import jpabook.jpashop.domain.item.*;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    private final MemberService memberService;

    @GetMapping("/items/new")
    public String createBookForm(Model model){
        model.addAttribute("albumForm", new AlbumForm());
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("movieForm", new MovieForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new/album")
    public String createAlbum(AlbumForm form){
        Member member = memberService.findOne(form.getMemberId());
        Album album = Album.createAlbum(member, form.getName(), form.getPrice(), form.getStockQuantity(), form.getArtist(), form.getEtc());
        itemService.saveItem(album);
        return "redirect:/items";
    }

    @PostMapping("/items/new/book")
    public String createBook(BookForm form){
        Member member = memberService.findOne(form.getMemberId());
        Book book = Book.createBook(member, form.getName(), form.getPrice(), form.getStockQuantity(), form.getAuthor(), form.getIsbn());
        itemService.saveItem(book);
        return "redirect:/items";
    }

    @PostMapping("/items/new/movie")
    public String createMovie(MovieForm form){
        Member member = memberService.findOne(form.getMemberId());
        Movie movie = Movie.createMovie(member, form.getName(), form.getPrice(), form.getStockQuantity(), form.getDirector(), form.getActor());
        itemService.saveItem(movie);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String items(@PageableDefault(size = 8, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable,
                        @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                        Model model){
        model.addAttribute("items",itemService.findAll(pageable));
        model.addAttribute("memberId", memberId);
        return "items/itemList";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){

        Item item = itemService.findOne(itemId).orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));
        ItemForm form = ItemForm.createItemForm(item);
        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") ItemForm form) {
        itemService.updateItem(itemId, form);
        return "redirect:/items";
    }
}
