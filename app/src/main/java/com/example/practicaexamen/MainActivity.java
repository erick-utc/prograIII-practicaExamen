package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicaexamen.classes.CustomcEmpresaAdapter;
import com.example.practicaexamen.classes.cEmpresa;
import com.example.practicaexamen.classes.cEmpresaServicio;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    TextView Nombre, Email, Telefono, Direccion;
    ListView mlstEmpresas;
    List<cEmpresa> mListaEmpresas =new ArrayList<cEmpresa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        RealmConfiguration mRealmConfiguration = new RealmConfiguration.Builder()
                .name("PracticaExamenFinal")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(mRealmConfiguration);

        Nombre = findViewById(R.id.txtMNombre);
        Email = findViewById(R.id.txtMEmail);
        Telefono = findViewById(R.id.txtMTelefono);
        Direccion = findViewById(R.id.txtMDireccion);
        mlstEmpresas = findViewById(R.id.lstMEmpresas);

        cargarEmpresas();
    }

    private void cargarEmpresas() {
        cEmpresaServicio mEmpresaServico = new cEmpresaServicio(Realm.getDefaultInstance());

        mListaEmpresas = mEmpresaServico.listaEmpresas();
        CustomcEmpresaAdapter mAdapter = new CustomcEmpresaAdapter(this, mListaEmpresas);
        mlstEmpresas.setAdapter(mAdapter);
    }

    public void agregarUsuario(View v) {
        cEmpresaServicio mEmpresaServicio = new cEmpresaServicio(Realm.getDefaultInstance());

        if(Nombre.getText().toString().trim() != "") {
            cEmpresa mEmpresa = new cEmpresa();
            mEmpresa.setNombre(Nombre.getText().toString().trim());
            mEmpresa.setEMail(Email.getText().toString().trim());
            mEmpresa.setTelefono(Telefono.getText().toString().trim());
            mEmpresa.setDireccion(Direccion.getText().toString().trim());
            mEmpresaServicio.insertarEmpresa(mEmpresa);

            limpiarControles();
            cargarEmpresas();
            Toast.makeText(this, "Empresa creada correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarControles() {
        Nombre.setText("");
        Email.setText("");
        Telefono.setText("");
        Direccion.setText("");
    }
}