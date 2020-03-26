import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/19 16:37
 */
public class TestIdentifyNo {

    public static void main(String[] args) {
//        List<String> identfyNos = new ArrayList<>();
//
//        System.out.println();

        String str = "http://baidu.com/GEH27541663.jpg?token=NWMyM2E3NWFiY2YzNTQ1MmRiOTYzOWE3YzgwYTFlYTlfTUQ1COUSTOM";
        int index = str.lastIndexOf("/");
        str = str.substring(index + 1);
        int fileIndex = 1;
        if(str.contains(".")){
            fileIndex = str.indexOf(".");
        }else if(str.contains("?")){
            fileIndex = str.indexOf("?");
        }else if(str.contains("token")){
            fileIndex = str.indexOf("token");
        }
        str = str.substring(0,fileIndex);
        System.out.println(str);
    }

//    private static List<String> identifyNoMask(List<String> strs){
//        return null;
//    }

}
