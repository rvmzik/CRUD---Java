package com.example.proj1.Articles;

import com.example.proj1.Products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    private List<Products> topics = new ArrayList(Arrays.asList(
            new Products("product1", "Iphone", "description spring1",400),
            new Products("product2", "Samsung", "description spring2",500),
            new Products("product3", "Xiomi", "description spring3",600),
            new Products("product4", "LG", "description spring4",700)
    ));
    public List<Articles> getAllArticles(String productsId){
        List<Articles> articles = new ArrayList<>();
        articleRepository.findByProductsId(productsId)
                .forEach(articles::add);
        return articles;
    }

    public Optional<Articles> getArticle(String id) {

        return articleRepository.findById(id);
    }

    public void postArticle(Articles articles){
        articleRepository.save(articles);
    }

    public void deleteArticle(String articleId){
        articleRepository.deleteById(articleId);
    }

    public void modifyArtile(Articles articles){
        articleRepository.save(articles);
    }




    public Optional<Articles> modifyArticleAtributte(String id, Map<String, String> field){
        Optional<Articles> articles =  getArticle(id);
        field.forEach((k, v) -> {
            if(k =="name") {
                articles.get().setName(v);
            }
            else if(k =="content") {
                articles.get().setContent(v);
            }
        });
        articleRepository.save(articles.get());
        return articles;
    }
}
