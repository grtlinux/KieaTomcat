package org.tain.fep.info;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ReqDataInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> mastData;
	private Map<String, String> storeData;
	private List<Map<String, String>> listItem01Data;
	private Map<String, String> item23Data;
}
