package me.xjn.bloglite.dao;

import me.xjn.bloglite.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentDao {

    @Select("SELECT * FROM Comment where aid=#{aid}")
    Comment get(int aid);

    @Insert("INSERT INTO Comment (aid,pid,name,content) values (#{aid},#{pid},#{name},#{content}")
    int add(Comment comment);
}
