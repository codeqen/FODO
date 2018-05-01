package nu.yakutomi.campuscafe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenuFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemsAdapter ItemObj;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //private Set<String> items = new HashSet<>();
   // private Set<String> price = new HashSet<>();
    //private View v;
    private ArrayList<ItemsModel> items;
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference mDatabase;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        Log.d("MF", "Inside onCreateView");
        recyclerView = view.findViewById(R.id.menu_items_recycler);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        items = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference("Items");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Log.d("FB/DB/MF", dataSnapshot.child("Items").getChildren().toString());
                //items.clear();
                //price.clear();
                items.clear();
                // donot use new ProgressDialog it will create a hidden to-be dismissed dialog
                //ProgressDialog load;
                //load = show(getActivity(),"Loading", "Loading data...");
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(snapshot.getValue() != null) {
                        ItemsModel i = new ItemsModel();
                        i.setItem(snapshot.getKey());
                        i.setPrice(snapshot.getValue().toString());
                        items.add(i);
                        //items.add(snapshot.getKey());
                        //price.add(snapshot.getValue().toString());
                        Log.d("FB/Key/Item", items.get(0).getItem());
                        Log.d("FB/Value/Price", items.get(0).getPrice());
                        adapter.notifyDataSetChanged();
                    }
                }
                //load.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FB/DB/MF", databaseError.getMessage());
            }
        });

        //Log.d("MF", items.get(0).getItem()+items.get(0).getPrice());
        ItemObj = new ItemsAdapter(items, getActivity());
        adapter = ItemObj;
        recyclerView.setAdapter(adapter);
        ArrayList<OrderHistoryModel> cart = ItemObj.getCart();
        return view;
    }

}
