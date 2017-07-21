package com.example.fulfillment.integration.ams.article;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by luchob on 7/21/17.
 */
public class ArticleTest {

    @Test
    public void testGetIDAndName() {

        Article article = new Article();

        article.setId(123);
        article.setName("lucho b");

        Assert.assertEquals("123 lucho b", article.getIDAndName());
    }
}
