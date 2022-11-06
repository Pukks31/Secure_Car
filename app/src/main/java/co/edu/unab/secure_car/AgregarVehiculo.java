package co.edu.unab.secure_car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AgregarVehiculo extends AppCompatActivity {
    EditText pt_nombre, pt_edad, pt_genero, pt_id, pt_marca, pt_referencia, pt_modelo, pt_placa, pt_color;
    Button btn_continuar_ag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_agregar_vehiculo);

            pt_nombre=findViewById(R.id.pt_nombre);
            pt_edad=findViewById(R.id.pt_edad);
            pt_genero=findViewById(R.id.pt_genero);
            pt_id=findViewById(R.id.pt_id);
            pt_marca=findViewById(R.id.pt_marca);
            pt_referencia=findViewById(R.id.pt_referencia);
            pt_modelo=findViewById(R.id.pt_modelo);
            pt_placa=findViewById(R.id.pt_placa);
            pt_color=findViewById(R.id.pt_color);
            btn_continuar_ag=findViewById(R.id.btn_continuar_ag);

            pt_nombre.setText(getIntent().getStringExtra("Nombre"));
            pt_edad.setText(getIntent().getStringExtra("Edad"));
            pt_genero.setText(getIntent().getStringExtra("Genero"));
            pt_id.setText(getIntent().getStringExtra("ID"));
            pt_marca.setText(getIntent().getStringExtra("Marca"));
            pt_referencia.setText(getIntent().getStringExtra("Referencia"));
            pt_modelo.setText(getIntent().getStringExtra("Modelo"));
            pt_placa.setText(getIntent().getStringExtra("Placa"));
            pt_color.setText(getIntent().getStringExtra("color"));
            }

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Cjidln2ifbT5w9WNWvN05dVfbnw2");

    public void guardarDatos(View view){
        String hola = "asd";
    }

    public void onClickBtnAgregar(View view){
        //Ir a la ventana del login
        Intent ingresar = new Intent(AgregarVehiculo.this, Home.class);
        startActivity(ingresar);
    }

}