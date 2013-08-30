package com.lindstromhenrik.elasticsearch.service;

import org.elasticsearch.ElasticSearchException;
import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;

/*
 * A custom Elasticsearch Service (Node).
 * 
 * A Node level service in Elasticsearch need to implement {@link LifecycleComponent} and
 * the simplest way to do this is by extending{@link  AbstractLifecycleComponent<?>}.
 * 
 * Whenever the Node state changes (STARTED, STOPPED or CLOSED) a callback is recieved that
 * allows your Service to take action appropriately.
 */
public class CustomService extends AbstractLifecycleComponent<CustomService> {
	@Inject
	public CustomService(Settings settings) {
		super(settings);
	}
	
	/*
	 * Starts the service. Gets called when the Node is started.
	 */
	@Override
	protected void doStart() throws ElasticSearchException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Stop the service. Gets called when the Node is stopped.
	 */
	@Override
	protected void doStop() throws ElasticSearchException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Closes the service. Gets called when the Node is closed.
	 */
	@Override
	protected void doClose() throws ElasticSearchException {
		// TODO Auto-generated method stub
		
	}	
}
