/**
 * Created by fanwenhao on 2017/3/31.
 */
public class TestFan {
    public static void main(String[] args){
        System.out.println(TestF.getInstance().getData());
        System.out.println(TestF.getInstance().getName());
        System.out.println(new TestF<String>("YYY","data").getName());
    }
}

class TestF<T> {
    private T data;
    private String name;


    public  TestF(T data,String name){
        this.data = data;
        this.name = name;
    }

    public static <T>TestF<T> getInstance(){
        return new TestF("XXX","DATA");
    }

    public TestF<T> getTestFObject(){
        return this;
    }

    public <T> T getInstance2(){
        return null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

