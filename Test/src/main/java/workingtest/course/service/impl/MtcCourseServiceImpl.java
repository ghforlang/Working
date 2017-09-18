package workingtest.course.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import paginator.Page;
import workingtest.course.dao.MtcCourseMapper;
import workingtest.course.dataobject.MtcCourseDO;
import workingtest.course.service.MtcCourseService;

import javax.annotation.Resource;


/**
 * @author wlei
 * @version 1.0
 * @Description:医联体第三方课程表-业务逻辑实现类
 * @date 2017/9/15 10:05:13
 */
@Service
@Slf4j
public class MtcCourseServiceImpl implements MtcCourseService {

    private static Logger log = LoggerFactory.getLogger(MtcCourseServiceImpl.class);
    @Resource
    private MtcCourseMapper mtcCourseMapper;

    public Long add(MtcCourseDO mtcCourseDO) {
        log.info("入参mtcCourseDO={}", mtcCourseDO);
        return mtcCourseMapper.insert(mtcCourseDO);
    }

    public int delete(Long id) {
        return mtcCourseMapper.delete(id);
    }

    public int update(MtcCourseDO mtcCourseDO) {
        return mtcCourseMapper.update(mtcCourseDO);
    }

    public MtcCourseDO get(Long id) {
        return mtcCourseMapper.select(id);
    }

    public Page<MtcCourseDO> getList(int pageIndex, int pageSize) {
        Page<MtcCourseDO> pages = null;
        return pages;
    }

}
