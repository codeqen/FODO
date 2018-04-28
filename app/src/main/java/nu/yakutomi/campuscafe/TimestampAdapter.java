package nu.yakutomi.campuscafe;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

class TimestampAdapter extends RecyclerView.Adapter<TimestampAdapter.MyViewHolder> {
    private ArrayList<TimestampModel> orderhTime;
    Context context = null;
    public TimestampAdapter(ArrayList<TimestampModel> orderhTime, Context context) {
        this.orderhTime = orderhTime;
        this.context = context;
        //Log.d("IA/L", items.get(0).getItem());
    }


    @NonNull
    @Override
    public TimestampAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderh_time_view, parent, false);
        MyViewHolder ho = new MyViewHolder(view);
        return ho;
    }

    @Override
    public void onBindViewHolder(@NonNull TimestampAdapter.MyViewHolder holder, int position) {
        final Button itemTitleHold = holder.timeStamp;
        final int test = position;
        RelativeLayout relLay2 = holder.relLay;
        itemTitleHold.setText(orderhTime.get(position).getTimestamp());
        itemTitleHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(v.getContext()).setTitle("Order Info");
                final AlertDialog alertDialog = alertBuilder.create();
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "DONE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                // Firebase code
                final ArrayList<OrderHistoryModel> historyItems;
                final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                DatabaseReference mDatabase;
                historyItems = new ArrayList<OrderHistoryModel>();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Log.d("FB/DB/MF", dataSnapshot.child("Items").getChildren().toString());
                        //items.clear();
                        //price.clear();
                        historyItems.clear();
                        // donot use new ProgressDialog it will create a hidden to-be dismissed dialog
                        //ProgressDialog load;
                        //load = show(getActivity(),"Loading", "Loading data...");
                        String uid = currentUser.getUid();
                        String timestamps = (String) itemTitleHold.getText();
                        String items = "";
                        for (DataSnapshot snapshot : dataSnapshot.child("Order History").child(uid).child(timestamps).child("Items").getChildren()) {
                            OrderHistoryModel i = new OrderHistoryModel();
                            i.setItem(snapshot.getKey());
                            i.setPrice(snapshot.getValue().toString());
                            //historyItems.add(i);
                            //items.add(snapshot.getKey());
                            //price.add(snapshot.getValue().toString());
                            items = items + "\n" + i.getPrice() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + i.getItem();
                        }
                        Log.d("TSA", items);
                        alertDialog.setMessage(items);
                        alertDialog.show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderhTime.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        Button timeStamp;
        RelativeLayout relLay;

        public MyViewHolder(View view) {
            super(view);
            this.timeStamp = view.findViewById(R.id.buttonTimestamp1);
            this.relLay = view.findViewById(R.id.cardClickRelative);
        }
    }
}
