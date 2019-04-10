package me.xjn.bloglite.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Article {
    @Setter @Getter private int aid;
    @Setter @Getter private String title;
    @Setter @Getter private int authorId;
    @Setter @Getter private String authorName;
    @Setter @Getter private String tag;
    @Setter @Getter private String abztract;
    @Setter @Getter private Date createTime;
    @Setter @Getter private Date modifyTime;
    @Setter @Getter private String content;
}
