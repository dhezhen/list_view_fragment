package com.pab.list_view_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

// Kelas untuk Fragment detail
public class DetailFragment extends Fragment {

    private TextView titleTextView;
    private TextView descriptionTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        titleTextView = view.findViewById(R.id.title_text_view);
        descriptionTextView = view.findViewById(R.id.description_text_view);

        // Mendapatkan data yang dikirim dari MainActivity
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title", "");
            String description = bundle.getString("description", "");

            // Menampilkan data pada TextView
            titleTextView.setText(title);
            descriptionTextView.setText(description);
        }

        return view;
    }
}
