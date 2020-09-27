package com.example.registrodedatos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button camara, enviarDatos;
    Bitmap bitmap;
    EditText edit1,edit2,edit3,edit4,edit5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=findViewById(R.id.editDNI);
        edit2=findViewById(R.id.editNombres);
        edit3=findViewById(R.id.editApellidos);
        edit4=findViewById(R.id.editEdad);
        edit5=findViewById(R.id.editDireccion);
        camara=findViewById(R.id.btnCamara);
        img=findViewById(R.id.imgFoto);
        enviarDatos=findViewById(R.id.btnRegistro);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 5);
            }
        });

        enviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("dato1", edit1.getText().toString());
                i.putExtra("dato2", edit2.getText().toString());
                i.putExtra("dato3", edit3.getText().toString());
                i.putExtra("dato4", edit4.getText().toString());
                i.putExtra("dato5", edit5.getText().toString());
                i.putExtra("BitmapImage", bitmap);
                //i.putExtra("img", R.drawable.image);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode != 0){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            bitmap=image;
            img.setImageBitmap(image);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}