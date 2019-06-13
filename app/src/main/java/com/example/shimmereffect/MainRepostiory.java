package com.example.shimmereffect;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

public class MainRepostiory {

    Context context;
    APIHandler listener;

    public MainRepostiory(Context context, APIHandler listener){
        this.context  = context;
        this.listener = listener;
    }

    public void getData(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.success(data());
            }
        }, 3000);
    }

    private List<MainModel> data(){
        List<MainModel> listMain = new ArrayList<>();
        for(int i=0; i<15; i++){
            listMain.add(new MainModel("This is title " + i,
                    "This is description " + i,
                    "This is author " + i));
        }
        return listMain;
    }
}
