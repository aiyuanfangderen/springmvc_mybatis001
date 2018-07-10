package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Buycar;
import cn.itcast.ssm.po.BuycarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuycarMapper {
   
    int countByExample(BuycarExample example);

    int deleteByExample(BuycarExample example);

   
    int deleteByPrimaryKey(Integer id);

    int insert(Buycar record);

    
    int insertSelective(Buycar record);

    
    List<Buycar> selectByExample(BuycarExample example);

    Buycar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Buycar record, @Param("example") BuycarExample example);

    
    int updateByExample(@Param("record") Buycar record, @Param("example") BuycarExample example);

   
    int updateByPrimaryKeySelective(Buycar record);

   
    int updateByPrimaryKey(Buycar record);
}