package com.example.ownerside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CatalogueList extends AppCompatActivity {
    private CatalogueListAdapter adapter;
    List<Integer> images;
    List<String> titles;
    List<String> qtn;
    List<String> price;
    FloatingActionButton add_btn;
//    ImageView backbtn;
    private SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogue_list);
        searchView = findViewById(R.id.search_bar);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        images = new ArrayList<>();
        titles = new ArrayList<>();
        qtn = new ArrayList<>();
        price = new ArrayList<>();

        titles.add("plant1");
        titles.add("plant2");
        titles.add("plant3");
        titles.add("plant4");
        titles.add("plant5");
        titles.add("plant6");
        titles.add("plant6");
        titles.add("plant6");

        images.add(R.drawable.cac);
        images.add(R.drawable.cac1);
        images.add(R.drawable.cac2);
        images.add(R.drawable.cac3);
        images.add(R.drawable.cac4);
        images.add(R.drawable.cac5);
        images.add(R.drawable.cac5);
        images.add(R.drawable.cac5);

        qtn.add("qtn:1");
        qtn.add("qtn:2");
        qtn.add("qtn:3");
        qtn.add("qtn:2");
        qtn.add("qtn:1");
        qtn.add("qtn:3");
        qtn.add("qtn:3");
        qtn.add("qtn:3");


        price.add("Rs:100");
        price.add("Rs:100");
        price.add("Rs:100");
        price.add("Rs:100");
        price.add("Rs:100");
        price.add("Rs:100");
        price.add("Rs:100");
        price.add("Rs:100");

//      //  backbtn = findViewById(R.id.backpressed_about2);
//
//        backbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });


//        add_btn.setOnClickListener(view -> {
//            startActivity(new Intent(MainActivity.this , AddTask.class));
//        });


        adapter = new CatalogueListAdapter(CatalogueList.this, images, titles, qtn, price);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewrem);
        add_btn = findViewById(R.id.floatingActionButtonadd);
        //LinearLayoutManager manager = new LinearLayoutManager(TaskReminder.this);
        GridLayoutManager manager1 = new GridLayoutManager(CatalogueList.this,2);
        recyclerView.setLayoutManager(manager1);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }

    private void filterList(String text) {
        List<String> filteredList = new ArrayList<>();
        for(String tit: titles){
            filteredList.add(tit);
        }
        if(filteredList.isEmpty()){
            Toast.makeText(CatalogueList.this, "no data found", Toast.LENGTH_SHORT).show();
        }else {
            adapter.setFilteredList(filteredList);
        }
    }
//    public void onBackPressed() {
//
//
//        Intent i = new Intent(MainActivity.this, MainActivity.class);
//        startActivity(i);
////
//
//    }
}


