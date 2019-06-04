package com.funyoung.widgetgallery.dummy;

import com.funyoung.widgetgallery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {
    private static final char[] charArray = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '='};
    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    static {
        // Add some sample items.
        for (int i = 1; i < charArray.length; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "" + charArray[position], R.drawable.background);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final int iconId;

        public DummyItem(String id, String content, int iconId) {
            this.id = id;
            this.content = content;
            this.iconId = iconId;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
