package com.example.practicaexamen.classes;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class cEmpresaServicio {
    Realm realm;

    public cEmpresaServicio(Realm _mreal) {
        realm = _mreal;
    }

    public boolean insertarEmpresa(cEmpresa _empresa) {
        boolean retorno = false;

        try {
            int mCodigoEmpresa = calculaCodigoEmpresa();
            realm.beginTransaction();
            cEmpresa mEmpresa = realm.createObject(cEmpresa.class, mCodigoEmpresa);
            mEmpresa.setNombre(_empresa.getNombre());
            mEmpresa.setEMail(_empresa.getEMail());
            mEmpresa.setTelefono(_empresa.getTelefono());
            mEmpresa.setDireccion(_empresa.getDireccion());
            realm.commitTransaction();
            retorno = true;
        }catch (Exception error) {
            retorno = false;
        }

        return retorno;
    }

    public List<cEmpresa> listaEmpresas() {
        RealmResults<cEmpresa> mListaEmpresas = realm.where(cEmpresa.class).findAll();

        return realm.copyFromRealm(mListaEmpresas);
    }

    private final static int calculaCodigoEmpresa() {
        Realm _realm = Realm.getDefaultInstance();

        Number mCodigoEmpresaMaximo = _realm.where(cEmpresa.class).max("IdEmpresa");
        int nextCodigo;

        if(mCodigoEmpresaMaximo== null) {
            nextCodigo = 1;
        }else {
            nextCodigo = mCodigoEmpresaMaximo.intValue() + 1;
        }

        return nextCodigo;
    }
}
