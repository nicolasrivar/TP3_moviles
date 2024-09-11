package com.example.tp3movilesulp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListarNotasFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotasAdapter notasAdapter;
    private ListarViewModel listarViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar_notas, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewNotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listarViewModel = new ViewModelProvider(requireActivity()).get(ListarViewModel.class);

        listarViewModel.getNotas().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> notas) {
                notasAdapter = new NotasAdapter(notas);
                recyclerView.setAdapter(notasAdapter);
            }
        });

        return view;
    }
}
