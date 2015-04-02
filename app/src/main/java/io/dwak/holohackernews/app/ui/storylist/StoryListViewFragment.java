package io.dwak.holohackernews.app.ui.storylist;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.InjectView;
import io.dwak.holohackernews.app.R;
import io.dwak.holohackernews.app.base.BaseFragment;
import io.dwak.holohackernews.app.base.PresenterViewFragment;
import io.dwak.holohackernews.app.models.Story;

/**
 * Created by vishnu on 4/2/15.
 */
public class StoryListViewFragment extends PresenterViewFragment<StoryListPresenterImpl> implements StoryListView {
    public static final String FEED_TO_LOAD = "feed_to_load";
    @InjectView(R.id.story_list) RecyclerView mRecyclerView;
    @InjectView(R.id.swipe_container) SwipeRefreshLayout mSwipeRefreshLayout;

    public static StoryListFragment newInstance(@StoryListViewModel.FeedType int feedType) {
        StoryListFragment fragment = new StoryListFragment();
        Bundle args = new Bundle();
        args.putInt(FEED_TO_LOAD, feedType);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            @StoryListViewModel.FeedType final int feedType = getArguments().getInt(FEED_TO_LOAD);
        }
    }

    @Override
    protected Class<StoryListPresenterImpl> getPresenterClass() {
        return StoryListPresenterImpl.class;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_storylist_list, container, false);
        mContainer = rootView.findViewById(R.id.story_list);
        mProgressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        final ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getPresenter().getTitle());
        }
        showProgress();
        return rootView;
    }

    @Override
    public void showProgress() {
       showProgress(true);
    }

    @Override
    public void hideProgress() {
        showProgress(false);
    }

    @Override
    public void displayStories(List<Story> storyList) {

    }
}
