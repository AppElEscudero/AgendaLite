package com.appsforusers.elescudero.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appsforusers.elescudero.R;

/**
 * Created by preto on 05/03/2018.
 */

public class InsertFragment extends Fragment{


    ImageButton btnCarrito;
    TextView textViewCarrito;

    public InsertFragment(){
        // Requerido para mostrar el Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.insert_layout,container,false);

        //btnCarrito=v.findViewById(R.id.buttonCarrito);
        // btnCarrito.setOnClickListener(this);

        return v;
    }

}


