package workingtest.signin.dao;

import workingtest.signin.dataobject.MtcCourseSigninDO;

import java.util.List;

/**
 * @author wlei
 * @version 1.0
 * @Description:课程签到表-数据访问接口类
 * @date 2017/9/15 10:44:40
 */
public interface MtcCourseSigninMapper {

    /**
     * 增加课程签到表
     *
     * @param mtcCourseSigninDO
     * @return
     */
    Long insert(MtcCourseSigninDO mtcCourseSigninDO);

    /**
     * 删除课程签到表
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新课程签到表
     *
     * @param mtcCourseSigninDO
     * @return
     */
    int update(MtcCourseSigninDO mtcCourseSigninDO);

    /**
     * 查询课程签到表（某一个）
     *
     * @param id
     * @return
     */
    MtcCourseSigninDO select(Long id);

    /**
     * 查询课程签到表（全部）
     *
     * @return
     */
    List<MtcCourseSigninDO> selectAll();
}