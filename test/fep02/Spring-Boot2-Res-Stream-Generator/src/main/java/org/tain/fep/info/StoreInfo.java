package org.tain.fep.info;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class StoreInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<FieldInfo> fields;
}
