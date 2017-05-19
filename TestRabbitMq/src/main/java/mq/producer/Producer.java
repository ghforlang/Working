package mq.producer;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-18 14:07
 *  
 */
public interface Producer {
    /**
     *发送消息到指定队列
     * @param queueKey
     * @param object
     */
    public void pushMessageToMq(String queueKey, Object object);
}
