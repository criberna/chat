package org.cloudfoundry.samples.rabbitmq.chat;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ChatController {
	
	@Autowired(required = false)
	MongoTemplate mongoTemplate;

	@Autowired
	private volatile AmqpTemplate amqpTemplate;

	private final Queue<String> chatMessages = new LinkedBlockingQueue<String>();

	@RequestMapping(value = "/")
	public String home() {
		return "WEB-INF/views/chat.jsp";
	}
	int i=0;

	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void publish(@RequestParam String username, @RequestParam String text) {
		amqpTemplate.convertAndSend("chatQueue", username + ": " + text);// routingkey
		
		ChatMessage m = new ChatMessage(""+(i++), "", "chatQueue", text, "", username);
		mongoTemplate.save(m);
	}

	@RequestMapping(value = "/chatlog")
	@ResponseBody
	public String chatlog() {
		return StringUtils.arrayToDelimitedString(this.chatMessages.toArray(),
				"<br/>");
	}

	/**
	 * This method is invoked when a RabbitMQ Message is received.
	 */
	public void handleChatMessage(String message) {
		if (chatMessages.size() > 100) {
			chatMessages.remove();
			// mostra solo gli ultimi 100
		}
		//List<ChatMessage> m = mongoTemplate.find(query(where("routingKey").is("chatQueue")), ChatMessage.class);        
		chatMessages.add(message);
	}

}
