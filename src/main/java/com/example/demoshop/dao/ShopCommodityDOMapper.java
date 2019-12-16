package com.example.demoshop.dao;

import com.example.demoshop.daoObject.ShopCommodityDO;
import com.example.demoshop.daoObject.ShopCommodityDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCommodityDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    long countByExample(ShopCommodityDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int deleteByExample(ShopCommodityDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int insert(ShopCommodityDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int insertSelective(ShopCommodityDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    List<ShopCommodityDO> selectByExample(ShopCommodityDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    ShopCommodityDO selectByPrimaryKey(Integer id);
    List<ShopCommodityDO> selectShopCommodityListByShopId(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") ShopCommodityDO record, @Param("example") ShopCommodityDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByExample(@Param("record") ShopCommodityDO record, @Param("example") ShopCommodityDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByPrimaryKeySelective(ShopCommodityDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_commodity
     *
     * @mbg.generated Fri Nov 29 16:06:44 CST 2019
     */
    int updateByPrimaryKey(ShopCommodityDO record);
}