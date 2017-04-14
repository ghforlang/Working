package paginator.po;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 16:20
 *  
 */
public class UserExample {
    private int start;//设置分页开始
    private int limit;//设置分页的每页数量

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
