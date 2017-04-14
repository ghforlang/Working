package paginator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 16:43
 *  
 */
public class Page<T> {
    public static final int DEFAULT_PAGE_SIZE = 10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        computeTotalPate();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        computeTotalPate();
    }

    public void computeTotalPate(){
        if(getPageSize() > 0 && getTotal() > -1){
            this.totalPage = (int)(getTotal() % getPageSize() == 0 ? getTotal()/getPageSize() : (getTotal()/getPageSize()) + 1);
        }
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    protected int pageNo =  1;//默认当前页
    protected int pageSize = DEFAULT_PAGE_SIZE;//每页记录数

    protected long total = -1;//总记录数，默认为-1，表示需要查询
    protected long totalPage = -1;//总记录页数，默认为-1，表示需要计算

    protected List<T> result;//当前页记录list

    public Map<String,Object> params = new HashMap<String,Object>();

    public Map<String,Object> getParams(){
        return params;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", result=" + result +
                ", params=" + params +
                '}';
    }
}
