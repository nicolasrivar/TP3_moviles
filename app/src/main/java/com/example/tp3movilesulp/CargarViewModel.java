package com.example.tp3movilesulp;

import androidx.lifecycle.ViewModel;

public class CargarViewModel extends ViewModel {

    private ListarViewModel listarViewModel;

    public CargarViewModel(ListarViewModel listarViewModel) {
        this.listarViewModel = listarViewModel;
    }

    public void agregarNota(String nuevaNota) {
        MainActivity.notas.add(nuevaNota);
        listarViewModel.actualizarNotas();
    }
}
