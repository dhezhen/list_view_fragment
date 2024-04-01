package com.pab.list_view_fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
// Kelas MainActivity
public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Membuat contoh data
        ArrayList<MyItem> itemList = new ArrayList<>();
        itemList.add(new MyItem("Item 1", "Deskripsi item 1"));
        itemList.add(new MyItem("Item 2", "Deskripsi item 2"));
        itemList.add(new MyItem("Item 3", "Deskripsi item 3"));

        // Menambahkan Fragment pertama ke MainActivity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new MainFragment())
                    .commit();
        }
    }

    @Override
    public void onItemClick(MyItem item) {
        // Menambahkan DetailFragment ketika item diklik
        Bundle bundle = new Bundle();
        bundle.putString("title", item.getTitle());
        bundle.putString("description", item.getDescription());

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}

