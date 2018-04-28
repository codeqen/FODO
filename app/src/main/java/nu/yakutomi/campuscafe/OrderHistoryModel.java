package nu.yakutomi.campuscafe;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class OrderHistoryModel {
    private String mItem;
    private String mPrice;
    private String mUid;

    public OrderHistoryModel() {}  // Needed for Firebase

    public OrderHistoryModel(String item, String price, String uid) {
        mItem = item;
        mPrice = price;
        mUid = uid;
    }



    public String getItem() { return mItem; }
    public void setItem(String item) { this.mItem = item; }
    public String getPrice() { return mPrice; }
    public void setPrice(String price) { this.mPrice = price; }
    public String getUid() { return mUid; }

}