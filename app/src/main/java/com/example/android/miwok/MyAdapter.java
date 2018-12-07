package com.example.android.miwok;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDefaultTranslation;
    private String[] mMiwokTranslation;
    private int[] mDefaultImages;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mLinearLayout;
        public MyViewHolder(LinearLayout v) {
            super(v);
            mLinearLayout = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(int[] mDefaultImages, String[] mDefaultTranslation, String[] mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultImages = mDefaultImages;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout ll = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_layout, parent, false);
        return new MyViewHolder(ll);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        LinearLayout linearLayout = holder.mLinearLayout;
        ImageView imageview = (ImageView) linearLayout.findViewById(R.id.imageView);
        Drawable drawable = ContextCompat.getDrawable(linearLayout.getContext(), mDefaultImages[position]);
        imageview.setImageDrawable(drawable);
        imageview.setContentDescription(mMiwokTranslation[position]);
        TextView dtextView = (TextView) linearLayout.findViewById(R.id.defaultView);
        dtextView.setText(mDefaultTranslation[position]);
        TextView mtextView = (TextView) linearLayout.findViewById(R.id.miwokView);
        mtextView.setText(mMiwokTranslation[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDefaultTranslation.length;
    }
}