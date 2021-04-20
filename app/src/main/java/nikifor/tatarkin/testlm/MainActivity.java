package nikifor.tatarkin.testlm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import nikifor.tatarkin.testlm.recyclerview.CategoryAdapter;
import nikifor.tatarkin.testlm.recyclerview.ProductAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Тестовые массивы данных для RecyclerView.
        int[] dataCategory = {R.drawable.catalog, R.drawable.catalog_light, R.drawable.catalog_material, R.drawable.catalog_more};
        int[] dataImageProduct = {R.drawable.product1, R.drawable.product2,R.drawable.product3,R.drawable.product4,R.drawable.product5,R.drawable.product6};
        String[] dataNameProducts = getResources().getStringArray(R.array.nameProduct);
        String[] dataPriceProducts = getResources().getStringArray(R.array.priceProduct);

        //Инициализация RecyclerView.
        initCategoryRecyclerView(dataCategory);
        initProductRecyclerView(dataImageProduct, dataNameProducts, dataPriceProducts);
        initProductBestPriceRecyclerView(dataImageProduct, dataNameProducts, dataPriceProducts);

        //Сокрытие челки.
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initProductRecyclerView(int[] dataImageProduct, String[] dataNameProducts, String[] dataPriceProducts) {
        RecyclerView recyclerView = findViewById(R.id.stocks_recycle_view);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ProductAdapter adapter = new ProductAdapter(dataNameProducts, dataPriceProducts, dataImageProduct);
        recyclerView.setAdapter(adapter);

    }
    private void initProductBestPriceRecyclerView(int[] dataImageProduct, String[] dataNameProducts, String[] dataPriceProducts) {
        RecyclerView bestPriceRecyclerView = findViewById(R.id.best_price_recycle_view);

        bestPriceRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        bestPriceRecyclerView.setLayoutManager(layoutManager);

        ProductAdapter adapter = new ProductAdapter(dataNameProducts, dataPriceProducts, dataImageProduct);
        bestPriceRecyclerView.setAdapter(adapter);

    }
    private void initCategoryRecyclerView(int[] data_category) {
        RecyclerView recyclerView = findViewById(R.id.category_recycle_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        CategoryAdapter adapter = new CategoryAdapter(data_category);
        recyclerView.setAdapter(adapter);
    }
}