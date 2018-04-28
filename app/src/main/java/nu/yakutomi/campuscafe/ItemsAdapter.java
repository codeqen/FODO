package nu.yakutomi.campuscafe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {
    private ArrayList<ItemsModel> items;
    Context context = null;
    public ItemsAdapter(ArrayList<ItemsModel> items, Context context) {
        this.items = items;
        this.context = context;
        //Log.d("IA/L", items.get(0).getItem());
    }


    @NonNull
    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_card_view, parent, false);
        MyViewHolder ho = new MyViewHolder(view);
        return ho;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.MyViewHolder holder, int position) {
        TextView itemTitleHold = holder.itemTitle;
        final int test = position;
        TextView priceHold = holder.price;
        RelativeLayout relLay2 = holder.relLay;
        Log.d("AD", items.get(position).getItem()+items.get(position).getPrice());
        itemTitleHold.setText(items.get(position).getItem());
        priceHold.setText("₹ "+items.get(position).getPrice());
        relLay2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("cardRel", "You clicked"+test);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle;
        TextView price;
        RelativeLayout relLay;

        public MyViewHolder(View view) {
            super(view);
            this.itemTitle = view.findViewById(R.id.itemText1);
            this.price = view.findViewById(R.id.itemText2);
            this.relLay = view.findViewById(R.id.cardClickRelative);
        }
    }
}
