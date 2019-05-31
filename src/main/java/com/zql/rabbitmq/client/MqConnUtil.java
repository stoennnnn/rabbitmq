package com.zql.rabbitmq.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zql.rabbitmq.config.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by  @ZQL  on 2019/5/31.
 */
@Component
public class MqConnUtil {
    @Autowired
    private MqConfig mqConfig;

    /**
     * Title: getConnection<br>
     * Author: 26725<br>
     * Description: 通过connectionFactory获取connection,Connecting to a broker<br>
     * Date:  10:51 <br>
     * @param 
     */
    public Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(mqConfig.getAccount());
        factory.setPassword(mqConfig.getPassword());
        factory.setHost(mqConfig.getHost());
        factory.setPort(Integer.valueOf(mqConfig.getPort()));
        Connection connection =  factory.newConnection();
        return connection;
    }

    /**
     * Title: getChannel<br>
     * Author: 26725<br>
     * Description: Connection接口被用来open一个channel:<br>
     * Date:  10:59 <br>
     * @param connection
     * return: com.rabbitmq.client.Channel
     */
    public Channel getChannel(Connection connection ){
        Channel channel = null;
        if (null != connection) {
            try {
                channel = connection.createChannel();
                channel.queueDeclare(mqConfig.getQueues(), false, false, false, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  channel;
    }

    /**
     * Title: closeConnection<br>
     * Author: 26725<br>
     * Description:关闭connection后channel也会关闭<br>
     * Date:  11:00 <br>
     * @param connection
     * return: void
     */
    public void closeConnection(Connection connection){
        if (null!=connection){
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
