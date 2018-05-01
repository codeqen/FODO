package nu.yakutomi.campuscafe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {
    private ArrayList<OrderHistoryModel> cart = new ArrayList<>();
    private ArrayList<ItemsModel> items;
    private String TAG = "IA";
    private Context context;
    ItemsAdapter(ArrayList<ItemsModel> items, Context context) {
        this.items = items;
        this.context = context;
        //Log.d("IA/L", items.get(0).getItem());
    }

    public ArrayList<OrderHistoryModel> getCart() {
        return cart;
    }

    @NonNull
    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.MyViewHolder holder, int position) {
        final int innerPos = position;
        final TextView itemTitleHold = holder.itemTitle;
        TextView priceHold = holder.price;
        RelativeLayout relLay2 = holder.relLay;
        Log.d("AD", items.get(position).getItem()+items.get(position).getPrice());
        itemTitleHold.setText(items.get(position).getItem());
        priceHold.setText(String.format("₹ %s", items.get(position).getPrice()));
        relLay2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // code to execute when an item is clicked in the Menu
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
                Log.d(TAG, timeStamp);
                OrderHistoryModel currentCartItem = new OrderHistoryModel();
                currentCartItem.setQuantity("1");
                currentCartItem.setItem(items.get(innerPos).getItem());

                    cart.add(currentCartItem);
                    Snackbar.make(v, currentCartItem.getItem()+" added!", 700).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle;
        TextView price;
        RelativeLayout relLay;

        MyViewHolder(View view) {
            super(view);
            this.itemTitle = view.findViewById(R.id.itemText1);
            this.price = view.findViewById(R.id.itemText2);
            this.relLay = view.findViewById(R.id.cardClickRelative);
        }
    }
}
