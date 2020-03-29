package concurrent;

public class SynchronizedDemo {
    //反汇编结果输出到指定文件 javap -c -v SynchronizedDemo.class > SynchronizedDemoByteCode.txt
    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method();
    }

    public void method(){
        synchronized (this){
            System.out.println("synchronized code block!");
        }
    }
}
