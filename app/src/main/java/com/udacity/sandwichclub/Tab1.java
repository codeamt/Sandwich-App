package com.udacity.sandwichclub;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class Tab1 extends android.support.v4.app.Fragment {

    /* Instantiate Vars for Tab1 Fragment */
    TextView nameView;
    TextView origin;
    TextView aka;
    TextView descView;
    Intent intent;
    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /* Grab RootView to Find TextViews by ID*/
        View rootView = inflater.inflate(R.layout.tab_1, container, false);

        /* Refactor Detail Activity Code for Fragment to Get Access to Sandwich Model */
        intent = getActivity().getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return getView();
        }
        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);


        /* Use RootView to Grab Text Views */
        nameView = rootView.findViewById(R.id.name_tv);
        origin = rootView.findViewById(R.id.origin_tv);
        aka = rootView.findViewById(R.id.also_known_tv);
        descView = rootView.findViewById(R.id.description_tv);


        /* Avoid NullException Error then Populate UI */
        if(sandwich != null) {
            origin.setText(edgeCase(sandwich.getPlaceOfOrigin()));
            descView.setText(edgeCase(sandwich.getDescription()));
            nameView.setText(edgeCase(sandwich.getMainName()));

            /* handle attributes populated with array items */
            //other names for sandwich
            List<String> other_names = sandwich.getAlsoKnownAs();
            String merge = makeList(other_names);
            aka.setText(edgeCase(merge));
        }


        /* Return RootView to be Inflated in Detail Activity Code */
        return rootView;
    }


    /************************
     *
     * Helper Methods
     *
     ************************/

    /* Refactor closeOnError for Fragment Class */
    private void closeOnError() {
        getActivity().getSupportFragmentManager().popBackStack();
        Toast.makeText(getContext(), R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }


    /* Helper for Populating Text Views that Display Lists */
    private String makeList(List<String> stuff) {
        String merge = "";
        for (String s: stuff) {
            merge += "- " + s + "\n";
        }
        return merge;
    }

    /* Edge Case Helper Method */
    private String edgeCase(String s) {
        s = s.equals("") ? getString(R.string.missing_detail) : s;
        return s;
    }

}
