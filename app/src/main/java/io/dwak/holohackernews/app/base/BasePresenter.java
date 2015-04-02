package io.dwak.holohackernews.app.base;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by vishnu on 4/2/15.
 */
public class BasePresenter {
    private Context mContext;
    private Resources mResources;

    void setContext(Context context){
        mContext = context;
    }

    void setResources(Resources resources){
        mResources = resources;
    }
}
