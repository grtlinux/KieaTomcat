package org.tain.fep.info;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ReqFieldInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MastInfo mastInfo;
	private StoreInfo storeInfo;
	private List<Item01Info> listItem01Info;
	private Item23Info item23Info;
}
