package com.example.registrodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    Button button;
    TextView et1,et2,et3,et4,et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=findViewById(R.id.editDNI);
        et2=findViewById(R.id.editNombres);
        et3=findViewById(R.id.editApellidos);
        et4=findViewById(R.id.editEdad);
        et5=findViewById(R.id.editDireccion);
        imageView=findViewById(R.id.imgFoto);
        button=findViewById(R.id.btnRegistro);

        String dato1 = getIntent().getStringExtra("dato1");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");
        String dato4 = getIntent().getStringExtra("dato4");
        String dato5 = getIntent().getStringExtra("dato5");
        Bitmap bitmap = getIntent().getParcelableExtra("BitmapImage");

        et1.setText(dato1);
        et2.setText(dato2);
        et3.setText(dato3);
        et4.setText(dato4);
        et5.setText(dato5);
        imageView.setImageBitmap(bitmap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}