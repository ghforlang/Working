package workingtest.course.service;


import paginator.Page;
import workingtest.course.dataobject.MtcCourseDO;

/**
 * @author wlei
 * @version 1.0
 * @Description:医联体第三方课程表-业务逻辑接口类
 * @date 2017/9/15 10:05:13
 */
public interface MtcCourseService {

    /**
     * 增加医联体第三方课程表
     *
     * @param mtcCourseDO
     * @return
     */
    Long add(MtcCourseDO mtcCourseDO);

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
    MtcCourseDO get(Long id);

    /**
     * 查询医联体第三方课程表（分页）
     *
     * @param pageIndex 当前页索引
     * @param pageSize  页大小
     * @return
     */
    Page<MtcCourseDO> getList(int pageIndex, int pageSize);
}

