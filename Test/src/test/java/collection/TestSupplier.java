package collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:41
 *  
 */
public class TestSupplier {
    Logger LOGGER = Logger.getLogger(TestSupplier.class);

    @Test
    public void testSupplier(){
        //Supplier<T> - 没有任何输入，返回T(无参函数)
        Supplier<String> supp = () -> {return "Supplier";};
        Supplier<String> supp1 = ()->{return "supp";};
        LOGGER.info(supp.get());
        LOGGER.info(supp1.get());
    }
}
