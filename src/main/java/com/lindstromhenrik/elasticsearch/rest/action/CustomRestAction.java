package com.lindstromhenrik.elasticsearch.rest.action;

import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.node.DiscoveryNodeService;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestRequest;

public class CustomRestAction extends BaseRestHandler {

	@Inject
	protected CustomRestAction(Settings settings, Client client) {
		super(settings, client);
		
	}

	@Override
	public void handleRequest(RestRequest request, RestChannel channel) {
		/* Here you should do something with the request */
	}

}
