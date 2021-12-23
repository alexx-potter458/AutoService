package com.potterinc.auto.controller;

import com.potterinc.auto.dao.Product;
import com.potterinc.auto.security.UserSession;
import com.potterinc.auto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    UserSession userSession;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard() {


        int uid = userSession.getId();
        if(uid == 0) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView dashboardView = new ModelAndView("dashboard.html");
        List<Product> products = productService.getAll();

        dashboardView.addObject("products", products);
        return dashboardView;
    }

    @GetMapping("/services/{id}")
    public ModelAndView getServiceById(@PathVariable Integer id) {

        int uid = userSession.getId();
        if(uid == 0) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView serviceModel = new ModelAndView("services.html");
        Product productElement = productService.getById(id);

        serviceModel.addObject("serviceElem", productElement);
        return serviceModel;
    }

}
