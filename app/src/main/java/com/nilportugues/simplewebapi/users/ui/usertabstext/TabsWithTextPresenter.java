package com.nilportugues.simplewebapi.users.ui.usertabstext;


import com.nilportugues.simplewebapi.shared.executors.IOThread;
import com.nilportugues.simplewebapi.shared.executors.UIThread;
import com.nilportugues.simplewebapi.users.interactors.UserPokemonList;

import java.util.List;

import rx.Subscriber;

public class TabsWithTextPresenter implements TabsWithTextContract.Presenter
{

    private TabsWithTextContract.View mView;
    private UserPokemonList mInteractor;

    public TabsWithTextPresenter(UserPokemonList interactor, TabsWithTextContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mInteractor = interactor;
    }

    @Override
    public void showLoading(boolean active) {
        if (active) {
            mView.showLoading();
            return;
        }
        mView.hideLoading();
    }

    @Override
    public void setList(List<String> userPokemon) {
        mView.setList(userPokemon);
    }

    @Override
    public void showTabs(boolean active) {
        showLoading(false);
        if (active) {
            mView.showTabs();
            return;
        }
        mView.showErroredTabs();
    }

    @Override
    public void subscribe() {
        showLoading(true);
        mInteractor.execute(new UIThread(), new IOThread(), new Subscriber<List<String>>() {

            @Override
            public void onCompleted() {
                showTabs(true);
            }

            @Override
            public void onError(Throwable e) {
                showTabs(false);
            }

            @Override
            public void onNext(List<String> strings) {
                setList(strings);
            }
        });

    }

    @Override
    public void unsubscribe() {
        mInteractor.unsubscribe();
    }
}
