/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-04 16:15
 *  
 */
package myBatis.plugin;

//这个插件使用起来十分简单，只要传递给MyBatis的SqlMap以下的方式都是允许的：
//        1、继承com.learn.mybatis.plugin.PageParams
//        2、使用map，但是map中的键值对应，有一个值是com.learn.mybatis.plugin.PageParams类型
//        3、使用@Param注解，只要里面有一个参数是com.learn.mybatis.plugin.PageParams类型
//        4、使用POJO，但是这个POJO中有一个属性为com.learn.mybatis.plugin.PageParams类型