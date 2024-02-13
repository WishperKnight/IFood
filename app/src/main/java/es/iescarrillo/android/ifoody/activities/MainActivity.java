package es.iescarrillo.android.ifoody.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.android.ifoody.R;
import es.iescarrillo.android.ifoody.adapters.CategoryAdapter;
import es.iescarrillo.android.ifoody.fragments.MyOrders;
import es.iescarrillo.android.ifoody.models.Category;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private CategoryAdapter adapter;
    private List<Category> categories;
    private RecyclerView rvList;
    private NavigationView menu;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadComponents();

        // Método para indicar que el toolbar hará la función de barra de acciones
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_menu,
                R.string.close_menu);

        // Listener para capturar los eventos que se produzcan en el menú lateral
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        // Evento para sincronizar el estado del botón hamburguesa con el estado del menú lateral
        actionBarDrawerToggle.syncState();

        rvList = findViewById(R.id.rv_categories);
        categories = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Category category = new Category();
            category.setTitle("Category " + i);
      //      category.setImage("@drawable/logo_rounded_app");
            categories.add(category);
        }

        adapter = new CategoryAdapter(getApplicationContext(), categories);
        rvList.setAdapter(adapter);
        menu.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.my_orders) {
                fragment= new MyOrders();

            } else if (item.getItemId() == R.id.my_profile) {
                Log.i("menu","has pinchado en mi perfil y no habia nada");

            }
            //Metodo para cargar el fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment).commit();
            //cargamos el fragment y cerramos el drawer
            drawerLayout.closeDrawers();

            return  true;
        });
    }


    private void loadComponents() {
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        menu = findViewById(R.id.nvMenu);
    }

}