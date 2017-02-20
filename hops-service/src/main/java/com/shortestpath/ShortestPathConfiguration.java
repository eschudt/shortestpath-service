package com.shortestpath;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ShortestPathConfiguration extends Configuration {

	@NotNull
    private int defaultHops;

    @JsonProperty
    public int getDefaultHops() {
        return defaultHops;
    }

    @JsonProperty
    public void setDefaultHops(int defaultHops) {
        this.defaultHops = defaultHops;
    }

}
