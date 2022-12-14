import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class QPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection  = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "Hello. Message to queue";
        channel.basicPublish("","queue-1",null, message.getBytes());
        System.out.println("Message sent to the queue by the Publisher");
        channel.close();
    }
}
