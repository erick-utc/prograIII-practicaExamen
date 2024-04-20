package com.example.practicaexamen.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practicaexamen.R;

import java.util.List;

public class CustomcEmpresaAdapter extends BaseAdapter {
    Context ctx;
    List<cEmpresa> mLstEmpresas;
    LayoutInflater inflater;

    public CustomcEmpresaAdapter(Context _ctx, List<cEmpresa> _list) {
        ctx = _ctx;
        mLstEmpresas = _list;
        inflater = LayoutInflater.from(_ctx);
    }

    @Override
    public int getCount() {
        return mLstEmpresas.size();
    }

    @Override
    public Object getItem(int position) {
        return mLstEmpresas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_empresas_list_adapter_view, null);
        TextView Nombre = (TextView) convertView.findViewById(R.id.txtCELNombre);
        TextView Email = (TextView) convertView.findViewById(R.id.txtCEAEmail);

        cEmpresa mEmpresa = mLstEmpresas.get(position);

        Nombre.setText(mEmpresa.getNombre());
        Email.setText(mEmpresa.getEMail());

        return convertView;
    }
}
