package com.example.shimmereffect;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MainModel extends BaseObservable {
    protected String title;
    protected String description;
    protected String author;

    public MainModel(){

    }

    public MainModel(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(BR.author);
    }
}
