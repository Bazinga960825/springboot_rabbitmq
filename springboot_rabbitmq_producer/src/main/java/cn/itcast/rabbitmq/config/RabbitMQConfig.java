package cn.itcast.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Zac Dong
 * @Date 2019/10/30 19:45
 * @Version 1.0
 */
@Configuration
public class RabbitMQConfig {
    //交换机与队列名称
    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";
    public static final String ITEM_QUEUE = "item_queue";

    //声明交换机
    @Bean("itemTopicExchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }

    //声明队列
    @Bean("itemQueue")
    public Queue itemQueue() {
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }

    //绑定交换机与队列
    @Bean
    public Binding itemExchangeQueue(@Qualifier("itemTopicExchange") Exchange exchange,
                                     @Qualifier("itemQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs(); //noargs:不指定其他参数
    }

}
