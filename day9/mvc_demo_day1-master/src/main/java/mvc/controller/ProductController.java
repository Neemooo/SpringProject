package mvc.controller;

import mvc.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductController {
    final int MAX_DISPLAY=2;

    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    public String goHomePage(Model model) {

        model.addAttribute("list",productService.findAll());
        return "product/index";
    }
}
