package com.example.android.s4s;

public class Book {

    private String mBookname;

    private String mAuthorname;

    private String mPrice;

    private String wish = "Wishlist";

    private int mgetBookImageId;

    private int mgetRatingsId;

    private int maddtoCartId;

    public Book(String Bookname,String Authorname,String Price,String wish,int BookImageId,int RatingsId,int addtoCartId)
    {
        mBookname = Bookname;
        mAuthorname = Authorname;
        mPrice = Price;
        this.wish = wish;
        mgetBookImageId = BookImageId;
        mgetRatingsId = RatingsId;
        maddtoCartId = addtoCartId;
    }

    public int getMgetBookImageId() {
        return mgetBookImageId;
    }

    public int getMgetRatingsId() {
        return mgetRatingsId;
    }

    public int getMaddtoCartId() {
        return maddtoCartId;
    }

    public String getmBookname() {
        return mBookname;
    }

    public String getmAuthorname() {
        return mAuthorname;
    }

    public String getmPrice() {
        return mPrice;
    }

    public String getWish() {
        return wish;
    }




}
