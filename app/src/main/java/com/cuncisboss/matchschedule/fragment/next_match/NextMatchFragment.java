package com.cuncisboss.matchschedule.fragment.next_match;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.cuncisboss.matchschedule.R;
import com.cuncisboss.matchschedule.api.Config;
import com.cuncisboss.matchschedule.fragment.Event;
import com.cuncisboss.matchschedule.fragment.MatchAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextMatchFragment extends Fragment {
    private static final String TAG = "NextMatchFragment";

    RecyclerView recyclerView;
    ArrayList<Event> events;
    MatchAdapter adapter;

    public NextMatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_next_match, container, false);

        recyclerView = v.findViewById(R.id.rv_next_match);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        events = new ArrayList<>();
        adapter = new MatchAdapter(events, getActivity());

        _createNextMatch();

        return v;
    }

    private void _createNextMatch() {
        AndroidNetworking.post(Config.BASE_URL + "api/v1/json/1/eventsnextleague.php?id=4328")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("events");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject event = jsonArray.getJSONObject(i);
                                String idEvent = event.getString("idEvent");
                                String date = event.getString("dateEvent");
                                String homeTeam = event.getString("strHomeTeam");
                                String awayTeam = event.getString("strAwayTeam");
                                String homeScore = event.getString("intHomeScore");
                                String awayScore = event.getString("intAwayScore");

                                //logo
                                String idHomeTeam = event.getString("idHomeTeam");
                                String idAwayTeam = event.getString("idAwayTeam");

                                Event nextMatch = new Event(idEvent, date, homeTeam, awayTeam, homeScore, awayScore, idHomeTeam, idAwayTeam);

                                events.add(nextMatch);
                                adapter.notifyDataSetChanged();
                                recyclerView.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(getActivity(), "" + anError.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onError: " + anError.getMessage());
                    }
                });
    }

}
