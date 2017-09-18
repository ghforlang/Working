package workingtest.course.dataobject;

import lombok.Data;

/**
 * @author wlei
 * @version 1.0
 * @Description:医联体第三方课程表-DO类
 * @date 2017/9/15 10:05:13
 */
@Data
public class MtcCourseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 课程key，id+随机数
     */
    private String courseKey;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程来源，1-医邻网
     */
    private Long courseSource;

    /**
     * 课程分类
     */
    private Long courseClassification;

    /**
     * 讲师姓名
     */
    private String lecturerName;

    /**
     * 讲师所在单位
     */
    private String lecturerUnit;

    /**
     * 讲师职称
     */
    private Long lecturerTitle;

    /**
     * 课程url
     */
    private String courseUrl;

    /**
     * 课程封面图片url
     */
    private String courseCoverUrl;

    /**
     * 排序号
     */
    private Long sortNo;

    @Override
    public String toString() {
        return "MtcCourseDO[" +
                "id=" + id +
                ", courseKey='" + courseKey + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseSource=" + courseSource +
                ", courseClassification=" + courseClassification +
                ", lecturerName='" + lecturerName + '\'' +
                ", lecturerUnit='" + lecturerUnit + '\'' +
                ", lecturerTitle=" + lecturerTitle +
                ", courseUrl='" + courseUrl + '\'' +
                ", courseCoverUrl='" + courseCoverUrl + '\'' +
                ", sortNo=" + sortNo +
                ']';
    }
}
