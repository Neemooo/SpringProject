package mvc.controller;

import mvc.models.OrderDetail;
import mvc.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping("/{id}")
    public String findByOrderId(@PathVariable Long id, Model model){
        List<OrderDetail> orderDetail = orderDetailService.findByOrderId(id);
        if (!orderDetail.isEmpty()) {
            model.addAttribute("orderDetailList",orderDetail);
            return "orderDetail/index";
        }
        model.addAttribute("message","Not found any orderDetail with id "+ id);
        return "index";
    }

    @RequestMapping("/goForm")
    public String goForm(Model model){
        model.addAttribute("orderDetail",new OrderDetail());
        return "orderDetail/form";
    }

    @PostMapping("/search")
    public String findByCustomerName(@RequestParam(defaultValue = "", name = "n") String name_search,
                                     @RequestParam(defaultValue = "", name = "n") Date date_search,
                                     @RequestParam(defaultValue = "", name = "n") String product_name,
                                     Model model){

        Optional<OrderDetail> orderDetail=orderDetailService.search(date_search,name_search,product_name);
        if(orderDetail.isPresent()){
            model.addAttribute("orderDetailList",orderDetail);
            return "orderDetails/index";
        }
        model.addAttribute("message","Not found any orderDetail");
        return "index";
    }
}
