package me.xjn.bloglite.dao;

import me.xjn.bloglite.pojo.Image;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ImageDao {

    @Select("SELECT * from Image where id=#{id}")
    Image get(int id);

    @Delete("DELETE FROM Image where id=#{id}")
    int delete(int id);

    @Insert("INSERT INTO Image (contentType,b64Content) values (#{contentType},#{b64Content})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(Image image);
}
