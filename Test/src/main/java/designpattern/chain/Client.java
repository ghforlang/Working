package designpattern.chain;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 16:14
 */
public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new PreHandler();
        Handler handler2 = new PostHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }
}
