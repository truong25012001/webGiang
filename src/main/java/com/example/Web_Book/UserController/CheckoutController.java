package com.example.Web_Book.UserController;

import com.example.Web_Book.DAO.DAO;
import com.example.Web_Book.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public String showCheckout(Model model, HttpSession session, HttpServletRequest request) {
        session = request.getSession(true);
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            return "redirect:/home";
        }
        ArrayList<Item> items = new ArrayList<>();
        for (Item item : cart.getItems()) {
            item.setPrice(item.getBook().getPrice() * item.getQuantity());
            items.add(item);
        }
        cart.setItems(items);
        Double price = cart.getItems().stream().mapToDouble(Item::getPrice).sum();
        cart.setTotalMoney(price);
        model.addAttribute("cart", cart);
        return "/user/checkout";
    }

    @PostMapping("/do-checkout")
    public String doCheckout(Model model, @ModelAttribute("cart") Cart cart, @RequestParam("payment") String payment, HttpSession session, HttpServletRequest request) {
        session = request.getSession(true);
        Cart old = (Cart) session.getAttribute("cart");
        ArrayList<Item> items = new ArrayList<>();
        for (Item item : old.getItems()) {
            item.setPrice(item.getBook().getPrice() * item.getQuantity());
            items.add(item);
        }
        old.setItems(items);
        Double price = old.getItems().stream().mapToDouble(Item::getPrice).sum();
        Account ac = (Account) session.getAttribute("account");

        cart.setTotalMoney(price);
        cart.setItems(old.getItems());
        cart.setPayment(payment);
        System.out.println(cart);

        Order order = new Order();
        order.setUid(ac.getId());
        order.setUsername(ac.getUsername());
        order.setAddress(cart.getAddress());
        order.setPhone(cart.getPhone());
        order.setName(cart.getName());
        order.setTotalMoney(cart.getTotalMoney());
        order.setPayment(cart.getPayment());
        order.setStatus(0); // đang chờ duyệt
        order.setQuantity(cart.getItems().size());
        order.setDay(LocalDate.now().toString());

        DAO dao = new DAO();
        int oid = dao.insertOrder(order);


        for (Item item : items) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOid(oid);
            orderLine.setBid(item.getBook().getId());
            orderLine.setQuantity(item.getQuantity());
            orderLine.setTotalMoney(item.getPrice());

            dao.insertOrderLine(orderLine);
        }

        session.removeAttribute("cart");
        session.removeAttribute("size");


        return "redirect:/mypage";
    }
}
