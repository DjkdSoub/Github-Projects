package com.example.examen_java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Acceuil extends ListActivity {
    TextView selection;
    String items [] = { "Ingenieur informatique", "Develloppeur Mobile","Maintenancier", "Annalyste","Expert cloud"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        selection = findViewById(R.id.selection);
    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
        selection.setText(items[position]);
    }
}
