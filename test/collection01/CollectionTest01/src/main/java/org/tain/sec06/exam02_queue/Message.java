package org.tain.sec06.exam02_queue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

	private String command;
	private String to;
}
