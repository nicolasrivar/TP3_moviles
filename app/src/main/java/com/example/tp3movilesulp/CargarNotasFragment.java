package com.example.tp3movilesulp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CargarNotasFragment extends Fragment {

    private CargarViewModel cargarViewModel;
    private ListarViewModel listarViewModel;
    private EditText inputNota;
    private Button btnAgregarNota;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cargar_notas, container, false);

        listarViewModel = new ViewModelProvider(requireActivity()).get(ListarViewModel.class);
        cargarViewModel = new CargarViewModel(listarViewModel);

        inputNota = view.findViewById(R.id.inputNota);
        btnAgregarNota = view.findViewById(R.id.btnAgregarNota);

        btnAgregarNota.setOnClickListener(v -> {
            String nuevaNota = inputNota.getText().toString();
            if (!TextUtils.isEmpty(nuevaNota)) {
                cargarViewModel.agregarNota(nuevaNota);  // Agregar la nota usando el ViewModel
                inputNota.setText("");
                Toast.makeText(getContext(), "Nota agregada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Ingrese una nota", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

