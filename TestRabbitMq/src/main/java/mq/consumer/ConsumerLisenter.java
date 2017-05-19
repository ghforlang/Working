package mq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-18 14:16
 *  
 */
@Service
public class ConsumerLisenter implements MessageListener {

    public void onMessage(Message message) {
        try{
            System.out.println("result: " + message.getBody());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
