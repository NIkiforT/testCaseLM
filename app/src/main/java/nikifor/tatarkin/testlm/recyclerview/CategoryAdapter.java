package nikifor.tatarkin.testlm.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nikifor.tatarkin.testlm.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private int[] dataSource;

    public CategoryAdapter(int[] dataSource){
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getButtonView().setImageResource(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageButton imageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = (ImageButton) itemView;
        }
        public ImageButton getButtonView() {
            return imageButton;
        }
    }
}
