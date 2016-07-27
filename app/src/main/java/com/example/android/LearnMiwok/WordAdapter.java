package com.example.android.LearnMiwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tusharsharma on 17/07/16.
 */

/*
{@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 based on a data source, which is a list of {@link Word} objects.

 */
public class WordAdapter extends ArrayAdapter<Word> {

    public static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private int mColorResourceId ;

    /*
    This is our own custom constructor (it doesn't mirror a superclass constructor.)
     The context is used to inflate the layout file , and the list is the data we want
     to populate into the lists.

     @param context  The current context.Used to inflate the layout file.
     @param words A List of Word objects to display in a list.
     */

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        //Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        //the second argument is used when the ArrayAdapter is populating a single TextView.
        //Because this is a custom adapter for two TextViews , the adapter is not
        //going to use this second argument , so it can be any value.Here ,we used 0.


        super(context, 0, words);

        mColorResourceId = colorResourceId;
    }


    /*
    Provides a view for an AdapterView (ListView , GridView etc)

     @param position The position in the list of data that should be displayed in the list item view.
     @param convertView The recycled view to populate.
     @param parent The parent ViewGroup that is used for inflation.
     @return The view for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if the existing view is being reused , otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //Get the {@link Word} object located at this position in the list



        Word currentWords = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID number_miwok

        TextView numMiwok = (TextView) listItemView.findViewById(R.id.number_miwok);

        numMiwok.setText(currentWords.getmMiwokTranslation());

        TextView numDefault = (TextView)listItemView.findViewById(R.id.number_default);

        numDefault.setText(currentWords.getmDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_miwok);

        if (currentWords.hasImage()) {

            imageView.setImageResource(currentWords.getmImageResourceId());

            //Make sure the view is visible

            imageView.setVisibility(View.VISIBLE);



        }else{

            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
