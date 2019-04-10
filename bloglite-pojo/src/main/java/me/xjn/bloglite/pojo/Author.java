package me.xjn.bloglite.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Author {
    @Setter @Getter private int id;
    @Setter @Getter private String name;
    @Setter @Getter private String email;
    @Setter @Getter private Date createTime;
}
