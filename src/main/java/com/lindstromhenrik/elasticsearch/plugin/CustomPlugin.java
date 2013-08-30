package com.lindstromhenrik.elasticsearch.plugin;

import java.util.Collection;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.CloseableIndexComponent;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.rest.RestModule;

import com.lindstromhenrik.elasticsearch.module.CustomModule;
import com.lindstromhenrik.elasticsearch.rest.action.CustomRestAction;
import com.lindstromhenrik.elasticsearch.service.CustomService;

/*
 * A custom Elasticsearch Plugin.
 * 
 * A plugin in Elasticsearch need to implement {@link Plugin} and the
 * simplest way to do this is by extending{@link AbstractPlugin}.
 * 
 * A plugin is responsible for setting up your plugin, i.e. telling the 
 * {@link PluginService} what modules and services to load. The 
 * {@link PluginService} also provides a callback for already loaded modules,
 * allowing for customization of existing Elasticsearch modules.
 */
public class CustomPlugin extends AbstractPlugin {
	private final Settings settings;

	/* A plugin class must have either an empty default constructor or a single argument constructor accepting a Settings instance */
	public CustomPlugin(Settings settings)
	{
		 this.settings = settings;
	}
	
	/* Plugin description */
	@Override
	public String description() {
		return "A custom Elasticsearch plugin describing some of the concepts of writing plugins for Elasticsearch";
	}
	
	/* Plugin name */
	@Override
	public String name() {
		return "es-custom-plugin";
	}
	
	/* 
	 * To hook into an existing ElasticSearch module implement an onModule method accepting a
	 * single argument of the type of module you want to hook into.
	*/
	public void onModule(RestModule restModule) {
		restModule.addRestAction(/* Pass a class argument extending BaseRestHandler */ CustomRestAction.class);
    }
	
	/* 
	 * Specify any services within your plugin. Whenever the state of the Node is changed all 
	 * registered plugin services will be notified.
	*/
	@Override 
	public Collection<Class<? extends LifecycleComponent>> services() {
        Collection<Class<? extends LifecycleComponent>> services = Lists.newArrayList();

        /* Remember that a node can be created as a client! */
        if (!isClient()) {
            services.add(CustomService.class);
        }
        return services;
    }
	
	/* 
	 * Specify any node level modules within your plugin. When the plugin is started all modules
	 * will be called and configured.
	*/
	@Override 
	public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = Lists.newArrayList();
        
        /* Remember that a node can be created as a client! */
        if (!isClient()) {
            modules.add(CustomModule.class);
        }
        return modules;
    }
	
	/* Checking if a node is a client or not */
    private boolean isClient() {
        return settings.getAsBoolean("node.client", false);
    }
}
