package jpabook.jpashop.controller.item;

import jpabook.jpashop.controller.SessionConst;
import jpabook.jpashop.controller.item.BookForm;
import jpabook.jpashop.controller.order.OrderForm;
import jpabook.jpashop.domain.item.*;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.repository.item.ItemSearch;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final OrderService orderService;
    private final MemberService memberService;

    @GetMapping("/items/new")
    public String createBookForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                                 Model model){
        ItemForm form = new ItemForm();
        form.setMemberId(memberId);
        model.addAttribute("form", form);
        return "items/createItemForm";
    }

    @PostMapping("/items/new/album")
    public String createAlbum(ItemForm form){
        Member member = memberService.findOne(form.getMemberId());
        Album album = Album.createAlbum(member, form.getName(), form.getPrice(), form.getStockQuantity(), form.getArtist(), form.getEtc());
        itemService.saveItem(album);
        return "redirect:/items";
    }

    @PostMapping("/items/new/book")
    public String createBook(ItemForm form){
        Member member = memberService.findOne(form.getMemberId());
        Book book = Book.createBook(member, form.getName(), form.getPrice(), form.getStockQuantity(), form.getAuthor(), form.getIsbn());
        itemService.saveItem(book);
        return "redirect:/items";
    }

    @PostMapping("/items/new/movie")
    public String createMovie(ItemForm form){
        Member member = memberService.findOne(form.getMemberId());
        Movie movie = Movie.createMovie(member, form.getName(), form.getPrice(), form.getStockQuantity(), form.getDirector(), form.getActor());
        itemService.saveItem(movie);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String items(@PageableDefault(size = 8, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable,
                        @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                        @ModelAttribute("itemSearch") ItemSearch itemSearch,
                        Model model){
        model.addAttribute("items", itemService.findAll(itemSearch, pageable));
        model.addAttribute("itemSearch", itemSearch);
        model.addAttribute("memberId", memberId);
        return "items/itemCardList";
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

    /**
     * 물품 상세 정보
     **/
    @GetMapping("item/info")
    public String itemMoreInfo(@RequestParam("id") Long itemId, Model model) {
        Item item = itemService.findOne(itemId).orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));

        /** down casting **/
        if(item instanceof Album){
            Album album = (Album) item;
            model.addAttribute("item", album);
        } else if (item instanceof Book) {
            Book book = (Book) item;
            model.addAttribute("item", book);
        } else if (item instanceof Movie) {
            Movie movie = (Movie) item;
            model.addAttribute("item", movie);
        }

        model.addAttribute("form", new OrderForm());

        return "items/itemMoreInfo";
    }
}
