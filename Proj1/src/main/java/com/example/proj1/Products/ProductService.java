package com.example.proj1.Products;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private List<Products> topics = new ArrayList(Arrays.asList(
            new Products("product1", "Iphone", "description spring1",400),
            new Products("product2", "Samsung", "description spring2",500),
            new Products("product3", "Xiomi", "description spring3",600),
            new Products("product4", "LG", "description spring4",700)
    ));

    public List<Products> getAllProducts(){
        List<Products> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Optional<Products> getProduct(String id) {

        return productRepository.findById(id);
    }

    public void postProduct(Products products){
        productRepository.save(products);
    }

    public void deleteProduct(String productsId){
        productRepository.deleteById(productsId);
    }

    public void modifyProduct(Products products){
        productRepository.save(products);
    }

    public Optional<Products> modifyProductsAtributte(String id, Map<String, String> field){
        Optional<Products> products =  getProduct(id);
        field.forEach((k, v) -> {
            if(k =="name") {
                products.get().setName(v);
            }
            else if(k =="description") {
                products.get().setDescription(v);
            }
        });
        productRepository.save(products.get());
        return products;
    }
}
