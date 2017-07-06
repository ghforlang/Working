package myBatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 13:21
 *  
 */
public class Item implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 商品编码
     */
    private Long numIid;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 商品类目，
     */
    private Integer cat;

    /**
     * 商品主图地址
     */
    private String picUrl;

    /**
     * 商品缩略图
     */
    private String picThumUrl;

    /**
     * 商家编码，
     */
    private String outerId;

    /**
     * 商品属性
     */
    private String props;

    /**
     * 销售价格
     */
    private Double price;

    /**
     * 商品的市场价格
     */
    private Double marketPrice;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品上架时间
     */
    private Date listTime;

    /**
     * 商品下架时间
     */
    private Date delistTime;

    /**
     * 商品销量
     */
    private Integer sales;

    private Date created;

    private Date modified;

    /**
     * 数据可用状态，0表示不可用，1表示可用
     */
    private Integer enableStatus;

    /**
     * 商品的url，不存储数据库
     */
    private String itemTaobaoUrl;

    /**
     * 商品所关联的活动
     */
    private Active active;

    /**
     * 该商品的搭配套餐
     */
    private List<Item> withPackages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicThumUrl() {
        return picThumUrl;
    }

    public void setPicThumUrl(String picThumUrl) {
        this.picThumUrl = picThumUrl;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public Date getDelistTime() {
        return delistTime;
    }

    public void setDelistTime(Date delistTime) {
        this.delistTime = delistTime;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getItemTaobaoUrl() {
        return itemTaobaoUrl;
    }

    public void setItemTaobaoUrl(String itemTaobaoUrl) {
        this.itemTaobaoUrl = itemTaobaoUrl;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    public List<Item> getWithPackages() {
        return withPackages;
    }

    public void setWithPackages(List<Item> withPackages) {
        this.withPackages = withPackages;
    }
}
