package com.project.alllatf.amanahku.Model.MenuUtama;

import android.content.Intent;

import com.project.alllatf.amanahku.DetailPesanan;
import com.project.alllatf.amanahku.Fragment.MenuUtama.PemberitahuanFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PemberitahuanModel {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PemberitahuanItem> ITEMS = new ArrayList<PemberitahuanItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PemberitahuanItem> ITEM_MAP = new HashMap<String, PemberitahuanItem>();

    private static final int COUNT = 3;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }


    }
    private static void addItem(PemberitahuanItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PemberitahuanItem createDummyItem(int position) {
        return new PemberitahuanItem(String.valueOf(position), "Item " + position, makeDetails(position),"BELUM");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PemberitahuanItem {
        public final String id;
        public final String content;
        public final String details;
        public final String status;

        public PemberitahuanItem(String id, String content, String details, String status) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.status = status;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
