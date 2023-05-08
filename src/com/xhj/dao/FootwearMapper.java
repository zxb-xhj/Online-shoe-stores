package com.xhj.dao;

import com.xhj.bean.Footwear;
import com.xhj.bean.FootwearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootwearMapper {
    long countByExample(FootwearExample example);

    int deleteByExample(FootwearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footwear record);

    int insertSelective(Footwear record);

    List<Footwear> selectByExample(FootwearExample example);

    Footwear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footwear record, @Param("example") FootwearExample example);

    int updateByExample(@Param("record") Footwear record, @Param("example") FootwearExample example);

    int updateByPrimaryKeySelective(Footwear record);

    int updateByPrimaryKey(Footwear record);
}