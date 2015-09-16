package com.oldgoat5.bmstacticalreference;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/********************************************************************
 *Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 ********************************************************************/
public class LoadCardFragment extends Fragment
{
    private TextView grossWeightTextView;
    private TextView totalDragTextView;
    private View view;

    //todo reorganize tools package
    //todo setting to change text size.
    //todo retain last card.  add clear button

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.loadcard_fragment_layout, container, false);
        //grossWeightTextView = (TextView) view.findViewById(R.id.grossWeightTextView);
        //totalDragTextView = (TextView) view.findViewById(R.id.dragTextView);
        
        SharedPreferences dataCard = getActivity().getSharedPreferences("DataCard", 0);

        int grossWeight = dataCard.getInt("grossWeight", 0);
        //grossWeightTextView.setText(grossWeight + "lbs");

        //if shared preferences
        changeTextAppearance(0);

        return view;
    }

    private void changeTextAppearance(int size)
    {
        //todo change size to android.R.style.textappearances.

        View child = ((ViewGroup)view).getChildAt(0);
        Log.d("LoadCardFragment", child.toString());

        for (int i = 0; i < ((ViewGroup)child).getChildCount(); i++)
        {
            View grandchild = ((ViewGroup)child).getChildAt(i);
            Log.d("LoadCardFragment", grandchild.toString());
            //if there is text view or edit text, change textappearance size.

            if (grandchild.toString().contains("text_view"))
            {
                TextView grandchildTextView = (TextView) grandchild;
                grandchildTextView.setTextAppearance(this.getActivity(), android.R.style.TextAppearance_Small);
                grandchildTextView.setTextColor(Color.BLACK);
            }
            if (grandchild.toString().contains("edit_text"))
            {
                EditText grandchildEditText = (EditText) grandchild;
                grandchildEditText.setTextAppearance(this.getActivity(), android.R.style.TextAppearance_Small);
                grandchildEditText.setTextColor(Color.BLACK);
            }

            if (grandchild.toString().contains("data_card_package_uhf_vhf_relative_layout"))
            {
                Log.d("LoadCardFragment", "grandchild.tostring() = " + grandchild.toString());

                for (int x = 0; x < ((ViewGroup)grandchild).getChildCount(); x++)
                {
                    View greatgrandchild = ((ViewGroup)grandchild).getChildAt(x);

                    if (greatgrandchild.toString().contains("text_view"))
                    {
                        TextView greatgrandchildTextView = (TextView) greatgrandchild;
                        greatgrandchildTextView.setTextAppearance(this.getActivity(), android.R.style.TextAppearance_Small);
                        greatgrandchildTextView.setTextColor(Color.BLACK);
                    }
                    if (greatgrandchild.toString().contains("edit_text"))
                    {
                        EditText greatgrandchildEditText = (EditText) greatgrandchild;
                        greatgrandchildEditText.setTextAppearance(this.getActivity(), android.R.style.TextAppearance_Small);
                        greatgrandchildEditText.setTextColor(Color.BLACK);
                    }
                }
            }
        }
    }
    
}
