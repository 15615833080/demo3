package com.example.demo3.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo3.R;
import com.example.demo3.adapter.RecyclerAdapter;
import com.example.demo3.bean.MyMessage;
import com.example.demo3.network.NetWork;
import com.example.demo3.presenter.MyMessagePresenter;
import com.example.demo3.view.MyMessageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BaseFragment extends Fragment implements MyMessageView {
    private static final String TAG = "PoliceFragment";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MyMessagePresenter myMessagePresenter;
    private View view;
    private ListView listView;
    private List<MyMessage> mMessageList;
    private Context mContext;
    private String mAdress;
    private RecyclerAdapter recyclerAdapter;
    private NetWork instance;


    public BaseFragment(String adress) {
        mAdress = adress;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = NetWork.getInstance();
        instance.getMessageData()
                .search(mAdress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MyMessage>>() {
                    @Override
                    public void accept(List<MyMessage> myMessages) throws Exception {
                        recyclerAdapter.setMessages(myMessages);
                        Log.d(TAG, "myMessages:" + "success" + myMessages);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "myMessages:eror");

                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);


        //findview
        //listView = view.findViewById(R.id.list_view);
        //init
        //myMessagePresenter = new MyMessagePresenterImpl(this);
        //mMessageList = new ArrayList<>();
        //myMessagePresenter.initData(mAdress);

        return view;
    }


    @Override
    public void showMessage(List<MyMessage> myMessageList) {
        mMessageList = myMessageList;

        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);



        /*MessageListAdapter adapter = new MessageListAdapter(mContext,R.layout.item_listview,myMessageList);
        listView.setAdapter(adapter);*/
    }
}
