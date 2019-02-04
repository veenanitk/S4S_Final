package com.example.android.s4s;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    private ArrayList<Book> pBooks;
    private LayoutInflater mInflator;

    public BookAdapter(Context context, ArrayList<Book> pBooks) {
        super(context,0,pBooks);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Book local_book = getItem(position);

        TextView bookName = (TextView) listItemView.findViewById(R.id.book_title);
        bookName.setText(local_book.getmBookname());

        TextView bookAuthor = (TextView) listItemView.findViewById(R.id.book_author);
        bookAuthor.setText(local_book.getmAuthorname());

        TextView bookPrice = (TextView) listItemView.findViewById(R.id.book_price);
        bookPrice.setText(local_book.getmPrice());

        TextView wishlist = (TextView) listItemView.findViewById(R.id.text_wishlist);
        wishlist.setText(local_book.getWish());

        ImageView bookImage = (ImageView) listItemView.findViewById(R.id.item_image);
        bookImage.setImageResource(local_book.getMgetBookImageId());

        ImageView itemwish = (ImageView) listItemView.findViewById(R.id.add_wishlist);
        itemwish.setImageResource(local_book.getMaddtoCartId());

        ImageView ratings1 = (ImageView) listItemView.findViewById(R.id.book_ratings1);
        ratings1.setImageResource(local_book.getMgetRatingsId());


        return listItemView;
    }
}
