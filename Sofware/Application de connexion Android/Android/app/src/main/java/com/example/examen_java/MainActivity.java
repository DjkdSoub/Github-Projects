package com.example.examen_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen_java.config.Api;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText email ;
    private EditText password ;
    private Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:8081")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);

                Call<ResponseBody> call = api.login(email.getText().toString(),password.getText().toString());
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                             Intent intent = new Intent(MainActivity.this,
                            Acceuil.class);
                            startActivity(intent);
                            JSONObject responseJson = null;
                            try {
                                responseJson = new JSONObject(response.toString());
                                String message  = responseJson.getString("message");
                                //httpMessageResponsetxt.setText(message);
                                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Error server",Toast.LENGTH_SHORT).show();
                        //httpMessageResponsetxt.setText("Erreur ...");
                    }
                });

            }
        });
    }
}
//  Intent intent= new Intent(MainActivity.this,Acceuil.class);
//startActivity(intent);
