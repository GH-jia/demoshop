package com.example.demoshop.dao;

import com.example.demoshop.daoObject.ShopListDO;
import com.example.demoshop.daoObject.ShopListDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopListDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    long countByExample(ShopListDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int deleteByExample(ShopListDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int insert(ShopListDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int insertSelective(ShopListDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    List<ShopListDO> selectByExample(ShopListDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    ShopListDO selectByPrimaryKey(Integer id);
    List<ShopListDO> selectShopList();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") ShopListDO record, @Param("example") ShopListDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByExample(@Param("record") ShopListDO record, @Param("example") ShopListDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByPrimaryKeySelective(ShopListDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_list
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByPrimaryKey(ShopListDO record);
}