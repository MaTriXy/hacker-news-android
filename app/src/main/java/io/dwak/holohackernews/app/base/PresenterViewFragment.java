package io.dwak.holohackernews.app.base;

import android.os.Bundle;

/**
 * Created by vishnu on 3/13/15.
 */
public abstract class PresenterViewFragment<T extends BasePresenter> extends BaseFragment {
    private T mPresenter;

    protected T getPresenter(){
        if(mPresenter == null){
            try {
                mPresenter = getPresenterClass().newInstance();
                mPresenter.setContext(getActivity());
                mPresenter.setResources(getResources());
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return mPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter();
    }

    protected abstract Class<T> getPresenterClass();
}
