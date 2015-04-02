package io.dwak.holohackernews.app.ui.storylist;

import io.dwak.holohackernews.app.models.StoryDetail;

/**
 * Created by vishnu on 4/2/15.
 */
public interface StoryListPresenter {
    void getStoryList(@StoryDetail.StoryType int storyType);
    String getTitle();
}
