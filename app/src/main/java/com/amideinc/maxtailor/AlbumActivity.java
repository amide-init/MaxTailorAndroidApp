package com.amideinc.maxtailor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private AlbumAdapter adapter;
    private List<Album> albumList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Intent intent = getIntent();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new AlbumAdapter(this, albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums(intent.getStringExtra("Start"));
    }



    private void prepareAlbums(String data) {
        if(data.equals("kurtasLink")) {
            String[] shirt = getResources().getStringArray(R.array.kurtas_link);

            Album a = new Album("K1", shirt[0]);
            albumList.add(a);

            for (int i = 1; i < shirt.length; i++) {
                a = new Album("K" + (i + 1), shirt[i]);
                albumList.add(a);
            }

            adapter.notifyDataSetChanged();


        } else if(data.equals("formal_shirt_cat")) {
            String[] shirt = getResources().getStringArray(R.array.formal_shirt_cat);

            Album a = new Album("S1", shirt[0]);
            albumList.add(a);

            for (int i = 1; i < shirt.length; i++) {
                a = new Album("S" + (i + 1), shirt[i]);
                albumList.add(a);
            }

            adapter.notifyDataSetChanged();
        } else  if(data.equals("stylist_shirt")) {
            String[] shirt = getResources().getStringArray(R.array.stylist_shirt);

            Album a = new Album("S1", shirt[0]);
            albumList.add(a);

            for (int i = 1; i < shirt.length; i++) {
                a = new Album("S" + (i + 1), shirt[i]);
                albumList.add(a);
            }

            adapter.notifyDataSetChanged();
        }

    }

    }
