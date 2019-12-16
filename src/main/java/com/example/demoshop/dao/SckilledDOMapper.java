package com.example.demoshop.dao;

import com.example.demoshop.daoObject.SckilledDO;
import com.example.demoshop.daoObject.SckilledDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SckilledDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    long countByExample(SckilledDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int deleteByExample(SckilledDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int deleteByPrimaryKey(Integer sckillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int insert(SckilledDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int insertSelective(SckilledDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    List<SckilledDO> selectByExample(SckilledDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    SckilledDO selectByPrimaryKey(Integer sckillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int updateByExampleSelective(@Param("record") SckilledDO record, @Param("example") SckilledDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int updateByExample(@Param("record") SckilledDO record, @Param("example") SckilledDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int updateByPrimaryKeySelective(SckilledDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckilled
     *
     * @mbg.generated Wed Dec 11 16:54:54 CST 2019
     */
    int updateByPrimaryKey(SckilledDO record);
}