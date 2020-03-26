package myBatis.dao;

import myBatis.plugin.PageParams;
import myBatis.plugin.TestPageParams1;
import myBatis.plugin.TestPageParams2;
import myBatis.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-20 15:27
 *  
 */
public interface UserMapper {

    @Insert("insert into user(user_name,password,role_name,note_info,create_time,update_time)\n" +
            "        values\n" +
            "        (#{userName},#{password},#{roleName},#{noteInfo},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int save(User user);


    //不含分页参数，就不会启用
    public User findUserById (Long userId);
    //继承方式
//    public List<User> selectAllUser(TestPageParams1 param);
    //参数为POJO，但是POJO内部包含一个类型为com.learn.mybatis.plugin.PageParams的属性
    public List<User> selectAllUser2(TestPageParams2 param);
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "user_name",property = "userName"),
                    @Result(column = "role_name",property = "roleName"),
                    @Result(column = "password",property = "password"),
//                    one = @One(select = "myBatis.dao.UserMapper.findUserById"),

                    @Result(column = "note_info",property = "noteInfo"),
//                    manay = @Many(select="myBatis.dao.UserMapper.selectUserByMap")
            }
    )
    //使用map,里面有一个com.learn.mybatis.plugin.PageParams类型的值
    public List<User> selectUserByMap(Map<String, Object> params);

    //使用注解的形式传递分页参数。
    public List<User> selectUserByMap2(@Param("roleName") String roleName, @Param("page") PageParams pageParams);

}
