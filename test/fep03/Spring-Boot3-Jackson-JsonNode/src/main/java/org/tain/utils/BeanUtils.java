package org.tain.utils;

import org.springframework.context.ApplicationContext;

public class BeanUtils {

	public static Object getBean(String beanId) {
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
		if (applicationContext == null) {
			throw new NullPointerException("not initialized (Spring ApplicationContext..");
		}
		
		/*
		String[] names = applicationContext.getBeanDefinitionNames();
		for (int i=0; i < names.length; i++) {
			System.out.println(">>>>> bean.name = " + names[i]);
		}
		*/
		
		return applicationContext.getBean(beanId);
	}
}
