package com.potterinc.auto.security;

import com.potterinc.auto.dao.ShoppingCart;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class UserCart {

    private ShoppingCart sp;

    public UserCart() {
        sp = new ShoppingCart();
    }

    public ShoppingCart getSp() {
        return sp;
    }

    public void setSp(ShoppingCart sp) {
        this.sp = sp;
    }
}
