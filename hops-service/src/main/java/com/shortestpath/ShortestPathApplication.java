package com.shortestpath;

import com.shortestpath.health.TemplateHealthCheck;
import com.shortestpath.resources.ShortestPathResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ShortestPathApplication extends Application<ShortestPathConfiguration>{

	public static void main(String[] args) throws Exception {
        new ShortestPathApplication().run(args);
    }

    @Override
    public String getName() {
        return "shortestpath";
    }

    @Override
    public void initialize(Bootstrap<ShortestPathConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ShortestPathConfiguration configuration,
                    Environment environment) {
        final ShortestPathResource resource = new ShortestPathResource(
            configuration.getDefaultHops()
        );
        final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getDefaultHops());
        environment.healthChecks().register("defaultHops", healthCheck);
        environment.jersey().register(resource);
    }
}
