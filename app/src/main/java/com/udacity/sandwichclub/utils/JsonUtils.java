package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {

            /*  Start By Making a Base JSON Object out of String param for Serializing */
            JSONObject base = new JSONObject(json);

            /* Covert Base Object Keys Into Autonomous Objects for String Fetching  */
            JSONObject name = base.getJSONObject("name");
            JSONArray altNames = name.getJSONArray("alsoKnownAs");
            JSONArray ingredients = base.getJSONArray("ingredients");

            /* Instantiate Array Literal for Alt Names */
            ArrayList<String> altNamesList = new ArrayList<>();
            /* Push AltName Strings to Alt Names List*/
            for(int i=0; i<altNames.length(); i++) {
                altNamesList.add(altNames.getString(i));
            }

            /* Instantiate Array Literal for Ingredients */
            ArrayList<String> ingredientsList = new ArrayList<>();
            /* Push Ingredient Strings to Ingredients List*/
            for(int i=0; i<ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }


            /* Get (Non-Array) Strings from Base Object */
            String mainName = name.getString("mainName");
            String placeOfOrigin = base.getString("placeOfOrigin");
            String description = base.getString("description");
            String image = base.getString("image");


            /* Return All the Strings */
            return new Sandwich(mainName, altNamesList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {

            /* Print Any Errors */
            e.printStackTrace();
        }
        return null;
    }
}
