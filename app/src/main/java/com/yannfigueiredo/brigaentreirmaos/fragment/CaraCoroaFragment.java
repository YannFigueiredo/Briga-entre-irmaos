package com.yannfigueiredo.brigaentreirmaos.fragment;


import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yannfigueiredo.brigaentreirmaos.R;
import com.yannfigueiredo.brigaentreirmaos.activity.JogosActivity;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_ENABLE_WRITE_AHEAD_LOGGING;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaraCoroaFragment extends Fragment {

    private String escolhido, escolhaFace;
    private Button buttonCara, buttonCoroa, buttonLancar;
    private ImageView imageMoeda;
    private List<String> envolvidos = new ArrayList<>();
    public String registro = "";
    private MediaPlayer mediaPlayer;

    public CaraCoroaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cara_coroa, container, false);

        TextView textEscolha = view.findViewById(R.id.textEscolha);
        this.buttonCara = view.findViewById(R.id.buttonCara);
        this.buttonCoroa = view.findViewById(R.id.buttonCoroa);
        this.buttonLancar = view.findViewById(R.id.buttonLancar);
        this.imageMoeda = view.findViewById(R.id.imageMoeda);

        this.escolhaFace = null;

        Bundle dadosEnvolvidos = getArguments();
        
        this.escolhido = determinarEscolha(dadosEnvolvidos.getString("pessoa1"), dadosEnvolvidos.getString("pessoa2"));
        this.envolvidos.add(dadosEnvolvidos.getString("pessoa1"));
        this.envolvidos.add(dadosEnvolvidos.getString("pessoa2"));

        textEscolha.setText(String.format("Faça sua escolha, %s!", this.escolhido));

         buttonCara.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 executarSomBotao();
                 buttonCara.setBackgroundResource(R.drawable.background_button_selecionado);
                 buttonCoroa.setBackgroundResource(R.drawable.background_button);
                 escolhaFace = "Cara";
                 Toast.makeText(getContext(), escolhido+" escolheu "+escolhaFace+"!", Toast.LENGTH_SHORT).show();
             }
         });

        buttonCoroa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarSomBotao();
                buttonCoroa.setBackgroundResource(R.drawable.background_button_selecionado);
                buttonCara.setBackgroundResource(R.drawable.background_button);
                escolhaFace = "Coroa";
                Toast.makeText(getContext(), escolhido+" escolheu "+escolhaFace+"!", Toast.LENGTH_SHORT).show();
            }
        });
        
        buttonLancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String faces[] = {"Cara", "Coroa"};
                int faceSorteada = new Random().nextInt(2);

                if (escolhaFace == null){
                    Toast.makeText(getContext(), escolhido+ " ainda não escolheu!", Toast.LENGTH_SHORT).show();
                }else {
                    executarSomMoeda();
                    if (faces[faceSorteada].equals(escolhaFace)) {
                        Toast.makeText(getContext(), escolhido + " venceu!", Toast.LENGTH_SHORT).show();
                        atualizarImagem(faces[faceSorteada]);
                        registro += "Ganhador: " + escolhido + " - Escolha: " + escolhaFace + ",";
                    } else {
                        Toast.makeText(getContext(), outro() + " venceu!", Toast.LENGTH_SHORT).show();
                        atualizarImagem(faces[faceSorteada]);
                        registro += "Ganhador: " + outro() + " - Escolha: " + faces[faceSorteada] + ",";
                    }
                }
            }
        });

        return view;
    }

    public String determinarEscolha(String pessoa1, String pessoa2){
        String envolvidos[] = {pessoa1, pessoa2};
        int escolha = new Random().nextInt(2);
        return envolvidos[escolha];
    }

    public void atualizarImagem(String faceSorteada){
        if (faceSorteada.equals("Cara")){
            imageMoeda.setImageResource(R.drawable.cara);
        }else if(faceSorteada.equals("Coroa")){
            imageMoeda.setImageResource(R.drawable.coroa);
        }
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

    public void executarSomBotao(){
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.clickbotao);
        mediaPlayer.start();
    }

    public void executarSomMoeda(){
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.sommoeda);
        mediaPlayer.start();
    }

}
