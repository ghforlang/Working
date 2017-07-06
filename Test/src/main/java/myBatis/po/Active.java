package myBatis.po;

import java.io.Serializable;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 13:23
 *  
 */
public class Active implements Serializable {
    private Long id;
    private String title;
    private String picUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
