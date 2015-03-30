package idv.hsiehpinghan.thsr.utility;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringUtility {
	private static GenericXmlApplicationContext genericXmlApplicationContext;
	
	public static GenericXmlApplicationContext getGenericXmlApplicationContext() {
        if (genericXmlApplicationContext == null){
            synchronized(GenericXmlApplicationContext.class){
                if(genericXmlApplicationContext == null) {
                	genericXmlApplicationContext = new GenericXmlApplicationContext();
                	genericXmlApplicationContext.load("classpath:applicationContext.xml");
                	genericXmlApplicationContext.refresh();
                }
            }
        }
        
		return genericXmlApplicationContext;
	}
}