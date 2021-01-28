package com.example.comichub.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.comichub.R;

public class CreatorFragment extends Fragment{

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_creator, container, false);

        TextView textView = root.findViewById(R.id.text_creator);
        textView.setText("Hello from CREATOR");

        return root;
    }

}
