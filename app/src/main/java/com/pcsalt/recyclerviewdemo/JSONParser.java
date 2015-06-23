package com.pcsalt.recyclerviewdemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krrishnaaaa on Jun 24, 2015
 */
public class JSONParser {

    public List<PostValue> parse(JSONObject jsonObject) {
        List<PostValue> postList = new ArrayList<>();
        PostValue postValue;
        try {
            JSONArray postsArray = jsonObject.getJSONArray("posts");

            for (int i = 0; i < postsArray.length(); i++) {
                JSONObject posts = postsArray.getJSONObject(i);
                JSONObject post = posts.getJSONObject("post");

                postValue = new PostValue();

                String title = post.getString("post_title");
                String guid = post.getString("guid");
                String date = post.getString("post_date");

                postValue.setTitle(title);
                postValue.setGuid(guid);
                postValue.setDate(date);
                postList.add(postValue);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return postList;
    }

}
