package mx.edu.utng.orders;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.orders.R;
import mx.edu.utng.orders.adapters.ProductAdapter;
import mx.edu.utng.orders.adapters.TitleAdapter;
import mx.edu.utng.orders.model.Product;
import mx.edu.utng.orders.model.Title;
import mx.edu.utng.orders.sqlite.DBOperations;

/**
 * Created by ulises on 23/02/2017.
 */

public class TitleActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etFormDate;
    private EditText etToDate;
    private Button btSaveTitle;
    private DBOperations operations;
    private Title title = new Title() ;
    private List<Title> titles = new ArrayList<Title>();

    private TitleAdapter titleAdapter;

    private RecyclerView rvTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        operations = DBOperations.getDBOperations(getApplicationContext());
        title.setIdEmpNo("");
        initComponents();
    }
    private void initComponents(){
        etTitle = (EditText)findViewById(R.id.et_title);
        etFormDate = (EditText)findViewById(R.id.et_form_date);
        etToDate = (EditText)findViewById(R.id.et_to_date);
        rvTitles = (RecyclerView) findViewById(R.id.rv_title_list);
        rvTitles.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvTitles.setLayoutManager(layoutManager);
        getTitles();


        titleAdapter = new TitleAdapter(titles);
        titleAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.bt_delete_title:
                        operations.deleteTitle(
                                titles.get(rvTitles.getChildPosition((View)v.getParent().getParent())).getIdEmpNo());
                        getTitles();
                        titleAdapter.notifyDataSetChanged();
                        break;
                    case R.id.bt_edit_title:

                        Cursor c = operations.getTitleById(titles.get(rvTitles.getChildPosition((View)v.getParent().getParent()))
                                .getIdEmpNo());

                        if(c!=null){
                            if(c.moveToFirst()){
                                title = new Title(c.getString(1),
                                        c.getString(2),c.getString(3), c.getString(4));
                            }
                            etTitle.setText(title.getTitle());
                            etFormDate.setText(String.valueOf(title.getFromDate()));
                            etToDate.setText(String.valueOf(title.getToDate()));
                        }else{
                            //Toast.makeText(getApplicationContext(),
                            //      "Registro no encontrado", Toast)
                        }

                        break;
                    default:
                        break;

                }


                //operations.deleteProduct(products.get(rvProducts.getChildPosition(v))
                //        .getIdProduct());
                //products.remove(rvProducts.getChildPosition(v));
                //adapter.notifyDataSetChanged();
            }
        });
        rvTitles.setAdapter(titleAdapter);
        btSaveTitle = (Button) findViewById(R.id.bt_save_title);



        btSaveTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getIdEmpNo().equals("")) {
                    title.setTitle(etTitle.getText().toString());
                    title.setFromDate(etFormDate.getText().toString());
                    title.setToDate(etToDate.getText().toString());


                    operations.updateTitle(title);
                } else {
                    title = new Title("", etTitle.getText().toString(),
                            (etFormDate.getText().toString()),
                            (etToDate.getText().toString()));
                    operations.insertTitle(title);
                }
                // Log.d("Products","Products");
                // DatabaseUtils.dumpCursor(operations.getProducts());
                clearData();
                getTitles();
                titleAdapter.notifyDataSetChanged();
            }
        });

    }

    private void getTitles(){

        Cursor  c= operations.getTitles();
        titles.clear();
        if(c!=null){
            while (c.moveToNext()){
                titles.add(new Title(c.getString(1),
                        c.getString(2),c.getString(3), c.getString(4)));

            }
        }
    }

    private void clearData(){
        etTitle.setText("");
        etFormDate.setText("");
        etToDate.setText("");
        title= null;
        title = new Title();
        title.getIdEmpNo();
    }

}
