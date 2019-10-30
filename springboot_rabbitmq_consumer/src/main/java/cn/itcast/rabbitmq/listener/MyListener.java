package cn.itcast.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Zac Dong
 * @Date 2019/10/30 20:06
 * @Version 1.0
 */
@Component
public class MyListener {

    /**
     * 监听某个队列的消息
     *
     * @param message
     */
    @RabbitListener(queues = "item_queue")
    public void rabbitMQListener(String message) {
        System.out.println("监听到的消息为：" + message);
    }
}
