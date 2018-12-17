package com.cuncisboss.matchschedule.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.cuncisboss.matchschedule.R;
import com.cuncisboss.matchschedule.Utils;
import com.cuncisboss.matchschedule.api.Config;
import com.cuncisboss.matchschedule.fragment.Event;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";

    private TextView tv_date, tv_homeTeam, tv_awayTeam, tv_homeScore, tv_awayScore, tv_homeGoalDetail, tv_awayGoalDetail,
            tv_homeShots, tv_awayShots, tv_homeLineupKeeper, tv_awayLineupKeeper, tv_homeLineupDefense, tv_awayLineupDefense,
            tv_homeLineupMidfield, tv_awayLineupMidfield, tv_homeLineupForward, tv_awayLineupForward, tv_homeLineupSubstitutes,
            tv_awayLineupSubstitutes;

    private ImageView imgHomeLogo, imgAwayLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        String eventId = getIntent().getStringExtra("EVENT_ID");
        String homeTeamId = getIntent().getStringExtra("HOME_TEAM_ID");
        String awayTeamId = getIntent().getStringExtra("AWAY_TEAM_ID");

        _createDetail(eventId);
        _createLogoHome(homeTeamId);
        _createLogoAway(awayTeamId);
    }

    private void initView() {
        tv_date = findViewById(R.id.tv_date);
        tv_homeTeam = findViewById(R.id.tv_homeTeam);
        tv_awayTeam = findViewById(R.id.tv_awayTeam);
        tv_homeScore = findViewById(R.id.tv_homeScore);
        tv_awayScore = findViewById(R.id.tv_awayScore);
        tv_homeGoalDetail = findViewById(R.id.tv_homeGoalDetail);
        tv_awayGoalDetail = findViewById(R.id.tv_awayGoalDetail);
        tv_homeShots = findViewById(R.id.tv_homeShots);
        tv_awayShots = findViewById(R.id.tv_awayShots);
        tv_homeLineupKeeper = findViewById(R.id.tv_homeLineupKeeper);
        tv_awayLineupKeeper = findViewById(R.id.tv_awayLineupKeeper);
        tv_homeLineupDefense = findViewById(R.id.tv_homeLineupDefense);
        tv_awayLineupDefense = findViewById(R.id.tv_awayLineupDefense);
        tv_homeLineupMidfield = findViewById(R.id.tv_homeLineupMidfield);
        tv_awayLineupMidfield = findViewById(R.id.tv_awayLineupMidfield);
        tv_homeLineupForward = findViewById(R.id.tv_homeLineupForward);
        tv_awayLineupForward = findViewById(R.id.tv_awayLineupForward);
        tv_homeLineupSubstitutes = findViewById(R.id.tv_homeLineupSubstitutes);
        tv_awayLineupSubstitutes = findViewById(R.id.tv_awayLineupSubstitutes);

        //team logo
        imgHomeLogo = findViewById(R.id.img_homeTeam);
        imgAwayLogo = findViewById(R.id.img_awayTeam);
    }

    private void _createLogoHome(final String teamId) {
        Log.d(TAG, "_createLogo: " + Config.BASE_URL + "/api/v1/json/1/lookupteam.php?id="+ teamId);
        AndroidNetworking.post(Config.BASE_URL + "/api/v1/json/1/lookupteam.php?id=" + teamId)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("teams");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject logoTeam = jsonArray.getJSONObject(i);

                                Picasso.get().load(logoTeam.getString("strTeamBadge")).placeholder(R.drawable.img_placeholder).into(imgHomeLogo);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(DetailActivity.this, "" + anError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void _createLogoAway(final String teamId) {
        Log.d(TAG, "_createLogo: " + Config.BASE_URL + "/api/v1/json/1/lookupteam.php?id="+ teamId);
        AndroidNetworking.post(Config.BASE_URL + "/api/v1/json/1/lookupteam.php?id=" + teamId)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("teams");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject logoTeam = jsonArray.getJSONObject(i);

                                Picasso.get().load(logoTeam.getString("strTeamBadge")).placeholder(R.drawable.img_placeholder).into(imgAwayLogo);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(DetailActivity.this, "" + anError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void _createDetail(String eventId) {
        Log.d(TAG, "_createDetail: " + Config.BASE_URL + "api/v1/json/1/lookupevent.php?id=" + eventId);
        AndroidNetworking.post(Config.BASE_URL + "api/v1/json/1/lookupevent.php?id=" + eventId)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("events");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject detail = jsonArray.getJSONObject(i);

                                showDetail(detail);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(DetailActivity.this, "" + anError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showDetail(JSONObject detail) {
        try {
            tv_date.setText(Utils.getDateEvent(detail.getString("dateEvent")));
            tv_homeTeam.setText(detail.getString("strHomeTeam"));
            tv_awayTeam.setText(detail.getString("strAwayTeam"));

            if (detail.getString("intHomeScore").equals("null") && detail.getString("intAwayScore").equals("null")) {
                tv_homeScore.setText("");
                tv_awayScore.setText("");
            } else {
                tv_homeScore.setText(detail.getString("intHomeScore"));
                tv_awayScore.setText(detail.getString("intAwayScore"));
            }

            tv_homeGoalDetail.setText(detail.getString("strHomeGoalDetails"));
            tv_awayGoalDetail.setText(detail.getString("strAwayGoalDetails"));
            tv_homeShots.setText(detail.getString("intHomeShots"));
            tv_awayShots.setText(detail.getString("intAwayShots"));
            tv_homeLineupKeeper.setText(detail.getString("strHomeLineupGoalkeeper"));
            tv_awayLineupKeeper.setText(detail.getString("strAwayLineupGoalkeeper"));
            tv_homeLineupDefense.setText(detail.getString("strHomeLineupDefense"));
            tv_awayLineupDefense.setText(detail.getString("strAwayLineupDefense"));
            tv_homeLineupMidfield.setText(detail.getString("strHomeLineupMidfield"));
            tv_awayLineupMidfield.setText(detail.getString("strAwayLineupMidfield"));
            tv_homeLineupForward.setText(detail.getString("strHomeLineupForward"));
            tv_awayLineupForward.setText(detail.getString("strAwayLineupForward"));
            tv_homeLineupSubstitutes.setText(detail.getString("strHomeLineupSubstitutes"));
            tv_awayLineupSubstitutes.setText(detail.getString("strAwayLineupSubstitutes"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
