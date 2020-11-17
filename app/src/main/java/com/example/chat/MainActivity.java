package com.example.chat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private EditText ed_mensagem;
    TextView textView;
     TextView textView2;


    private SharedPreferences sharedPreferences;


    public final static String KEY_INTENT = "CHAVE MENSAGEM";
    public static final String TAG_KEY_MESSAGE = "MESSAGE_KEY";
    public static final String KEY_MAINACTIVITY = "KEY_MAINACTIVITY";

    private String valor;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("TAG_PREFERENCES", Context.MODE_PRIVATE);

        Button button = findViewById(R.id.bt_enviar);
        ed_mensagem = findViewById(R.id.ed_mensagem);
        textView2 = findViewById(R.id.tv_mensagem);
        textView = findViewById(R.id.tv_resposta);

        textView = findViewById(R.id.tv_mensagemfixa);


        button.setOnClickListener((View) -> {
            String mensagem = ed_mensagem.getText().toString();
          //  intent.putExtra(TAG_KEY_MESSAGE, mensagem);
            if (!mensagem.isEmpty()) {
                ed_mensagem.setText(mensagem);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_MAINACTIVITY, mensagem);
                editor.apply();
            }

            intent = new Intent(MainActivity.this, MainActivity2.class);
            //startActivityForResult(intent, 1000);
            startActivity(intent);
        });
        Log.i(LOG_TAG, "onCreate");
    }


   // @Override
    //protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      //  super.onActivityResult(requestCode, resultCode, data);
        //if (resultCode == 1) {
          //  if (resultCode == Activity.RESULT_OK) {
            //    String resposta = data.getStringExtra(MainActivity2.KEY_RESPOSTA);
              //  textView.setText(resposta);
            //}
        //}
    //}

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "onStart");
        valor = sharedPreferences.getString(MainActivity2.KEY_RESPOSTA, "Não tem dados no banco");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "onResume");
        textView.setText(valor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "onDestroy");
    }
}
