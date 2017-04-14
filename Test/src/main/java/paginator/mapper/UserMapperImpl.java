package paginator.mapper;

import org.apache.ibatis.session.RowBounds;
import paginator.Page;
import paginator.po.User;
import paginator.po.UserExample;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 16:14
 *  
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int save(User user) {
        return save(user);
    }

    @Override
    public List<User> select(User user) {
        List<User> list = new ArrayList<User>();
        RowBounds rowBounds = new RowBounds(0,5);
        UserExample example = new UserExample();
        Page<User> page = new Page<User>();
        return null;
    }
}
