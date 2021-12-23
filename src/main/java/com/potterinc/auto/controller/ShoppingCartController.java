package com.potterinc.auto.controller;

import com.potterinc.auto.dao.Product;
import com.potterinc.auto.dao.ProductDAO;
import com.potterinc.auto.dao.ShoppingCart;
import com.potterinc.auto.dao.ShoppingItem;
import com.potterinc.auto.security.UserCart;
import com.potterinc.auto.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Controller
public class ShoppingCartController {
    @Autowired
    UserCart userCart;

    @Autowired
    UserSession userSession;

    @Autowired
    ProductDAO productDAO;

    @PersistenceContext
    EntityManager em;

    @GetMapping("/shopping-cart")
    @Transactional
    public ModelAndView getShoppingCart(@RequestParam(required = false, name="item") Integer item) {
        int uid = userSession.getId();
        if(uid == 0) {
            return new ModelAndView("redirect:/login");
        }

        if(item == null)
            return new ModelAndView("shopping-cart.html");
        else {
            Product p = productDAO.getById(item);
            ShoppingCart sp = userCart.getSp();
            Set<ShoppingItem> shoppingItemList = sp.getShoppingItemSet();

            ShoppingItem shoppingItem = new ShoppingItem();
            shoppingItem.setName(p.getName());
            shoppingItem.setPrice(p.getPrice());
            shoppingItem.setQuantity(1);
            shoppingItemList.add(shoppingItem);

            sp.setShoppingItemSet(shoppingItemList);
            em.persist(sp);

            ModelAndView mv = new ModelAndView("shopping-cart.html");
            mv.addObject("items", userCart.getSp().getShoppingItemSet());
            return mv;
        }
    }
}
