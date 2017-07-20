package com.example.fulfillment.integration.ams.article;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by luchob on 7/19/17.
 */
@RestController
public class ArticleController {

    private String shangriLlamaNames[] = {
            "Dido",
            "Tomoff",
            "Lucho",
            "Shalamana",
            "Jorko",
            "Marto",
            "Mozaka",
            "Viktor"
    };

    @RequestMapping(value = "/articles/rand", method = GET)
    public Article getRandomArticle() {
        //todo: service
        Article randArticle = new Article();

        Random rand = new Random();

        randArticle.setId(rand.nextInt(1000));
        randArticle.setName(shangriLlamaNames[rand.nextInt(shangriLlamaNames.length)]);

        return randArticle;
    }
}
