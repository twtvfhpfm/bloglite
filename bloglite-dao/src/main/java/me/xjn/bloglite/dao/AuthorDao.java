package me.xjn.bloglite.dao;

import me.xjn.bloglite.pojo.Author;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorDao {

    @Select("select * from Author where id=#{id}")
    Author get(int id);

    @Insert("insert into Author (name,email) vlaues(#{name},#{email})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(Author author);

    @Select("select * from Author where name=#{name}")
    List<Author> getByName(String name);
}
