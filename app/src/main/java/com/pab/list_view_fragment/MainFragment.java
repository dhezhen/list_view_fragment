package com.pab.list_view_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Kelas untuk Fragment pertama (menampilkan daftar)
public class MainFragment extends Fragment {



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        // Membuat contoh data
        ArrayList<MyItem> itemList = new ArrayList<>();
        itemList.add(new MyItem("Kuningan", "Kuningan adalah salah satu kota dijawa barat"));
        itemList.add(new MyItem("Majalengka", "Majelengka adalah salah satu kota dijawa barat"));
        itemList.add(new MyItem("Cirebon", "Cirebon adalah salah satu kota dijawa barat"));

        // Menginisialisasi adapter RecyclerView
        MyAdapter adapter = new MyAdapter(itemList, (MyAdapter.OnItemClickListener) getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
