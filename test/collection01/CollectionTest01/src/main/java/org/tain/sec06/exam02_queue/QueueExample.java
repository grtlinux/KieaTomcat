package org.tain.sec06.exam02_queue;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "QueueExample")
public class QueueExample {

	public QueueExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "홍두께"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.getCommand()) {
				case "sendMail":
					System.out.println(message.getTo() + "님에게 메일을 보냅니다.");
					break;
				case "sendSMS":
					System.out.println(message.getTo() + "님에게 SMS를 보냅니다.");
					break;
				case "sendKakaotalk": 
					System.out.println(message.getTo() + "님에게 카카오톡를 보냅니다.");
					break;
			}
		}
	}
}
