package threadlocal;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/5/17 10:29
 */
public class TestCaseOne {

    public final static ThreadLocal<String> RESOURCE_ONE = new ThreadLocal<>();
    public final static ThreadLocal<String> RESOURCE_TWO = new ThreadLocal<>();

    class A{
        public void setOne(String value){
            RESOURCE_ONE.set(value);
        }

        public void setTwo(String value){
            RESOURCE_TWO.set(value);
        }
    }


    class B {
        public void display(){
            System.out.println(RESOURCE_ONE.get() +  "  -  " + RESOURCE_TWO.get());
        }
    }

    public void caseOneTest(){
        final A a = new A();
        final B b = new B();

        for (int i=0;i<15;i++){
            final String resource1 = "线程-" + i;
            final String resource2 = " value = (" + i + ")";
            new Thread(){
                @Override
                public void run() {
                    try{
                        a.setOne(resource1);
                        a.setTwo(resource2);
                        b.display();
                    }finally {
                        RESOURCE_ONE.remove();
                        RESOURCE_TWO.remove();
                    }
                }
            }.start();
        }
    }

}
