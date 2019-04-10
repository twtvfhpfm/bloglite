package me.xjn.bloglite.manager.service;

import me.xjn.bloglite.dao.ArticleDao;
import me.xjn.bloglite.dao.AuthorDao;
import me.xjn.bloglite.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired private ArticleDao articleDao;
    @Autowired private AuthorDao authorDao;

    public int add(Article article){
        int ret = articleDao.add(article);
        if (ret <= 0){
            System.out.println("add article failed");
            return ret;
        }
        ret = articleDao.addContent(article);
        return ret;
    }

    public Article get(int aid){
        Article article = articleDao.get(aid);
        if (article == null) return null;
        article.setContent(articleDao.getContent(aid));
        article.setAuthorName(authorDao.get(article.getAuthorId()).getName());
        return article;
    }

    public List<Article> list(){
        List<Article> articleList = articleDao.list();
        for (Article article : articleList) {
            article.setAuthorName(authorDao.get(article.getAuthorId()).getName());
        }
        return articleList;
    }

    public int edit(Article article){
        int ret = articleDao.update(article);
        if (ret <= 0){
            System.out.println("update article failed");
            return ret;
        }
        ret = articleDao.updateContent(article);
        if (ret <= 0){
            System.out.println("update article content failed");
        }
        return ret;
    }

    public int delete(int id){
        int ret = articleDao.delete(id);
        if (ret <= 0){
            System.out.println("delete article failed");
            return ret;
        }
        ret = articleDao.deleteContent(id);
        if (ret <= 0){
            System.out.println("delete article content failed");
        }
        return ret;
    }
}
