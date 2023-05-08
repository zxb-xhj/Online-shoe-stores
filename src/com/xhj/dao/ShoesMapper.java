package com.xhj.dao;

import com.xhj.bean.Shoes;
import com.xhj.bean.ShoesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoesMapper {
    long countByExample(ShoesExample example);

    int deleteByExample(ShoesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shoes record);

    int insertSelective(Shoes record);

    List<Shoes> selectByExample(ShoesExample example);

    Shoes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shoes record, @Param("example") ShoesExample example);

    int updateByExample(@Param("record") Shoes record, @Param("example") ShoesExample example);

    int updateByPrimaryKeySelective(Shoes record);

    int updateByPrimaryKey(Shoes record);
    
    List<Shoes> selecthid(Shoes shoes);
    
    List<Shoes> selectname(Shoes shoes);
}