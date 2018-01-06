package com.amideinc.maxtailor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Dell on 12/26/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    private Context mContext;
    private List<Album> myalbumList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_box, parent, false);

        return new AlbumAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Album album = myalbumList.get(position);
        holder.title.setText(album.getName());
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return myalbumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }

    }
    public AlbumAdapter(Context mContext, List<Album> myalbumList) {
        this.mContext = mContext;
        this.myalbumList = myalbumList;
    }

}
