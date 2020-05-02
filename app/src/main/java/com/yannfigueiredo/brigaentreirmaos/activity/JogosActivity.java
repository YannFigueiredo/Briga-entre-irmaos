package com.yannfigueiredo.brigaentreirmaos.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yannfigueiredo.brigaentreirmaos.R;
import com.yannfigueiredo.brigaentreirmaos.fragment.CaraCoroaFragment;
import com.yannfigueiredo.brigaentreirmaos.fragment.JokenpoFragment;
import com.yannfigueiredo.brigaentreirmaos.fragment.ParImparFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.util.Random;

public class JogosActivity extends AppCompatActivity {

    private CaraCoroaFragment cara_coroa_fragment = new CaraCoroaFragment();
    private ParImparFragment par_impar_fragment = new ParImparFragment();
    private JokenpoFragment jokenpo_fragment = new JokenpoFragment();
    private Button buttonCaraCoroa, buttonParImpar, buttonJokenpo;
    private String registro = "";
    private boolean cara_coroa, par_impar, jokenpo;

    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);

        this.buttonCaraCoroa = findViewById(R.id.buttonCaraCoroa);
        this.buttonParImpar = findViewById(R.id.buttonParImpar);
        this.buttonJokenpo = findViewById(R.id.buttonJokenpo);


        Bundle envolvidos = getIntent().getExtras();

        bundle.putString("pessoa1", envolvidos.getString("pessoa1"));
        bundle.putString("pessoa2", envolvidos.getString("pessoa2"));

        cara_coroa_fragment.setArguments(bundle);

        FragmentManager transaction = getSupportFragmentManager();
        transaction.beginTransaction().replace(R.id.frameConteudo, cara_coroa_fragment).commit();

        this.destacarButton("CaraCoroa");

        FloatingActionButton fab = findViewById(R.id.fabHistorico);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HistoricoActivity.class);
                startActivity(intent);

                determinarHistorico();

                gravarArquivoTexto(registro);
            }
        });
    }

    public void gravarArquivoTexto(String registro) {
        FileOutputStream out = null;
        try {
            out = openFileOutput("historicoLog.txt", MODE_PRIVATE);
            out.write(registro.getBytes());
            out.close();
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
    }

    public void acessarJogo(View view){
        if(view.getId()==R.id.buttonCaraCoroa){
            cara_coroa_fragment.setArguments(bundle);
            FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.frameConteudo, cara_coroa_fragment).commit();
            destacarButton("CaraCoroa");
        }else if(view.getId()==R.id.buttonParImpar){
            par_impar_fragment.setArguments(bundle);
            FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.frameConteudo, par_impar_fragment).commit();
            destacarButton("ParImpar");
        }else if(view.getId()==R.id.buttonJokenpo){
            jokenpo_fragment.setArguments(bundle);
            FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.frameConteudo, jokenpo_fragment).commit();
            destacarButton("Jokenpo");
        }
    }

    public void destacarButton(String buttonDestacado){
        if(buttonDestacado.equals("CaraCoroa")){
            buttonCaraCoroa.setBackgroundResource(R.drawable.button_destacado);
            buttonParImpar.setBackgroundResource(R.drawable.button_nao_destacado);
            buttonJokenpo.setBackgroundResource(R.drawable.button_nao_destacado);
            this.cara_coroa = true;
            this.par_impar = false;
            this.jokenpo = false;
        }else if(buttonDestacado.equals("ParImpar")){
            buttonParImpar.setBackgroundResource(R.drawable.button_destacado);
            buttonCaraCoroa.setBackgroundResource(R.drawable.button_nao_destacado);
            buttonJokenpo.setBackgroundResource(R.drawable.button_nao_destacado);
            this.par_impar = true;
            this.cara_coroa = false;
            this.jokenpo = false;
        }else{
            buttonJokenpo.setBackgroundResource(R.drawable.button_destacado);
            buttonCaraCoroa.setBackgroundResource(R.drawable.button_nao_destacado);
            buttonParImpar.setBackgroundResource(R.drawable.button_nao_destacado);
            this.jokenpo = true;
            this.cara_coroa = false;
            this.par_impar = false;
        }
    }

    public void determinarHistorico(){
        if(this.cara_coroa == true){
            this.registro = cara_coroa_fragment.registro;
        }else if(this.par_impar == true){
            this.registro = par_impar_fragment.registro;
        }else if(this.jokenpo == true){
            this.registro = jokenpo_fragment.registro;
        }
    }

}
