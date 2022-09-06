package com.optum.websocket.controller;

import com.optum.websocket.model.Greeting;
import com.optum.websocket.model.Profanity;
import com.optum.websocket.model.Word;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Word word) throws Exception {
        Thread.sleep(1000); // simulated delay
        if(Profanity.getProfanityList().stream().anyMatch(word.getContent()::equalsIgnoreCase)){
            Greeting greeting = new Greeting("You have used abusive word : "+word.getContent());
            return greeting;
        } else {
            return new Greeting(word.getContent());
        }
    }

}
