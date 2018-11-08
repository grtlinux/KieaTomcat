package sample1;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MessageBeanImpl extends QuartzJobBean implements MessageBean {

	//private Logger log = LoggerFactory.getLogger(this.getClass());
	private Log log = LogFactory.getLog(this.getClass());

	private String name;
	private String greeting;

	public void setName(String name) {
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		String message = this.greeting + this.name + "!";
		// logger.info("ThreadId={}: {}", Thread.currentThread().getId(), message);
		log.info("ThreadId=" + Thread.currentThread().getId() + ": " + message);
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		sayHello();
		// System.out.println(">>>>> " + new Date().toLocaleString());
	}
}
