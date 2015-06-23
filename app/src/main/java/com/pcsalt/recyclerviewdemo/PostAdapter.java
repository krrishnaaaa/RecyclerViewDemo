package com.pcsalt.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Krrishnaaaa on Jun 24, 2015
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostValue> postList;
    private LayoutInflater inflater;

    public PostAdapter(Context context, List<PostValue> postList) {
        this.postList = postList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostValue currentPost = postList.get(position);
        holder.tvTitle.setText(currentPost.getTitle());
        holder.tvPublishDate.setText(currentPost.getDate());
    }

    @Override
    public int getItemCount() {
        return postList == null ? 0 : postList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvPublishDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvPublishDate = (TextView) itemView.findViewById(R.id.tvPublishDate);
        }
    }
}
