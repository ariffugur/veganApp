package com.example.saglik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnvegan,btngluten,btnkalori,btnprotein;
Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit();
        btnvegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CameraVegan.class);
                startActivity(intent);
            }
        });
        btnkalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CameraKalori.class);
                startActivity(intent);
            }
        });
        btngluten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CameraGluten.class);
                startActivity(intent);
            }
        });
       btnprotein.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context,CameraProtein.class);
               startActivity(intent);
           }
       });
    }
    public void unit(){
        btngluten=(Button) findViewById(R.id.gluten);
        btnvegan=(Button) findViewById(R.id.vegan);
        btnprotein=(Button) findViewById(R.id.protein);
        btnkalori=(Button) findViewById(R.id.kalori);
    }
}