package jpabook.jpashop.controller.cart;

import jpabook.jpashop.controller.SessionConst;
import jpabook.jpashop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartItemController {

    private final CartService cartService;

    @GetMapping("/cartItems")
    public String cartItems(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                            @PageableDefault(size = 8) Pageable pageable,
                            Model model){
        model.addAttribute("items", cartService.cartItems(memberId, pageable));
        return "cart/cartItems";
    }


    @PostMapping("/addItem")
    public String addToCart(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count){

        cartService.addCartItem(memberId, itemId, count);
        return "redirect:/cartItems";
    }

    @PostMapping("/cartItem/{cartItemId}/cancel")
    public String cancelCartItem(@PathVariable("cartItemId") Long cartItemId){
        cartService.cancelCartItem(cartItemId);
        return "redirect:/cartItems";
    }

    @PostMapping("/cartItem/order")
    public String orderCartItem(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                                @RequestParam List<Long> cartItemIds){
        cartService.order(cartItemIds, memberId);
        cartService.cancelCartItems(cartItemIds);

        return "redirect:/orders";
    }
}