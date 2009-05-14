package com.nitobi;

public class Place {
	public GeoTuple geo;
	public String name;
	
	public Place(String newName) {
		this.geo = new GeoTuple();
		this.name = newName;
	}
}
