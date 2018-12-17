package com.cuncisboss.matchschedule.detail;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class DetailResponse {

	@SerializedName("events")
	private List<Detail> events;

	public void setEvents(List<Detail> events){
		this.events = events;
	}

	public List<Detail> getEvents(){
		return events;
	}

}