package com.example.demo3.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo3.R;
import com.example.demo3.adapter.MessageListAdapter;
import com.example.demo3.bean.MyMessage;
import com.example.demo3.presenter.MyMessagePresenter;
import com.example.demo3.presenter.MyMessagePresenterImpl;
import com.example.demo3.view.MyMessageView;

import java.util.ArrayList;
import java.util.List;

public class BaseFragment extends Fragment implements MyMessageView{
    private static final String TAG = "PoliceFragment";
    private MyMessagePresenter myMessagePresenter;
    private View view;
    private ListView listView;
    private List<MyMessage> mMessageList;
    private Context mContext;
    private String mAdress;


    public BaseFragment(Context context, String adress){
        mContext = context;
        mAdress = adress;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_police, container, false);
        //findview
        listView = view.findViewById(R.id.list_view);
        //init
        myMessagePresenter = new MyMessagePresenterImpl(this);
        mMessageList = new ArrayList<>();
        myMessagePresenter.initData(mAdress);

        return view;
    }


    @Override
    public void showMessage(List<MyMessage> myMessageList) {
        mMessageList = myMessageList;
        MessageListAdapter adapter = new MessageListAdapter(mContext,R.layout.item_listview,myMessageList);
        listView.setAdapter(adapter);
    }
}
