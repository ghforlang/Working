package myBatis.dao;

import myBatis.po.Active;
import myBatis.po.Item;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 13:25
 *  
 */
public interface ItemMapper {
    /**
     * 查询单个商品,并装载活动和搭配套餐
     * @param id
     * @return
     */
    Item queryDetailById(Long id);

    /**
     *selectActive
     * @param itemId
     * @return
     */
    Active selectActive(Long itemId);

    /**
     * 根据商品id得到搭配套餐中的商品
     * @param itemId
     * @return
     */
    List<Item> selectWithPackages(Long itemId);
}
