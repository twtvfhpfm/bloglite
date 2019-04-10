package me.xjn.bloglite.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Image {
    @Getter @Setter private int id;
    @Getter @Setter private String contentType;
    @Getter @Setter private String b64Content;
    @Getter @Setter private Date createTime;
}
