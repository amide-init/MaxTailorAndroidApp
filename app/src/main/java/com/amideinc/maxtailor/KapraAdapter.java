package com.amideinc.maxtailor;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class KapraAdapter extends RecyclerView.Adapter<KapraAdapter.MyViewHolder> {
    private Context mContext;
    private List<Kapra> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }

    }
    public KapraAdapter(Context mContext, List<Kapra> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.box_card, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Kapra album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNoofpic() + " Images");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext.getApplicationContext(), AlbumActivity.class);
                i.putExtra("Start", album.getKeyword());
                mContext.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }

}
