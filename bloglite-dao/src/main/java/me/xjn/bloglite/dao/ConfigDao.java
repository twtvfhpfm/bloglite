package me.xjn.bloglite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ConfigDao {
    @Select("SELECT configValue from Config WHERE configKey=#{key}")
    String GetConfig(String key);
}

