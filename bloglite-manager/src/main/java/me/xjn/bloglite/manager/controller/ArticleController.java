package me.xjn.bloglite.manager.controller;

import me.xjn.bloglite.dao.ArticleDao;
import me.xjn.bloglite.dao.AuthorDao;
import me.xjn.bloglite.manager.service.ArticleService;
import me.xjn.bloglite.pojo.Article;
import me.xjn.bloglite.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired private ArticleService articleService;

    @GetMapping(value = "/Article/Index")
    public String index(Model model){

        List<Article> articleList = articleService.list();
        model.addAttribute("articleList", articleList);
        return "/article/index";
    }

    @GetMapping(value = "/Article/Add")
    public String add(Model model){
        Article article = new Article();
        model.addAttribute("article", article);
        model.addAttribute("mode", "add");
        model.addAttribute("aid", 0);
        return "/article/edit";
    }

    @GetMapping(value = "/Article/Edit")
    public String edit(Model model, int id){
        Article article = articleService.get(id);
        if (article == null){
            System.out.println("article with id=" + id + " not exist");
        }
        model.addAttribute("article", article);
        model.addAttribute("mode", "edit");
        model.addAttribute("aid", article.getAid());
        return "/article/edit";
    }

    @ResponseBody
    @PostMapping(value = "/Article/Save")
    public JsonResult save(@RequestParam Map<String, String> body){
        Article article = new Article();
        article.setTitle(body.get("title"));
        article.setAuthorName(body.get("authorName"));
        article.setContent(body.get("content"));
        article.setAbztract(body.get("abztract"));
        article.setAid(Integer.parseInt(body.get("aid")));
        article.setTag(body.get("tag"));
        article.setModifyTime(new Date());
        //TODO
        article.setAuthorId(1);

        JsonResult result = null;
        switch(body.get("mode"))
        {
            case "add":
                if (articleService.add(article) > 0){
                    result = new JsonResult(true, "添加成功");
                }else{
                    result = new JsonResult(false, "添加失败");
                }
                break;
            case "edit":
                if (articleService.edit(article) > 0){
                    result = new JsonResult(true, "修改成功");
                }else{
                    result = new JsonResult(false, "修改失败");
                }
                break;
            default:
                result = new JsonResult(false, "unrecognized mode: " + body.get("mode"));
                break;
        }
        return result;
    }

    @ResponseBody
    @GetMapping(value = "/Article/Delete")
    public JsonResult delete(int id){
        int ret = articleService.delete(id);
        if (ret > 0){
            return new JsonResult(true, "删除成功");
        }else{
            return new JsonResult(false, "删除失败");
        }
    }
}
