package co.edu.unab.secure_car;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Home extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    Button btn_agregar;
    Button btn_cerrar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_agregar = findViewById(R.id.btn_nuevo_vehiculo);
        btn_cerrar_sesion = findViewById(R.id.btn_cerrar_sesion);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        }).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

        btn_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CerrarSesion();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Inicio");
        /*actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);*/

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }
    public void onClickAgregar(View view){
        //Ir a la ventana del login
        Intent ingresar = new Intent(Home.this, AgregarVehiculo.class);
        startActivity(ingresar);
    }

    protected void onStart(){
        verificacionInicioSesion();
        super.onStart();
    }

    private void verificacionInicioSesion(){
        if(firebaseUser != null){
            Toast.makeText(this, "Sesion iniciada", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(Home.this, Login.class));
            finish();
        }
    }

    private void CerrarSesion(){
        firebaseAuth.signOut();
        Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Home.this, Login.class));
    }

    /*private void TraerDatos(){
        String id= Objects.requireNonNull(mAuth.getCurrentUser()).getUid();


        databaseReference.child("Users").child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    String as =  String.valueOf(task.getResult().child("intentos").getValue(Integer.class));
                    if (task.getResult().child("name").exists()){
                        String nnombre = task.getResult().child("name").getValue(String.class);
                        nombre.setText(nnombre);
                    }
                    else {
                        nombre.setText("");
                    }
                    numero.setText(as);

                }
            }
        });
    }

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {



            for(DataSnapshot questions : snapshot.child("questions").getChildren()){

                String getQuestion = questions.child("question").getValue(String.class);
                String getOption1 = questions.child("option1").getValue(String.class);
                String getOption2 = questions.child("option2").getValue(String.class);
                String getOption3 = questions.child("option3").getValue(String.class);
                String getOption4 = questions.child("option4").getValue(String.class);
                int getAnswer = Integer.parseInt(questions.child("answer").getValue(String.class));


                ListaPreguntas listaPreguntas = new ListaPreguntas(getQuestion, getOption1, getOption2, getOption3, getOption4, getAnswer);


                CuestionarioActivity.this.listaPreguntas.add(listaPreguntas);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(CuestionarioActivity.this, "Failed to get data from Firebase", Toast.LENGTH_SHORT).show();
        }



    });*/
}

