package other.recursion;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/18 17:41
 */
public class SubObjOne {
    private byte[] files;
    private String name = "subObjOne";
    private SubObjTwo subObjTwo;
    public byte[] getFiles() {
        return files;
    }

    public void setFiles(byte[] files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubObjTwo getSubObjTwo() {
        return subObjTwo;
    }

    public void setSubObjTwo(SubObjTwo subObjTwo) {
        this.subObjTwo = subObjTwo;
    }
}
