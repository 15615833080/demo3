package com.example.demo3.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo3.R;
import com.example.demo3.adapter.RecyclerAdapter;
import com.example.demo3.base.MyFragment;
import com.example.demo3.bean.MyMessage;
import com.example.demo3.presenter.MyMessagePresenter;
import com.example.demo3.presenter.MyMessagePresenterImpl;
import com.example.demo3.utils.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.demo3.utils.Constant.P_NAME;

public class PoliceFragment extends MyFragment implements MyMessageView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter = new RecyclerAdapter();;
    private MyMessagePresenter myMessagePresenter;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, mView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        myMessagePresenter = new MyMessagePresenterImpl(this);
        recyclerAdapter.setMessages(null);
        Log.d("PoliceFragment", "111");
        LogUtil.d("MyMessagePresenterImpl", "thread" + Thread.currentThread().getName());

        myMessagePresenter.getData(P_NAME, recyclerAdapter, disposable);
        return mView;
    }


    @Override
    public void showMessage(List<MyMessage> myMessageList) {

    }
}
