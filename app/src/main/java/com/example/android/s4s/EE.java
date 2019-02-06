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
public class EE extends Fragment {


    public EE() {
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

    public void perform(View v) {

        ArrayList<Book> books3 = new ArrayList<Book>();

        for(int i = 0;i<10;i++)
        {
            books3.add(new Book("The Lost Symbol","Dan Brown", "Rs.500", "Add",R.drawable.ic_menu_gallery,R.drawable.book_ratings,R.drawable.ic_add_shopping_cart));
        }


        BookAdapter adapter3 = new BookAdapter(getActivity(), books3);

        ListView listView = (ListView) v.findViewById(R.id.list);

        listView.setAdapter(adapter3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(),addtocart.class);
                startActivity(intent);
            }
        });

    }

}
