package com.shortestpath.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortestPath {
	private int hops;

    public ShortestPath() {
        // Jackson deserialization
    }

    public ShortestPath(int hops) {
        this.hops = hops;
    }

    @JsonProperty
    public int getHops() {
        return hops;
    }

}
