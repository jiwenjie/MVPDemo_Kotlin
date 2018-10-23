package com.example.root.mvpdemo_kotlin.presenter;

import android.Manifest;
import android.content.Context;
import android.view.View;

import com.example.root.mvpdemo_kotlin.contract.BookContract;
import com.example.root.mvpdemo_kotlin.entity.Book;
import com.example.root.mvpdemo_kotlin.model.DataModel;

import org.jetbrains.annotations.NotNull;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * author:Jiwenjie
 * email:Jiwenjie97@gmail.com
 * time:2018/10/20
 * desc: Book 的 Presenter Java版本
 * version:1.0
 */
public class BooksPresenter implements BookContract.Presenter {

    private Context context;
    private BookContract.BookView bookView;
    private Book mBook;
    private DataModel model;
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public BooksPresenter(Context context) {
        this.context = context;
        model = new DataModel();
    }

    @Override
    public void requestData() {
        getSearchBooks("金瓶梅", null, 0, 1);
    }

    @Override
    public void start() {

    }

    public void getSearchBooks(String name, String tag, int start, int count){
        mCompositeSubscription.add(model.getBookData(context, name, tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        //mBookView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(Book book) {
                        if (bookView != null){
                            bookView.setData(book);
                        }
                    }
                })
        );
    }

    @Override
    public void attachView(@NotNull BookContract.BookView view) {
        bookView = view;
    }
}
