import mq.producer.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-18 14:23
 * &nbsp;
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-mq.xml"})
public class TestQueue {

    @Autowired
    private MqProducer mqProducer;

    private static final String queue_key = "test_queue_key";

    @Test
    public void testSend(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("data","hello rabbitMq");
        mqProducer.pushMessageToMq(queue_key,map);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
