package com.yannfigueiredo.brigaentreirmaos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.yannfigueiredo.brigaentreirmaos.Adaptador.Adapter;
import com.yannfigueiredo.brigaentreirmaos.Modelo.Registro;
import com.yannfigueiredo.brigaentreirmaos.R;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    private List<String> listaRegistro = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        this.lerArquivoTexto();

        this.recyclerView = findViewById(R.id.recyclerHistoricoView);

        Adapter adaptador = new Adapter(listaRegistro);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        this.recyclerView.setAdapter(adaptador);
    }

    public void lerArquivoTexto() {
        try {
            File f = getFileStreamPath("historicoLog.txt");
            if (f.exists()) {
                FileInputStream in = openFileInput("historicoLog.txt");
                int tamanho = in.available();
                byte bytes[] = new byte[tamanho];
                in.read(bytes);
                String s = new String(bytes);

                String listaS[] = s.split("[,]");
                this.criarLista(listaS);

                in.close();
            }
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
    }

    public void criarLista(String[] s){
        for(int i=0;i<=s.length;i++){
            this.listaRegistro.add(s[i]);
        }
    }
}
