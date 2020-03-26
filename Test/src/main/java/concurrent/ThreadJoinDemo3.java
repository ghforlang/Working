package concurrent;

public class ThreadJoinDemo3 {

    //参考 ThreadDemo

    public static void main(String[] args) {
        Thread preThread = Thread.currentThread();
        for (int i=0;i<10;i++){
            JoinThread joinThread = new JoinThread(preThread);
            joinThread.start();;
            preThread = joinThread;
        }
    }


    static class JoinThread extends  Thread{
        Thread preJoinThread;

        public JoinThread(Thread preJoinThread) {
            this.preJoinThread = preJoinThread;
        }

        @Override
        public void run() {
//            try {
//                preJoinThread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println(preJoinThread.getName() +" terminated");
        }
    }
}
