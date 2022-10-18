package com.example.proj1.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Optional<Products> getProducts(@PathVariable String id){
        return productService.getProduct(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/products")
    public Products postProducts( @RequestBody Products products){
        productService.postProduct(products);
        return products;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
    public List<Products> postProducts(@PathVariable String id){
        productService.deleteProduct(id);
        return getAllProducts();
    }
    @RequestMapping(method=RequestMethod.PATCH, value="/products/{id}")
    public Optional<Products> patchProducts(@RequestBody Map<String, String> field, @PathVariable String id){
        return productService.modifyProductsAtributte(id, field);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Products putProducts(@RequestBody Products products, @PathVariable String id){

        productService.modifyProduct(products);
        return products;
    }
}
