package com.example.demo3.view;


import com.example.demo3.bean.MyMessage;

import java.util.List;

public interface MyMessageView {
    //展示图片和名称
    public void showMessage(List<MyMessage> myMessageList);
}
