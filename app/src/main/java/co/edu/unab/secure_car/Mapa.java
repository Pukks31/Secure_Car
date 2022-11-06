package co.edu.unab.secure_car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Mapa extends AppCompatActivity {

    ImageButton btn_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        btn_volver = findViewById(R.id.btn_volver);
    }
    public void onClickRegresar(View view){
        Intent volver = new Intent(Mapa.this, Home.class);
        startActivity(volver);}


}