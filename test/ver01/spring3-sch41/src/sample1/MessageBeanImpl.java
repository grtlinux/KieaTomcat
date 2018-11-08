package sample1;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageBeanImpl implements MessageBean {

	private Log log = LogFactory.getLog(this.getClass());

	private String name;
	private String greeting;

	public MessageBeanImpl(String name) {
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		String message = this.greeting + this.name + "! " + date.toLocaleString();
		log.info("ThreadId=" + Thread.currentThread().getId() + ": " + message);
	}
}
