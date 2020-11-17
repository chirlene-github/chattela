package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    TextView tvMessage;
    public static final String KEY_RESPOSTA = "RESPOSTA";
    public final static String KEY_INTENT_MAIN2 = "MENSAGEM_MAIN2";


    private SharedPreferences sharedPreferences;

    private Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        editText = findViewById(R.id.ed_mensagem2);
        tvMessage = findViewById(R.id.tv_recebida2);
        Button button = findViewById(R.id.bt_enviar2);

        sharedPreferences = this.getSharedPreferences("TAG_PREFERENCES", Context.MODE_PRIVATE);

      String mensagemRecebida = sharedPreferences.getString(MainActivity.KEY_MAINACTIVITY, "Não existem dados.");

        tvMessage.setText(mensagemRecebida);

        button.setOnClickListener((View) -> {


            String value = editText.getText().toString();

            if (!value.isEmpty()) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_RESPOSTA,value);
                editor.apply();
            }
            finish();
        });

    }
}

