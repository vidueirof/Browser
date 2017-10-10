package acr.browser.lightning.browser;

import android.support.annotation.NonNull;

import acr.browser.lightning.database.HistoryItem;

public interface BookmarksView {

    void navigateBack();

    boolean handleUpdatedUrl(@NonNull String url);

    void handleBookmarkDeleted(@NonNull HistoryItem item);

}
