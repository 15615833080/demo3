package com.example.demo3.adapter;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo3.R;
import com.example.demo3.bean.MyMessage;
import com.example.demo3.utils.LogUtil;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<MyMessage> myMessageList;
    private MyViewHolder myViewHolder;
    private View view;
    private MyMessage myMessage;

    /**
     * 创建并且返回ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview, parent, false);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    /**
     * 通过ViewHolder绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        myMessage = myMessageList.get(position);
        Glide
                .with(view)
                .load(myMessage.getImageUrl())
                .into(holder.picture);
        holder.description.setText(myMessage.getDesription());
    }

    public void setMessages(List<MyMessage> myMessageList){
        this.myMessageList = myMessageList;
        notifyDataSetChanged();
    }

    /**
     * 返回数据数量
     * @return
     */
    @Override
    public int getItemCount() {
        return myMessageList == null ? 0 :myMessageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView picture;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.picture);
            description = itemView.findViewById(R.id.description);
        }
    }

}
