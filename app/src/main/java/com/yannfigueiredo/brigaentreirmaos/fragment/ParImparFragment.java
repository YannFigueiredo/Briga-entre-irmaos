package com.yannfigueiredo.brigaentreirmaos.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yannfigueiredo.brigaentreirmaos.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParImparFragment extends Fragment {

    private String escolhido, escolhaParImpar;
    private List<String> envolvidos = new ArrayList<>();
    private Button buttonPar, buttonImpar;
    private ImageView imagePessoa1, imagePessoa2;
    private TextView textPessoa1, textPessoa2, textEscolha, textResultado;

    public ParImparFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_par_impar, container, false);

        this.textEscolha = view.findViewById(R.id.textEscolha);
        this.textPessoa1 = view.findViewById(R.id.textPessoa1);
        this.textPessoa2 = view.findViewById(R.id.textPessoa2);
        this.textResultado = view.findViewById(R.id.textResultado);
        this.buttonPar = view.findViewById(R.id.buttonPar);
        this.buttonImpar = view.findViewById(R.id.buttonImpar);
        this.imagePessoa1 = view.findViewById(R.id.imageMaoPessoa1);
        this.imagePessoa2 = view.findViewById(R.id.imageMaoPessoa2);

        Bundle dadosEnvolvidos = getArguments();

        this.escolhido = this.determinarEscolha(dadosEnvolvidos.getString("pessoa1"), dadosEnvolvidos.getString("pessoa2"));
        this.envolvidos.add(dadosEnvolvidos.getString("pessoa1"));
        this.envolvidos.add(dadosEnvolvidos.getString("pessoa2"));

        this.textEscolha.setText("Faça sua escolha, "+this.escolhido+"!");
        this.textPessoa1.setText(this.escolhido);
        this.textPessoa2.setText(this.outro());

        buttonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaParImpar = "Par";
                buttonPar.setBackgroundResource(R.drawable.background_button_selecionado);
                buttonImpar.setBackgroundResource(R.drawable.background_button);
                definirMaos();
            }
        });

        buttonImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaParImpar = "Impar";
                buttonImpar.setBackgroundResource(R.drawable.background_button_selecionado);
                buttonPar.setBackgroundResource(R.drawable.background_button);
                definirMaos();
            }
        });

        return view;
    }

    public String determinarEscolha(String pessoa1, String pessoa2){
        String envolvidos[] = {pessoa1, pessoa2};
        int escolha = new Random().nextInt(2);

        return envolvidos[escolha];
    }

    public String outro(){
        String outro = "";
        for (int i=0;i<=1;i++){
            if (envolvidos.get(i) != escolhido){
                outro = envolvidos.get(i);
            }
        }
        return outro;
    }

    public void definirMaos(){
        int maos[] = {R.drawable.mao0, R.drawable.mao1, R.drawable.mao2, R.drawable.mao3, R.drawable.mao4, R.drawable.mao5};
        int maoPessoa1 = new Random().nextInt(6);
        int maoPessoa2 = new Random().nextInt(6);
        this.imagePessoa1.setImageResource(maos[maoPessoa1]);
        this.imagePessoa2.setImageResource(maos[maoPessoa2]);

        this.checarResultado(maoPessoa1, maoPessoa2);
    }

    public void checarResultado(int maoPessoa1, int maoPessoa2){
        int somaMaos = maoPessoa1 + maoPessoa2;

        if(somaMaos % 2 == 0){
            this.textResultado.setText("Resultado: Par");
            if(this.escolhaParImpar == "Par"){
                Toast.makeText(getContext(), this.escolhido+" venceu!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getContext(), this.outro()+" venceu!", Toast.LENGTH_LONG).show();
            }
        }else{
            this.textResultado.setText("Resultado: Ímpar");
            if(this.escolhaParImpar == "Impar"){
                Toast.makeText(getContext(), this.escolhido+" venceu!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getContext(), this.outro()+" venceu!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
