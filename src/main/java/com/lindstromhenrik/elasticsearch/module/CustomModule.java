package com.lindstromhenrik.elasticsearch.module;

import org.elasticsearch.common.inject.AbstractModule;

import com.lindstromhenrik.elasticsearch.service.CustomService;

/*
 * A custom Elasticsearch Module (Node).
 * 
 * A module in Elasticsearch need to implement {@link Module} and the
 * simplest way to do this is by extending{@link AbstractModule}.
 * 
 * A module is responsible for configuring your plugin, i.e.  make the 
 * necessary bindings to the injector.
 */
public class CustomModule extends AbstractModule {

	@Override
	protected void configure() {
		/* here you can bind */
		bind(CustomService.class).asEagerSingleton();
	}
}
