package com.example.proj1.Articles;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Articles, String> {
    public List<Articles> findByProductsId(String productsID);
}
