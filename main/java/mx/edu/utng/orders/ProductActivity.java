package mx.edu.utng.orders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.edu.utng.orders.model.Product;
import mx.edu.utng.orders.sqlite.DBOperations;

public class ProductActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPrice;
    private EditText etStock;
    private Button btAddProduct;
    private DBOperations operations;
    private Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initComponents();
    }

    private void initComponents(){
        etName = (EditText)findViewById(R.id.et_name);
        etPrice = (EditText)findViewById(R.id.et_price);
        etStock = (EditText)findViewById(R.id.et_stock);
        btAddProduct = (Button)findViewById(R.id.bt_add_product);
        btAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = new Product("", etName.getText().toString(),
                        Float.parseFloat(etPrice.getText().toString()),
                        Integer.parseInt(etStock.getText().toString()));
                operations.insertProduct(product);
            }
        });

    }

}
