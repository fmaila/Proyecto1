package org.fisk.findteacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class ListadoGestionPerfilesActivity extends AppCompatActivity implements ItemClickListener {


    List<Usuario> personList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_mis_perfiles);
        //setContentView(R.layout.activity_main_mis_perfiles);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                addPerfil(null);
            }
        });

        ImageButton volver = findViewById(R.id.b_volver);
        volver.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                volverAPrincipal(null);
            }
        });



        llenardatos();

        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorListaPerfiles adaptadorListaPerfiles = new AdaptadorListaPerfiles(this, personList, this);
        recyclerView.setAdapter(adaptadorListaPerfiles);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u5 = new Usuario();
        u5.setName("Angélica López");
        u5.setProfesion("Profesora de Matemáticas");
        u5.setResourceId(R.drawable.profesora);
        u5.setPrecio("Desde $15/hora");
        u5.setDescripcion("La profesora trabaja a medio tiempo. En sus ratos libres enseña matemáticas a personas particulares. " +
                "La profesora conoce muchas áreas como Algebra y Aritmética");
        personList.add(u5);
        Usuario u3 = new Usuario();
        u3.setName("Daniel Salinas");
        u3.setProfesion("Profesor Conducción");
        u3.setResourceId(R.drawable.driver);
        u3.setPrecio("Desde $10/hora");
        u3.setDescripcion("Su función consiste en trasladar a las personalidades o visitantes comerciales o industriales" +
                " de una empresa desde el punto de llegada, por ejemplo, el aeropuerto o estación de trenes, hasta el lugar de destino.");
        personList.add(u3);




    }

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleMiPerfilActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    public void addPerfil(View view){
        Intent i = new Intent(this, Perfil.class);
        i.putExtra("add",true);
        startActivity(i);

    }

    public void volverAPrincipal(View view){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
