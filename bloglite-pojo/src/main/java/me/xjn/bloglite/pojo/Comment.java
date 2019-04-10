package me.xjn.bloglite.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Comment {
    @Setter @Getter private int id;
    @Setter @Getter private int aid;
    /**
     * parent id, 0 means no parent
     */
    @Setter @Getter private int pid;
    @Setter @Getter private Date createTime;
    @Setter @Getter private String content;
    @Setter @Getter private String name;
}
