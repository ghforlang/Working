package jms.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/3/14 10:10
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        //声明并初始化一个producer
        DefaultMQProducer producer = new DefaultMQProducer("producer1");

        //设置nameServer，多个地址之间用;分隔；nameServer的地址也可以通过环境变量的方式设置;
        producer.setNamesrvAddr("127.0.0.1");

        //启动一个producer实例
        producer.start();

        for(int i=0;i<10;i++){
            Message message = new Message("topicTest","tagA",("hello rocketMq" + i).getBytes());

            //调用producer的send方法发送消息
            //这里是同步调用，所以会有返回结果
            SendResult sendResult = producer.send(message);

            System.out.println(sendResult);
        }

        //发送完毕，关闭producer
        producer.shutdown();
    }
}
