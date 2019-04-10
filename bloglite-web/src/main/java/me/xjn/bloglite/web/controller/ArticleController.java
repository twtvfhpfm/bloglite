package me.xjn.bloglite.web.controller;

import me.xjn.bloglite.dao.ArticleDao;
import me.xjn.bloglite.dao.AuthorDao;
import me.xjn.bloglite.pojo.Article;
import me.xjn.bloglite.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired private ArticleDao articleDao;
    @Autowired private AuthorDao authorDao;

    @Autowired private ArticleService articleService;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index");
        mv.addObject("title", "first blog");

        List<Article> articles = articleDao.list();
        for (Article article : articles) {
            article.setAuthorName(authorDao.get(article.getAuthorId()).getName());
        }
        mv.addObject("arts", articles);
        return mv;
    }

    @RequestMapping("/article/{aid}")
    public ModelAndView articlePage(ModelAndView mv, @PathVariable int aid){
        Article art = articleDao.get(aid);
        art.setContent(articleDao.getContent(aid));
        art.setAuthorName(authorDao.get(art.getAuthorId()).getName());

        mv.setViewName("article");
        mv.addObject("art", art);
        return mv;
    }
}
