package org.tain.fep.info;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class ResDataInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> mastData;
}
