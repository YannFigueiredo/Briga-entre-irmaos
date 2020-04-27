package com.yannfigueiredo.brigaentreirmaos.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yannfigueiredo.brigaentreirmaos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaraCoroaFragment extends Fragment {

    public CaraCoroaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cara_coroa, container, false);
        return view;
    }

}
