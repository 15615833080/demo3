package com.example.demo3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo3.R;
import com.example.demo3.bean.MyMessage;

import java.util.List;

public class MessageListAdapter extends ArrayAdapter<MyMessage> {

    private int respurceID;
    private View view;

    public MessageListAdapter(Context context, int textViewID, List<MyMessage> objects){
        super(context, textViewID, objects);
        respurceID = textViewID;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        MyMessage myMessage = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(respurceID,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.picture = view.findViewById(R.id.picture);
            viewHolder.description = view.findViewById(R.id.description);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide
                .with(view)
                .load(myMessage.getImageUrl())
                .into(viewHolder.picture);
        viewHolder.description.setText(myMessage.getDesription());
        return view;
    }

    class ViewHolder{
        ImageView picture;
        TextView description;
    }
}