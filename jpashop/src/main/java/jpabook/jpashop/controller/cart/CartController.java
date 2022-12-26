package jpabook.jpashop.controller.cart;

import jpabook.jpashop.controller.SessionConst;
import jpabook.jpashop.controller.member.MemberForm;
import jpabook.jpashop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/cartItems")
    public String cartItems(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                            @PageableDefault(size = 8) Pageable pageable,
                            Model model){
        model.addAttribute("items", cartService.cartItems(memberId));
        return "cart/cartItems";
    }

    @PostMapping("/addItem")
    public String addToCart(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count){

        cartService.addCartItem(memberId, itemId, count);
        return "redirect:/cartItems";
    }

}
