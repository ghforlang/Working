package myBatis.po;

import java.io.Serializable;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-05 18:18
 *  
 */
public class Project implements Serializable {

    private static final long serialVersionUID = 7085683146112656870L;

    private Integer id;
    private String projName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }
}
