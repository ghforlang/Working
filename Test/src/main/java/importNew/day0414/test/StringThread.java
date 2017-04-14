package importNew.day0414.test;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-14 13:23
 *  
 */
public class StringThread implements Runnable {
    private String ip;
    private static final String PREFIXX = "BIZ";

    public StringThread(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        String lock = buildLock();
        synchronized (lock){
            System.out.println("线程[" + Thread.currentThread().getName() + "]" + "开始运行" );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程[" + Thread.currentThread().getName() + "]" + "运行结束" );
        }

    }

    public String buildLock(){
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIXX);
        sb.append(ip);

//        String lock = sb.toString().intern();//字符串常量问题，常量池
        String lock = sb.toString();
        System.out.println(Thread.currentThread().getName() + "构建了锁 : " + lock );

        return lock;
    }

}
