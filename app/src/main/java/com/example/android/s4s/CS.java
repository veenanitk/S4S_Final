package com.example.android.s4s;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CS extends Fragment {


    public CS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_cs, container, false);

        perform(v);

        return v;
    }



    @Override
    public void onStop() {
        super.onStop();
    }

    public void perform(View v) {

         ArrayList<Book> books = new ArrayList<Book>();
        for(int i=0;i<10;i++) {
            books.add(new Book("The Lost Symbol", "Dan Brown", "Rs.500", "Add", R.drawable.angelsanddemons, R.drawable.book_ratings, R.drawable.ic_add_shopping_cart));
            books.add(new Book("Angels and Demons", "Dan Brown", "Rs.625", "Add", R.drawable.book2, R.drawable.book_ratings, R.drawable.ic_add_shopping_cart));
        }



        BookAdapter adapter = new BookAdapter(getActivity(), books);

         ListView listView = (ListView) v.findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(),addtocart.class);
                startActivity(intent);
            }
        });


    }






}


