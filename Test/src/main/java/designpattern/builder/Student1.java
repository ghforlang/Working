package designpattern.builder;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 14:52
 *  
 */
public class Student1 {
    private String name;
    private int age;
    private int height;
    private int sex; //0表示男性，1表示女性，其它值非法


    private String schoolName;
    private String profession;
    //要求分班的时候，名字相同的同学不能分配到一个班级
    private int gradeNo;//年级编号

    //扩展信息
    private String idCard;//身份证号
    private String stuNo;//学号
    private String labName;//实验室名称
    private String dormitoryAddress;//宿舍地址
    /**
     *  创建一个基本学生信息 ，例如在研究生入学体检时，不需要专业、年级信息，
     *  因此，可以只适用必须的参数创建一个基本信息
     * @param name
     * @param age
     * @param height
     * @param sex
     */
    public Student1(String name, int age, int height, int sex) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
    }

    /**
     * 创建一个基本学生信息 ，研究生正式录取后，学校的学生信息管理系统需要学生基本信息
     * @param name
     * @param age
     * @param height
     * @param sex
     * @param schoolName
     * @param profession
     */
    public Student1(String name, int age, int height, int sex,
                   String schoolName, String profession) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
        this.schoolName = schoolName;
        this.profession = profession;
    }
    /**
     * 开学了，为了教学方便，学校进行了分班，同时要求在创建分班的时候，
     * 要求名字相同不分到同一个班级
     * @param name
     * @param age
     * @param height
     * @param sex
     * @param schoolName
     * @param profession
     * @param gradeNo
     * @throws Exception
     */
    public Student1(String name, int age, int height, int sex,
                   String schoolName, String profession, int gradeNo) throws Exception {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
        this.schoolName = schoolName;
        this.profession = profession;
        this.gradeNo = gradeNo;
        if(isValidStudent() == false)
            throw new Exception("不合法的学生信息，同名的学生不能分到同一个班级...");
    }

    /**
     * 学生信息合法性校验
     * @return
     */
    public boolean isValidStudent(){
        boolean flag = true;
        //TODO 进行用户信息合法性校验
        return flag;
    }

    public Student1(String name, int age, int height, int sex,
                   String schoolName, String profession, int gradeNo, String idCard,
                   String stuNo, String labName, String dormitoryAddress) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
        this.schoolName = schoolName;
        this.profession = profession;
        this.gradeNo = gradeNo;
        this.idCard = idCard;
        this.stuNo = stuNo;
        this.labName = labName;
        this.dormitoryAddress = dormitoryAddress;
    }
}
