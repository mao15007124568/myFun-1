package edu.hubu.myfun.mapper;

import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.TroubleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TroubleMapper {
    long countByExample(TroubleExample example);

    int deleteByExample(TroubleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Trouble record);

    int insertSelective(Trouble record);

    List<Trouble> selectByExampleWithBLOBsWithRowbounds(TroubleExample example, RowBounds rowBounds);

    List<Trouble> selectByExampleWithBLOBs(TroubleExample example);

    List<Trouble> selectByExampleWithRowbounds(TroubleExample example, RowBounds rowBounds);

    List<Trouble> selectByExample(TroubleExample example);

    Trouble selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Trouble record, @Param("example") TroubleExample example);

    int updateByExampleWithBLOBs(@Param("record") Trouble record, @Param("example") TroubleExample example);

    int updateByExample(@Param("record") Trouble record, @Param("example") TroubleExample example);

    int updateByPrimaryKeySelective(Trouble record);

    int updateByPrimaryKeyWithBLOBs(Trouble record);

    int updateByPrimaryKey(Trouble record);
}