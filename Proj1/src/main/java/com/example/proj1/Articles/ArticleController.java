package com.example.proj1.Articles;

import com.example.proj1.Products.Products;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/products/{productsId}/articles")
    public List<Articles> getAllArticles(@PathVariable String productsId){
        return articleService.getAllArticles(productsId);
    }

    @RequestMapping("/product/{productsId}/articles/{articlesId}")
    public Optional<Articles> getArticles(@PathVariable String articlesId, @PathVariable String productsId){
        return articleService.getArticle(articlesId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/products/{productsId}/articles")
    public Articles postArticle(@RequestBody Articles articles, @PathVariable String productsId){
        articles.setProducts(new Products(productsId, "", "", ' '));
        articleService.postArticle(articles);
        return articles;
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/products/{productsId}/articles/{id}")
    public List<Articles> postArticle(@PathVariable String id, @PathVariable String productsId ){
        articleService.deleteArticle(id);
        return getAllArticles(productsId);
    }

    @RequestMapping(method=RequestMethod.PATCH, value="/products/{productsId}/articles/{id}")
    public Optional<Articles> patchArticles(@RequestBody Map<String, String> field, @PathVariable String id){
        return articleService.modifyArticleAtributte(id, field);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/products/{productsId}/articles/{id}")
    public Articles putArticle( @RequestBody Articles articles,  @PathVariable String id){

        articleService.modifyArtile(articles);
        return articles;
    }
}
