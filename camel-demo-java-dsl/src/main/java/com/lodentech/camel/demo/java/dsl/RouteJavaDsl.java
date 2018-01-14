/**
 * 
 * Copyright (c) 2017 - Loden Technologies, LLC
 */
package com.lodentech.camel.demo.java.dsl;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dennis
 *
 */
public class RouteJavaDsl extends RouteBuilder {
	final Logger logger = LoggerFactory.getLogger(RouteJavaDsl.class);

	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		logger.info( "configuring RouteJavaDsl");

		/*
		 * create the temporary folder to be used by the Java DSL endpoint
		 */
		File dirTemp = new File( System.getProperty("java.io.tmpdir") );
		
		File dirCamel = new File(dirTemp, "Camel");
		if ( !dirCamel.exists() ) {
			dirCamel.mkdir();
		}
		
		File dirJavaDsl = new File(dirCamel, "JavaDSL");
		if ( !dirJavaDsl.exists() ) {
			dirJavaDsl.mkdir();
		}
		
		/*
		 * create the camel route via Java DSL
		 */
		String uriFrom = dirCamel.toURI().toString();
		logger.info("camel from endpoint:" + uriFrom );
		
		String uriTo = dirJavaDsl.toURI().toString();
		logger.info("camel to endpoint:" + uriTo );
		

		from(uriFrom).routeId("Camel Demo JavaDSL").to(uriTo);
	}

}
