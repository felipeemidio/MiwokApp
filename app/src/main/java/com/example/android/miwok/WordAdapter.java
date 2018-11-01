package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    int backgroundColor;

    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects, int backgroundColor) {
        super(context, 0, objects);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView with the default word in the list_item.xml layout
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the defaut word from the current Word object and
        // set this text on the defaultWord TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView with the miwok word in the list_item.xml layout
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok word from the current Word object and
        // set this text on the miwoktWord TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){

            // Get the image resource ID from the current Word object and
            // set the image to imageView.
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        // Find the TextView with the default word in the list_item.xml layout
        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.textGroupView);
        linearLayout.setBackgroundColor(ContextCompat.getColor(getContext(), this.backgroundColor));

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
