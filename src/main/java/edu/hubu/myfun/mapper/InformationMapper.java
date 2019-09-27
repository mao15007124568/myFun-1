package edu.hubu.myfun.mapper;

import edu.hubu.myfun.pojo.Information;
import edu.hubu.myfun.pojo.InformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InformationMapper {
    long countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExampleWithRowbounds(InformationExample example, RowBounds rowBounds);

    List<Information> selectByExample(InformationExample example);

    Information selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}