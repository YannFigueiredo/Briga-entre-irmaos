package com.yannfigueiredo.brigaentreirmaos.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yannfigueiredo.brigaentreirmaos.R;
import com.yannfigueiredo.brigaentreirmaos.activity.JogosActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaraCoroaFragment extends Fragment {

    public CaraCoroaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        JogosActivity jogos = new JogosActivity();
        View view = inflater.inflate(R.layout.fragment_cara_coroa, container, false);
        //TextView textEscolha = view.findViewById(R.id.textEscolha);
        //textEscolha.setText(jogos.lista_envolvidos[jogos.determinarEscolha()]);
        //Toast.makeText(getContext(), jogos.lista_envolvidos[0], Toast.LENGTH_LONG).show();
        //int escolha = jogos.determinarEscolha();
        return view;
    }

}
