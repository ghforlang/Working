package designpattern.builder;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-19 14:56
 *  
 */
public class Student {
    private final String name;
    private final int age;
    private final int height;
    private final int sex; //0表示男性，1表示女性，其它值非法


    private final String schoolName;
    private final String profession;
    //要求分班的时候，名字相同的同学不能分配到一个班级
    private final int gradeNo;//年级编号

    //扩展信息
    private final  String idCard;//身份证号
    private final String stuNo;//学号
    private final String labName;//实验室名称
    private final String dormitoryAddress;//宿舍地址

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.sex = builder.sex;

        this.schoolName = builder.schoolName;
        this.profession = builder.profession;
        this.gradeNo = builder.gradeNo;

        this.idCard = builder.idCard;
        this.stuNo = builder.stuNo;
        this.labName = builder.labName;
        this.dormitoryAddress = builder.dormitoryAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", sex=" + sex +
                ", schoolName='" + schoolName + '\'' +
                ", profession='" + profession + '\'' +
                ", gradeNo=" + gradeNo +
                ", idCard='" + idCard + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", labName='" + labName + '\'' +
                ", dormitoryAddress='" + dormitoryAddress + '\'' +
                '}';
    }

    public static class Builder{
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

        public Builder(String name, int age, int height, int sex) {
            super();
            this.name = name;
            this.age = age;
            this.height = height;
            this.sex = sex;
        }

        public Builder schoolName(String schoolName){
            this.schoolName = schoolName;
            return this;
        }

        public Builder profession(String profession){
            this.profession = profession;
            return this;
        }

        public Builder graderNo(int gradeNo){
            this.gradeNo = gradeNo;
            return this;
        }

        public Builder idCard(String idCard){
            this.idCard = idCard;
            return this;
        }

        public Builder stuNo(String stuNo){
            this.stuNo = stuNo;
            return this;
        }

        public Builder labName(String labName){
            this.labName = labName;
            return this;
        }

        public Builder domitoryAddress(String dormitoryAddress){
            this.dormitoryAddress = dormitoryAddress;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
