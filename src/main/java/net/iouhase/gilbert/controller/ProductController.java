package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.usecase.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/advertisement")
    public String advertisement() {
        return "advertisement";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/product/{itemNumber}")
    public String product(@PathVariable int itemNumber, Model model) {
        Product product = new Product();
        product.setItemNumber(itemNumber);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/deleteAd")
    public String deleteAd() {
        return "deleteAd";
    }

    @GetMapping("/createAd")
    public String createAd() {
        return "createAd";
    }

    @GetMapping("/editAd/{itemNumber}")
    public String editAd() {
        return "editAd";
    }

    @PostMapping("/makeAd")
    public String makeAd(@RequestParam String model, @RequestParam String category) {
        Product product = new Product();
        product.setModel(model);
        product.setCategory(category);
        productService.save(product);
        return "redirect:/profile";
    }

    @PostMapping("/updateAd/{itemNumber}")
    public String updateAd(@PathVariable int itemNumber, @RequestParam String name, @RequestParam String category) {
        Product product = new Product();
        product.setItemNumber(itemNumber);
        product.setModel(name);
        product.setCategory(category);
        productService.update(product);
        return "redirect:/profile";
    }
}
