package org.tain.example.json03;

import java.io.Serializable;
import java.util.List;

import org.tain.example.info.FieldInfo;

import lombok.Data;

@Data
public class StoreInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<FieldInfo> fields;
}
