package com.cuncisboss.matchschedule.fragment;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("idEvent")
    private String idEvent;

    @SerializedName("dateEvent")
    private String dateEvent;

    @SerializedName("strHomeTeam")
    private String homeTeam;

    @SerializedName("strAwayTeam")
    private String awayTeam;

    @SerializedName("intHomeScore")
    private String homeScore;

    @SerializedName("intAwayScore")
    private String awayScore;

    @SerializedName("intHomeShots")
    private Object intHomeShots;

    @SerializedName("strSport")
    private String strSport;

    @SerializedName("strHomeLineupDefense")
    private Object strHomeLineupDefense;

    @SerializedName("strAwayLineupSubstitutes")
    private Object strAwayLineupSubstitutes;

    @SerializedName("idLeague")
    private String idLeague;

    @SerializedName("idSoccerXML")
    private String idSoccerXML;

    @SerializedName("strHomeLineupForward")
    private Object strHomeLineupForward;

    @SerializedName("strTVStation")
    private Object strTVStation;

    @SerializedName("strHomeGoalDetails")
    private Object strHomeGoalDetails;

    @SerializedName("strAwayLineupGoalkeeper")
    private Object strAwayLineupGoalkeeper;

    @SerializedName("strAwayLineupMidfield")
    private Object strAwayLineupMidfield;

    @SerializedName("intRound")
    private String intRound;

    @SerializedName("strHomeYellowCards")
    private Object strHomeYellowCards;

    @SerializedName("idHomeTeam")
    private String idHomeTeam;

    @SerializedName("intHomeScore")
    private Object intHomeScore;

    @SerializedName("strCountry")
    private Object strCountry;

    @SerializedName("strAwayTeam")
    private String strAwayTeam;

    @SerializedName("strHomeLineupMidfield")
    private Object strHomeLineupMidfield;

    @SerializedName("strDate")
    private String strDate;

    @SerializedName("strHomeFormation")
    private Object strHomeFormation;

    @SerializedName("strMap")
    private Object strMap;

    @SerializedName("idAwayTeam")
    private String idAwayTeam;

    @SerializedName("strAwayRedCards")
    private Object strAwayRedCards;

    @SerializedName("strBanner")
    private Object strBanner;

    @SerializedName("strFanart")
    private Object strFanart;

    @SerializedName("strDescriptionEN")
    private Object strDescriptionEN;

    @SerializedName("strResult")
    private Object strResult;

    @SerializedName("strCircuit")
    private Object strCircuit;

    @SerializedName("intAwayShots")
    private Object intAwayShots;

    @SerializedName("strFilename")
    private String strFilename;

    @SerializedName("strTime")
    private String strTime;

    @SerializedName("strAwayGoalDetails")
    private Object strAwayGoalDetails;

    @SerializedName("strAwayLineupForward")
    private Object strAwayLineupForward;

    @SerializedName("strLocked")
    private String strLocked;

    @SerializedName("strSeason")
    private String strSeason;

    @SerializedName("intSpectators")
    private Object intSpectators;

    @SerializedName("strHomeRedCards")
    private Object strHomeRedCards;

    @SerializedName("strHomeLineupGoalkeeper")
    private Object strHomeLineupGoalkeeper;

    @SerializedName("strHomeLineupSubstitutes")
    private Object strHomeLineupSubstitutes;

    @SerializedName("strAwayFormation")
    private Object strAwayFormation;

    @SerializedName("strEvent")
    private String strEvent;

    @SerializedName("strAwayYellowCards")
    private Object strAwayYellowCards;

    @SerializedName("strAwayLineupDefense")
    private Object strAwayLineupDefense;

    @SerializedName("strHomeTeam")
    private String strHomeTeam;

    @SerializedName("strThumb")
    private Object strThumb;

    @SerializedName("strLeague")
    private String strLeague;

    @SerializedName("intAwayScore")
    private Object intAwayScore;

    @SerializedName("strCity")
    private Object strCity;

    @SerializedName("strPoster")
    private Object strPoster;

    public Event() {
    }

    public Event(String dateEvent, String homeTeam, String awayTeam, String homeScore, String awayScore) {
        this.dateEvent = dateEvent;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Event(String idEvent, String dateEvent, String homeTeam, String awayTeam, String homeScore, String awayScore) {
        this.idEvent = idEvent;
        this.dateEvent = dateEvent;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Event(String idEvent, String dateEvent, String homeTeam, String awayTeam, String homeScore, String awayScore, String idHomeTeam, String idAwayTeam) {
        this.idEvent = idEvent;
        this.dateEvent = dateEvent;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public Object getIntHomeShots() {
        return intHomeShots;
    }

    public String getStrSport() {
        return strSport;
    }

    public Object getStrHomeLineupDefense() {
        return strHomeLineupDefense;
    }

    public Object getStrAwayLineupSubstitutes() {
        return strAwayLineupSubstitutes;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public Object getStrHomeLineupForward() {
        return strHomeLineupForward;
    }

    public Object getStrTVStation() {
        return strTVStation;
    }

    public Object getStrHomeGoalDetails() {
        return strHomeGoalDetails;
    }

    public Object getStrAwayLineupGoalkeeper() {
        return strAwayLineupGoalkeeper;
    }

    public Object getStrAwayLineupMidfield() {
        return strAwayLineupMidfield;
    }

    public String getIntRound() {
        return intRound;
    }

    public Object getStrHomeYellowCards() {
        return strHomeYellowCards;
    }

    public String getIdHomeTeam() {
        return idHomeTeam;
    }

    public Object getIntHomeScore() {
        return intHomeScore;
    }

    public Object getStrCountry() {
        return strCountry;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public Object getStrHomeLineupMidfield() {
        return strHomeLineupMidfield;
    }

    public String getStrDate() {
        return strDate;
    }

    public Object getStrHomeFormation() {
        return strHomeFormation;
    }

    public Object getStrMap() {
        return strMap;
    }

    public String getIdAwayTeam() {
        return idAwayTeam;
    }

    public Object getStrAwayRedCards() {
        return strAwayRedCards;
    }

    public Object getStrBanner() {
        return strBanner;
    }

    public Object getStrFanart() {
        return strFanart;
    }

    public Object getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public Object getStrResult() {
        return strResult;
    }

    public Object getStrCircuit() {
        return strCircuit;
    }

    public Object getIntAwayShots() {
        return intAwayShots;
    }

    public String getStrFilename() {
        return strFilename;
    }

    public String getStrTime() {
        return strTime;
    }

    public Object getStrAwayGoalDetails() {
        return strAwayGoalDetails;
    }

    public Object getStrAwayLineupForward() {
        return strAwayLineupForward;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public String getStrSeason() {
        return strSeason;
    }

    public Object getIntSpectators() {
        return intSpectators;
    }

    public Object getStrHomeRedCards() {
        return strHomeRedCards;
    }

    public Object getStrHomeLineupGoalkeeper() {
        return strHomeLineupGoalkeeper;
    }

    public Object getStrHomeLineupSubstitutes() {
        return strHomeLineupSubstitutes;
    }

    public Object getStrAwayFormation() {
        return strAwayFormation;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public Object getStrAwayYellowCards() {
        return strAwayYellowCards;
    }

    public Object getStrAwayLineupDefense() {
        return strAwayLineupDefense;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public Object getStrThumb() {
        return strThumb;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public Object getIntAwayScore() {
        return intAwayScore;
    }

    public Object getStrCity() {
        return strCity;
    }

    public Object getStrPoster() {
        return strPoster;
    }
}
