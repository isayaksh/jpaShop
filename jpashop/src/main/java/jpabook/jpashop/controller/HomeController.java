package jpabook.jpashop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j // 로그 작성을 위한 Annotation
@RequiredArgsConstructor
public class HomeController {

//    private final

    @RequestMapping("/")
    public String home(Model model){
        //model.addAttribute("itemCount")
        log.info("home controller");
        return "home";
    }
}
