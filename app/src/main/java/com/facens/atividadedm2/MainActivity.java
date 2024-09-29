package com.facens.atividadedm2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facens.atividadedm2.model.Local;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Local> localList = new ArrayList<>();
        localList.add(new Local("Zoológico", R.drawable.zoo, "Descrição do Zoológico", "https://maps.app.goo.gl/GcUC3y9NZKtu8hLT6", "https://site_zoologico", "123456789"));
        localList.add(new Local("Iguatemi", R.drawable.iguatemi, "Shopping da Cidade", "https://maps.app.goo.gl/bC36ZwYFDgbTuaki6", "https://site_zoologico", "123456789"));
        // Adicione os outros locais

        LocalAdapter adapter = new LocalAdapter(localList, this);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}