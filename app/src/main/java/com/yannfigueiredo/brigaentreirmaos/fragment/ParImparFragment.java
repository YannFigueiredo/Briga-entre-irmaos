package com.yannfigueiredo.brigaentreirmaos.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yannfigueiredo.brigaentreirmaos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParImparFragment extends Fragment {


    public ParImparFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_par_impar, container, false);
    }

}
