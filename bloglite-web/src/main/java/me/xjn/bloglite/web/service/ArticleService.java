package me.xjn.bloglite.web.service;

import me.xjn.bloglite.dao.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ArticleService {
    @Autowired
    private ConfigDao configDao;

    public String getContent(int aid) {
        String blogPath = configDao.GetConfig("blogPath");
        if (blogPath == null || blogPath.equals("")){
            return "博客路径未配置";
        }

        if (!blogPath.endsWith("/")){
            blogPath += "/";
        }
        String fileName = blogPath + aid + "/article/article.md";
        BufferedInputStream inStream = null;
        try {
            inStream = new BufferedInputStream(
                    new FileInputStream(fileName)
            );
            byte[] content = new byte[inStream.available()];
            inStream.read(content);
            inStream.close();
            return new String(content);
        }
        catch (FileNotFoundException ex){
            return "找不到文件: " + fileName;
        }
        catch (IOException ex){
            return "读取文件失败: " + fileName;
        }


    }
}