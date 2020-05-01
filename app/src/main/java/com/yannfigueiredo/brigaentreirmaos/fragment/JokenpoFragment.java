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
public class JokenpoFragment extends Fragment {

    private String escolhido, escolhaJokenpo;
    private List<String> envolvidos = new ArrayList<>();
    private ImageView imagePessoa1, imagePessoa2, buttonPedra, buttonPapel, buttonTesoura;
    private TextView textPessoa1, textPessoa2, textEscolha;

    public JokenpoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jokenpo, container, false);

        this.textEscolha = view.findViewById(R.id.textEscolha);
        this.textPessoa1 = view.findViewById(R.id.textPessoa1);
        this.textPessoa2 = view.findViewById(R.id.textPessoa2);
        this.buttonPedra = view.findViewById(R.id.buttonPedra);
        this.buttonPapel = view.findViewById(R.id.buttonPapel);
        this.buttonTesoura = view.findViewById(R.id.buttonTesoura);
        this.imagePessoa1 = view.findViewById(R.id.imagePessoa1);
        this.imagePessoa2 = view.findViewById(R.id.imagePessoa2);

        Bundle dadosEnvolvidos = getArguments();

        this.escolhido = this.determinarEscolha(dadosEnvolvidos.getString("pessoa1"), dadosEnvolvidos.getString("pessoa2"));
        this.envolvidos.add(dadosEnvolvidos.getString("pessoa1"));
        this.envolvidos.add(dadosEnvolvidos.getString("pessoa2"));

        this.textEscolha.setText("Faça sua escolha, "+this.escolhido+"!");
        this.textPessoa1.setText(this.escolhido);
        this.textPessoa2.setText(this.outro());

        this.buttonPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePessoa1.setImageResource(R.drawable.pedra);
                escolhaJokenpo = "Pedra";
                definirEscolhaPessoa2();
            }
        });

        this.buttonPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePessoa1.setImageResource(R.drawable.papel);
                escolhaJokenpo = "Papel";
                definirEscolhaPessoa2();
            }
        });

        this.buttonTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePessoa1.setImageResource(R.drawable.tesoura);
                escolhaJokenpo = "Tesoura";
                definirEscolhaPessoa2();
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

    public void definirEscolhaPessoa2(){
        int mao[] = {R.drawable.pedra, R.drawable.papel, R.drawable.tesoura};
        int maoSorteada = new Random().nextInt(3);
        this.imagePessoa2.setImageResource(mao[maoSorteada]);
        this.checarResultado(maoSorteada);
    }

    public void checarResultado(int maoPessoa2){
        String mao[] = {"Pedra", "Papel", "Tesoura"};
        if(this.escolhaJokenpo.equals(mao[maoPessoa2])){
            Toast.makeText(getContext(), "Empate!", Toast.LENGTH_LONG).show();
        }else if(this.escolhaJokenpo.equals("Pedra") && mao[maoPessoa2].equals("Tesoura")){
            Toast.makeText(getContext(), this.escolhido+" venceu!", Toast.LENGTH_LONG).show();
        }else if(this.escolhaJokenpo.equals("Pedra") && mao[maoPessoa2].equals("Papel")){
            Toast.makeText(getContext(), this.outro()+" venceu!", Toast.LENGTH_LONG).show();
        }else if(this.escolhaJokenpo.equals("Papel") && mao[maoPessoa2].equals("Pedra")){
            Toast.makeText(getContext(), this.escolhido+" venceu!", Toast.LENGTH_LONG).show();
        }else if(this.escolhaJokenpo.equals("Papel") && mao[maoPessoa2].equals("Tesoura")){
            Toast.makeText(getContext(), this.outro()+" venceu!", Toast.LENGTH_LONG).show();
        }else if(this.escolhaJokenpo.equals("Tesoura") && mao[maoPessoa2].equals("Papel")){
            Toast.makeText(getContext(), this.escolhido+" venceu!", Toast.LENGTH_LONG).show();
        }else if(this.escolhaJokenpo.equals("Tesoura") && mao[maoPessoa2].equals("Pedra")){
            Toast.makeText(getContext(), this.outro()+" venceu!", Toast.LENGTH_LONG).show();
        }
    }

}
