package workingtest.course.dao;

import java.util.List;

import workingtest.course.dataobject.MtcCourseDO;

/**
 * @author wlei
 * @version 1.0
 * @Description:医联体第三方课程表-数据访问接口类
 * @date 2017/9/15 10:05:13
 */
public interface MtcCourseMapper {

    /**
     * 增加医联体第三方课程表
     *
     * @param mtcCourseDO
     * @return
     */
    Long insert(MtcCourseDO mtcCourseDO);

    /**
     * 删除医联体第三方课程表
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新医联体第三方课程表
     *
     * @param mtcCourseDO
     * @return
     */
    int update(MtcCourseDO mtcCourseDO);

    /**
     * 查询医联体第三方课程表（某一个）
     *
     * @param id
     * @return
     */
    MtcCourseDO select(Long id);

    /**
     * 查询医联体第三方课程表（全部）
     *
     * @return
     */
    List<MtcCourseDO> selectAll();
}