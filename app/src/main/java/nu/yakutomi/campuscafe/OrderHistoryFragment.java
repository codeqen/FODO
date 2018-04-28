package nu.yakutomi.campuscafe;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderHistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //private Set<String> items = new HashSet<>();
    // private Set<String> price = new HashSet<>();
    //private View v;
    private ArrayList<TimestampModel> orderhTime;
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference mDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.order_history_fragment, container, false);
       // Log.d("MF", "Inside onCreateView");
        recyclerView = view.findViewById(R.id.order_history_recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        orderhTime = new ArrayList<TimestampModel>();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Log.d("FB/DB/MF", dataSnapshot.child("Items").getChildren().toString());
                //items.clear();
                //price.clear();
                String uid = currentUser.getUid();
                orderhTime.clear();
                for (DataSnapshot snapshot : dataSnapshot.child("Order History").child(uid).getChildren()) {
                    TimestampModel i = new TimestampModel();
                    i.setTimestamp(snapshot.getKey());
                    orderhTime.add(i);
                    //items.add(snapshot.getKey());
                    //price.add(snapshot.getValue().toString());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FB/DB/MF", databaseError.getMessage());
            }
        });

        //Log.d("MF", items.get(0).getItem()+items.get(0).getPrice());
        adapter = new TimestampAdapter(orderhTime, getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
