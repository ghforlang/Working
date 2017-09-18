package workingtest.signin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import paginator.Page;
import workingtest.signin.dao.MtcCourseSigninMapper;
import workingtest.signin.dataobject.MtcCourseSigninDO;
import workingtest.signin.service.MtcCourseSigninService;

import javax.annotation.Resource;

/**
 * @author wlei
 * @version 1.0
 * @Description:课程签到表-业务逻辑实现类
 * @date 2017/9/15 10:44:40
 */
@Service
@Slf4j
public class MtcCourseSigninServiceImpl implements MtcCourseSigninService {

    Logger log = LoggerFactory.getLogger(MtcCourseSigninServiceImpl.class);
    @Resource
    private MtcCourseSigninMapper mtcCourseSigninMapper;

    public Long add(MtcCourseSigninDO mtcCourseSigninDO) {
        log.info("入参mtcCourseSigninDO={}", mtcCourseSigninDO.toString());
        return mtcCourseSigninMapper.insert(mtcCourseSigninDO);
    }

    public int delete(Long id) {
        return mtcCourseSigninMapper.delete(id);
    }

    public int update(MtcCourseSigninDO mtcCourseSigninDO) {
        return mtcCourseSigninMapper.update(mtcCourseSigninDO);
    }

    public MtcCourseSigninDO get(Long id) {
        return mtcCourseSigninMapper.select(id);
    }

    public Page<MtcCourseSigninDO> getList(int pageIndex, int pageSize) {
        Page<MtcCourseSigninDO> pages = null;
//                =PageHelper.startPage(pageIndex,pageSize)
//		        .doSelectPage(()->mtcCourseSigninMapper.selectAll());
        return pages;
    }

}
