package nikifor.tatarkin.testlm.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nikifor.tatarkin.testlm.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private String[] nameProducts;
    private String[] price;
    private int[] imageProduct;

    public ProductAdapter(String[] nameProducts, String[] price, int[] imageProduct){
        this.imageProduct = imageProduct;
        this.nameProducts = nameProducts;
        this.price = price;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.getImageView().setImageResource(imageProduct[position]);
        holder.getName().setText(nameProducts[position]);
        holder.getPrice().setText(price[position]);
    }

    @Override
    public int getItemCount() {
        return nameProducts.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView price;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageProduct);
            price = (TextView) itemView.findViewById(R.id.price_text);
            name = (TextView) itemView.findViewById(R.id.title_text_view);
        }
        public ImageView getImageView() {
            return imageView;
        }
        public TextView getPrice(){
            return price;
        }
        public TextView getName(){
            return name;
        }
    }
}
