package io.dwak.holohackernews.app.ui.storylist;

import java.util.List;

import io.dwak.holohackernews.app.models.Story;
import io.dwak.holohackernews.app.models.StoryDetail;
import rx.Observable;

/**
 * Created by vishnu on 4/2/15.
 */
public interface StoryListInteractor {
    Observable<List<Story>> getStories(@StoryDetail.StoryType int storyType);
}
