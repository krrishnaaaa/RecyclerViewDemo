package com.pcsalt.recyclerviewdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AppCompatActivity activity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        new JSONAsync().execute();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    class JSONAsync extends AsyncTask<Void, Void, Void> {
        ProgressDialog pd;
        List<PostValue> postList;

        @Override
        protected void onPreExecute() {
            pd = ProgressDialog.show(MainActivity.this, null, "Loading posts for PCSalt.com ...", true, false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            JSONObject jsonObject = new JSONHelper().getJSONFromUrl();
            postList = new JSONParser().parse(jsonObject);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            PostAdapter postAdapter = new PostAdapter(activity, postList);
            recyclerView.setAdapter(postAdapter);
            pd.dismiss();
        }
    }
}
