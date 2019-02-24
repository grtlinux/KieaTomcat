package org.tain.fep.info;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Item23Info implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FieldInfo> fields;
}
