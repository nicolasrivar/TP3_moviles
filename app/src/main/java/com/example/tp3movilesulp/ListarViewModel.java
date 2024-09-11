package com.example.tp3movilesulp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3movilesulp.MainActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<String>> notasLiveData = new MutableLiveData<>();

    public ListarViewModel() {
        actualizarNotas();
    }

    public LiveData<ArrayList<String>> getNotas() {
        return notasLiveData;
    }

    public void actualizarNotas() {
        ArrayList<String> notas = MainActivity.notas;
        Collections.sort(notas);
        notasLiveData.setValue(notas);
    }
}

