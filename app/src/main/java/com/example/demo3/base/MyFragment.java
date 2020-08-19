package com.example.demo3.base;

import androidx.fragment.app.Fragment;

import io.reactivex.disposables.Disposable;

public class MyFragment extends Fragment {

    protected Disposable disposable;

    protected void unsubscribe(){
        if(disposable != null && disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }
}
