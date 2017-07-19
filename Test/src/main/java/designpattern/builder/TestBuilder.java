package designpattern.builder;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 15:06
 *  
 */
public class TestBuilder {

    private static String name = "张三";
    private static int age = 10;
    private static int height = 175;
    private static int sex = 0; //0表示男性，1表示女性，其它值非法

    private static String schoolName = "宁波大学";
    private static String profession = "计算机技术";
    //要求分班的时候，名字相同的同学不能分配到一个班级
    private static int gradeNo = 2;//年级编号

    //扩展信息
    private static String idCard = "4895561199001082144";//身份证号
    private static String stuNo = "1211082149";//学号
    private static String labName = "cloudLab";//实验室名称
    private static String dormitoryAddress = "2号宿舍楼";//宿舍地址

    public static void main(String[] args) {
        Student.Builder builder = new Student.Builder(name,age,height,sex);
        Student student = builder.build();
        System.out.println(student);

        student = builder.schoolName(schoolName)
                        .profession(profession)
                        .graderNo(gradeNo)
                        .idCard(idCard)
                        .stuNo(stuNo)
                        .labName(labName)
                        .domitoryAddress(dormitoryAddress).build();
        System.out.println(student);
    }
}
