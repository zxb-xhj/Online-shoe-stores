package com.xhj.dao;

import com.xhj.bean.Indent;
import com.xhj.bean.IndentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndentMapper {
    long countByExample(IndentExample example);

    int deleteByExample(IndentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Indent record);

    int insertSelective(Indent record);

    List<Indent> selectByExample(IndentExample example);

    Indent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Indent record, @Param("example") IndentExample example);

    int updateByExample(@Param("record") Indent record, @Param("example") IndentExample example);

    int updateByPrimaryKeySelective(Indent record);

    int updateByPrimaryKey(Indent record);
    
    int insertall();
}