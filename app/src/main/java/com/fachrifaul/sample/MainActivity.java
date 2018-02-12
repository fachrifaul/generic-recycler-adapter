package com.fachrifaul.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fachrifaul.genericrecycleradapter.GenericAdapterBuilder;
import com.fachrifaul.genericrecycleradapter.GenericRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainRv;
    private GenericRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainRv = findViewById(R.id.main_rv);

        initAdapter();

        mAdapter.setList(createDummyData());
    }

    private void initAdapter() {
        mMainRv.setLayoutManager(new LinearLayoutManager(this)); //set your layout manager
        mAdapter = new GenericAdapterBuilder().addModel(
                R.layout.row_contact, //set your row's layout file
                ContactViewHolder.class, //set your view holder class
                ContactModel.class) // set your model class(If you use just String list, it can be just String.class)
                .execute();
        mMainRv.setAdapter(mAdapter);
    }

    private ArrayList<ContactModel> createDummyData() {
        ArrayList<ContactModel> lList = new ArrayList<>();
        for (int i = 1; i < 80; i++) {
            lList.add(new ContactModel("Name" + i, "Surname" + i));
        }
        return lList;
    }
}
