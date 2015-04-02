package io.dwak.holohackernews.app.ui.storylist;

import java.util.List;

import io.dwak.holohackernews.app.models.Story;

/**
 * Created by vishnu on 4/2/15.
 */
public interface StoryListView {
    void showProgress();
    void hideProgress();
    void displayStories(List<Story> storyList);
}
