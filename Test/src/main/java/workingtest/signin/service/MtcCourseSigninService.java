package workingtest.signin.service;


import paginator.Page;
import workingtest.signin.dataobject.MtcCourseSigninDO;

/**
 * @author wlei
 * @version 1.0
 * @Description:课程签到表-业务逻辑接口类
 * @date 2017/9/15 10:44:40
 */
public interface MtcCourseSigninService {

    /**
     * 增加课程签到表
     *
     * @param mtcCourseSigninDO
     * @return
     */
    Long add(MtcCourseSigninDO mtcCourseSigninDO);

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
    MtcCourseSigninDO get(Long id);

    /**
     * 查询课程签到表（分页）
     *
     * @param pageIndex 当前页索引
     * @param pageSize  页大小
     * @return
     */
    Page<MtcCourseSigninDO> getList(int pageIndex, int pageSize);
}

