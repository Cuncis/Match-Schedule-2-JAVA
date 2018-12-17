package com.cuncisboss.matchschedule.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeamBadge")
    private String teamLogo;

    public String getTeamLogo() {
        return teamLogo;
    }
}
