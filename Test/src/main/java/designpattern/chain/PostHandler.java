package designpattern.chain;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 16:25
 */
public class PostHandler extends Handler {

    @Override
    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println(this.getClass().getSimpleName() +"放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println(this.getClass().getSimpleName() +"处理请求");
        }
    }
}
