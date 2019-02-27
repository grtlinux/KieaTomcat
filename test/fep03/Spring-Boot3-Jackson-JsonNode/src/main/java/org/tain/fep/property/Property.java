package org.tain.fep.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;
import org.tain.yml.YamlPropertySourceFactory;

import lombok.Data;

@Component(value = "fep.property.Property")
@PropertySource(
		value = {
				"classpath:/application.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@ConfigurationProperties(prefix = "fep-property")
@Data
public class Property {

	private static final boolean flag = true;
	
	public Property() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	/*
	 * general
	 */
	private String program = "";

	private Double version = 0.00;

	private String desc = "";


	/*
	 * company and boss
	 */
	private String company = "";

	private String author = "";

	private String phone = "";


	/*
	 * stream connection
	 */
	private boolean active = false;

	private String streamHost = "";

	private Integer streamPort = 0;
	
	/*
	 * info data
	 */
	private String reqData;
	
	private String jsonInfoPath;
	
	private List<String> jsonInfoKeyList;
	
	private String reqFieldInfo;
	
	private String resFieldInfo;
	
	
	
	
	
	
	
}
