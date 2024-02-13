package es.iescarrillo.android.ifoody.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.android.ifoody.R;
import es.iescarrillo.android.ifoody.adapters.CategoryAdapter;
import es.iescarrillo.android.ifoody.models.Category;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //obtengo el recycler view de la lista
        recyclerView = view.findViewById(R.id.rv_categories);

        //inicializamos el adapter
        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category("Burger", R.drawable.img_burguer));
        categoryList.add(new Category("Donut", R.drawable.img_donut));
        categoryList.add(new Category("Pizza", R.drawable.img_pizza_r));
        categoryList.add(new Category("Hot dogs", R.drawable.img_mexican));
        categoryList.add(new Category("Sandwich", R.drawable.img_asian));
        categoryList.add(new Category("Cold", R.drawable.img_icecream));

        adapter = new CategoryAdapter(getContext(), categoryList);
        recyclerView.setAdapter(adapter);

        //creamos la variable del tipo layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        /* Metodo con el cual vamos a pasar una variable del tipo LayoutManager
         * que es el que me va a dejar indicar
         * que tiene que mostararse en horizontal
         */
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}