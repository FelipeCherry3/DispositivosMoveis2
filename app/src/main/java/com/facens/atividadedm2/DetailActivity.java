package com.facens.atividadedm2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import com.facens.atividadedm2.model.Local;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ImageView imageViewDetail1 = findViewById(R.id.imageViewDetail1);
        ImageView imageViewDetail2 = findViewById(R.id.imageViewDetail2);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        Button buttonVerMapa = findViewById(R.id.buttonVerMapa);
        Button buttonAbrirSite = findViewById(R.id.buttonAbrirSite);
        Button buttonTelefonar = findViewById(R.id.buttonTelefonar);

        Local local = (Local) getIntent().getSerializableExtra("local");
        textViewDescription.setText(local.getDescricao());
        imageViewDetail1.setImageResource(local.getImageResourceId());
        imageViewDetail2.setImageResource(local.getImagem2());

        buttonVerMapa.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(local.getMapUrl()));
            startActivity(intent);
        });

        buttonAbrirSite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(local.getSite()));
            startActivity(intent);
        });

        buttonTelefonar.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + local.getPhone()));
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}