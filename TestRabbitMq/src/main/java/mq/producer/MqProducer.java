package mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-18 14:09
 *  
 */
@Service
public class MqProducer implements Producer{
    @Resource
    private AmqpTemplate amqpTemplate;

    private static final Logger LOGGER = Logger.getLogger("MqProducer");

    public void pushMessageToMq(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        }catch(Exception e){
            LOGGER.log(Level.INFO,e.getMessage());
        }
    }
}
