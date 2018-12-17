package com.cuncisboss.matchschedule.fragment;

import com.cuncisboss.matchschedule.fragment.Event;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventResponse {
    @SerializedName("events")
    private List<Event> eventList;

    public List<Event> getEventList() {
        return eventList;
    }
}
