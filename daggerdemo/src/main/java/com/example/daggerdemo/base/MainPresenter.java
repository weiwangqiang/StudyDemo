package com.example.daggerdemo.base;

import com.example.daggerdemo.DataRepository;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

@ActivityScoped
public class MainPresenter implements MainContract.IPresenter {
    private MainContract.IView view;
    private DataRepository mDataRepository;

    @Inject
    public MainPresenter(DataRepository dataRepository) {
        mDataRepository = dataRepository;
    }

    @Override
    public void takeView(@NotNull MainContract.IView view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public void getData() {
        view.showText(mDataRepository.getData());
    }
}
