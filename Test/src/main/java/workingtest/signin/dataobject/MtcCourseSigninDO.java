package workingtest.signin.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author wlei
 * @version 1.0
 * @Description:?????-DO?
 * @date 2017/9/15 10:44:40
 */
@Data
public class MtcCourseSigninDO {

    /**
     * ??id
     */
    private Long id;

    /**
     * ????key
     */
    private String courseSigninKey;

    /**
     * ????
     */
    private String courseName;

    /**
     * ????
     */
    private String lecturerName;

    /**
     * ?????
     */
    private String learnerName;

    /**
     * ???????
     */
    private String learnerUnit;

    /**
     * ?????
     */
    private String learnerTitle;

    /**
     * ????
     */
    private Date signInTime;

    @Override
    public String toString() {
        return "MtcCourseSigninDO[" +
                "id=" + id +
                ", courseSigninKey='" + courseSigninKey + '\'' +
                ", courseName='" + courseName + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", learnerName='" + learnerName + '\'' +
                ", learnerUnit='" + learnerUnit + '\'' +
                ", learnerTitle='" + learnerTitle + '\'' +
                ", signInTime=" + signInTime +
                ']';
    }
}
