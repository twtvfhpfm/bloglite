package me.xjn.bloglite.dao;

import me.xjn.bloglite.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {
    @Select("SELECT * FROM Article")
    List<Article> list();

    @Select("SELECT * FROM Article WHERE aid=#{aid}")
    Article get(int aid);

    @Insert("INSERT INTO Article (title,authorId,tag,abztract)" +
            " values (#{title},#{authorId},#{tag},#{abztract})")
    @Options(useGeneratedKeys = true, keyColumn = "aid", keyProperty = "aid")
    int add(Article article);

    @Delete("DELETE FROM Article where aid=#{aid}")
    int delete(int aid);

    @Update("UPDATE Article SET title=#{title},tag=#{tag},abztract=#{abztract}," +
            "modifyTime=#{modifyTime} where aid=#{aid}")
    int update(Article article);

    @Select("SELECT content from ArticleContent where aid=#{aid}")
    String getContent(int aid);

    @Update("UPDATE ArticleContent set content=#{content} where aid=#{aid}")
    int updateContent(Article article);

    @Delete("DELETE FROM ArticleContent where aid=#{aid}")
    int deleteContent(int aid);

    @Insert("INSERT INTO ArticleContent (aid,content) values (#{aid},#{content})")
    int addContent(Article article);
}
