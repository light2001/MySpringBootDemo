package com.myspring.cli.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping(value="/Message")
@Api(value="消息测试",tags="消息测试")
public class SendMessageController {
//   使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    RabbitTemplate rabbitTemplate;

    private int i=0;
    @ApiOperation(value = "消息发送测试")
    @RequestMapping(value="sendDirectMessage", method = RequestMethod.GET)
    public String sendDirectMessage() {

        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!" + i;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        try{
            rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        }catch (Exception ex){
            throw ex;
        }
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        i++;
        return "ok";
    }

    @ApiOperation(value = "topic,mam发送测试")
    @RequestMapping(value="sendTopicMessageMan", method = RequestMethod.GET)
    public String sendTopicMessage1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N "+i;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        i++;
        return "ok";
    }

    @ApiOperation(value = "topic,woman发送测试")
    @RequestMapping(value="sendTopicMessageWoman", method = RequestMethod.GET)
    public String sendTopicMessage2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all "+ i;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        i++;
        return "ok";
    }

}
