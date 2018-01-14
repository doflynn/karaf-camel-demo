/**
 * 
 * Copyright (c) 2017 - Loden Technologies, LLC
 */
package com.lodentech.camel.demo.java.dsl;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dennis
 *
 */
public class Activator implements BundleActivator {
	private final Logger logger = LoggerFactory.getLogger(Activator.class);
	private CamelContext ctxCamel;

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		logger.info( "starting camel-demo-java-dsl");
		ctxCamel = new DefaultCamelContext();
		
		try {
			
			RouteJavaDsl route = new RouteJavaDsl();
			ctxCamel.addRoutes(route);
			
			ctxCamel.start();
			
		} catch (Exception e) {
			logger.error("unable to start camel", e);
		}
	}

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		logger.info( "stopping camel-demo-java-dsl");

		if (ctxCamel != null) {
			try {
				ctxCamel.stop();				
			} catch (Exception e) {
				logger.error("unable to stop camel", e);
			}

		}
	}

}
