package jms.activemq;

import util.JsonUtils;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Objects;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/3/8 11:25
 */
public class JmsDemo {
    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    Destination destination;
    MessageProducer producer;
    MessageConsumer consumer;
    Message message;
    boolean useTransaction = false;

    public void connect() throws JMSException {
        try {
            Context ctx = new InitialContext();
            //创建连接工厂
            connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactoreName");
            //创建连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession();
            //获取destination
            destination = session.createQueue("TEST.QUEUE");

            //生产者发送消息
            producer = session.createProducer(destination);
            message = session.createTextMessage("this is a test");

            //消费者同步接收
            consumer = session.createConsumer(destination);
            message = consumer.receive(1000);

            //消费者异步接收
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if(Objects.nonNull(message)){
                        System.out.println(JsonUtils.toJSon(message));
                    }
                }
            });

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            producer.close();
            session.close();
            connection.close();
        }
    }
}
