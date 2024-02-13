package es.iescarrillo.android.ifoody.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import es.iescarrillo.android.ifoody.R;
import es.iescarrillo.android.ifoody.models.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categoryList;
    private Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categoryList = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);


        return new CategoryViewHolder(view);
    }

    //metodo en el que vamos a modificar las coasas que hemos puesto antes
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
       // holder.bind(category);
        holder.imgCategory.setImageResource((category.getImage()));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCategory;
        private TextView title;

        //definir los componenetes de la vista
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.img_category);
            title = itemView.findViewById(R.id.text_category);
        }

//        public void bind(Category category) {
//            int resourceId = context.getResources().getIdentifier(category.getImage(), "drawable", context.getPackageName());
//
//            Picasso.get().load(resourceId).into(imgCategory);
//            title.setText(category.getTitle());
//        }
    }
}
