package com.lodentech.camel.demo.blueprint;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A bean which we use in the route
 */
public class HelloBean implements Hello {
	private final Logger logger = LoggerFactory.getLogger( HelloBean.class );
	
    private String say = "Hello World";

    public String hello() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return say + " at " + sdf.format(new Date());
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
    
    public String logHello( String msg ) {
    	logger.info( msg );
    	
    	return msg;
    }
}
