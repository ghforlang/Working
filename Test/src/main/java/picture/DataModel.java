package picture;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 14:35
 */
public class DataModel {
    /**
     * 头部
     */
    private ModelHead head;
    /**
     * 内容
     */
    private ModelBody body;
    /**
     * 底部
     */
    private ModelFooter footer;

    public ModelHead getHead() {
        return head;
    }

    public void setHead(ModelHead head) {
        this.head = head;
    }

    public ModelBody getBody() {
        return body;
    }

    public void setBody(ModelBody body) {
        this.body = body;
    }

    public ModelFooter getFooter() {
        return footer;
    }

    public void setFooter(ModelFooter footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "DataModel[" +
                "head=" + head +
                ", body=" + body +
                ", footer=" + footer +
                ']';
    }
}


