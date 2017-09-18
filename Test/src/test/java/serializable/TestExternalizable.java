package serializable;

import org.junit.Test;

import java.io.*;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-01 10:14
 *  
 */

public class TestExternalizable {
    @Test
    public void testExternalizable() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        ExStudent es = new ExStudent();
        es.setAge(20);
        es.setName("张三");

        oos.writeObject(es);
        //Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        ExStudent newInstance = (ExStudent) ois.readObject();
        //output
        System.out.println(newInstance);
    }
}
