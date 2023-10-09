package mvc.controller;

import mvc.models.Cart;
import mvc.models.Product;
import mvc.models.User;
import mvc.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ProductService productService;

    @RequestMapping("")
    public String goCartPage(){
        return "cart/cartPage";
    }

    @RequestMapping("/add/{id}")
    public String addProduct(@PathVariable Long id, HttpSession session, Model model){

        List<Cart> carts=new ArrayList<>();

        Optional<Product> product=productService.findById(id);

        if(session.getAttribute("cart")==null){
            session.setAttribute("cart",carts);
            carts.add(new Cart(product.get(),1));
        } else {
            carts= (List<Cart>) session.getAttribute("cart");
            int index=this.isExisting(id,carts);
            if(index<0){
                carts.add(new Cart(product.get(),1));
            } else {
                carts.get(index).setQuantity(carts.get(index).getQuantity()+1);
            }
        }

        double totalAmount = carts.stream()
                .mapToDouble(cart -> cart.getProduct().getPrice() * cart.getQuantity())
                .sum();

        model.addAttribute("cart",carts);
        model.addAttribute("total",totalAmount);
       return "/cart/cartPage";
    }

    @RequestMapping("/delete/{id}")
    public String removeProduct(@PathVariable Long id, HttpSession session, Model model){

        Optional<Product> product=productService.findById(id);
        List<Cart> carts=(List<Cart>) session.getAttribute("cart");
        int index=this.isExisting(id,carts);
        carts.remove(index);
        Double totalAmount = carts.stream()
                .mapToDouble(cart -> cart.getProduct().getPrice() * cart.getQuantity())
                .sum();
        model.addAttribute("cart",carts);
        model.addAttribute("total",totalAmount);
        return "/cart/cartPage";
    }

    @PostMapping("/removeSession")
    public String removeSession(HttpSession session, User user, Model model){
        HashMap<User, List<Cart>> map=new HashMap<>();

        List<Cart> carts=(List<Cart>) session.getAttribute("cart");
        //insert order:
        //

        if(session.getAttribute("listOrder")!=null) map= (HashMap<User, List<Cart>>) session.getAttribute("listOrder");

        session.removeAttribute("cart");
        map.put(user,carts);
        session.setAttribute("listOrder",map);
        model.addAttribute("listOder",map);
        return "/cart/orders";
    }

    @RequestMapping("/showList/{carts}")
    public String showListCart(@PathVariable List<Cart> carts, Model model){
        double totalAmount = carts.stream()
                .mapToDouble(cart -> cart.getProduct().getPrice() * cart.getQuantity())
                .sum();
        model.addAttribute("cart",carts);
        model.addAttribute("total",totalAmount);
        return "/cart/cartPage";
    }

    // search product in list cart
    public int isExisting(Long id, List<Cart> cart) {
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getProduct().getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

}
