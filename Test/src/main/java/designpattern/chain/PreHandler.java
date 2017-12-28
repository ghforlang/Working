package designpattern.chain;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 16:04
 */
public class PreHandler extends Handler {

    @Override
    public void handleRequest() {
    /*
    判断是否有后继的责任对象
    如果有，就转发请求给后继的责任对象
    如果没有，则处理请求
    */if (getSuccessor() != null) {
            System.out.println(this.getClass().getSimpleName() +"放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println(this.getClass().getSimpleName() +"处理请求");
        }
    }
}
