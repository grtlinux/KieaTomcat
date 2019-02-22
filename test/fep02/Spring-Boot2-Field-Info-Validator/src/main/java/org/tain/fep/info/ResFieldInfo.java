package org.tain.fep.info;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResFieldInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ResMastInfo resMastInfo;
}
