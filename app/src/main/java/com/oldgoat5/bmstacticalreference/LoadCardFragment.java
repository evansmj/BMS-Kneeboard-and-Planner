package com.oldgoat5.bmstacticalreference;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    private EditText jokerEditText;
    private EditText bingoEditText;
    private SharedPreferences dataCard;
    private View view;

    //todo save datacard, clear data card
    //todo add alow and msl floor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.loadcard_fragment_layout, container, false);

        instantiateResources();
        loadDataCard("DataCard"); //placeholder for selected saved card.
        changeTextAppearance(getSelectedCardSize());

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        loadDataCard("DataCard");
        SharedPreferences.Editor editor = dataCard.edit();
        editor.remove("joker");
        editor.remove("bingo");
        editor.apply();
        changeTextAppearance(getSelectedCardSize());
    }

    private int getSelectedCardSize()
    {
        int selectedCardSize;

        switch (dataCard.getInt("cardSize", 1))
        {
            case 0:
                selectedCardSize = android.R.style.TextAppearance_Small;
                break;
            case 1:
                selectedCardSize = android.R.style.TextAppearance_Medium;
                break;
            case 2:
                selectedCardSize = android.R.style.TextAppearance_Large;
                break;
            default:
                selectedCardSize = android.R.style.TextAppearance_Small;
        }

        return selectedCardSize;
    }

    private void changeTextAppearance(int size)
    {
        View child = ((ViewGroup)view).getChildAt(0);
        //Log.d("LoadCardFragment", child.toString());

        for (int i = 0; i < ((ViewGroup)child).getChildCount(); i++)
        {
            View grandchild = ((ViewGroup)child).getChildAt(i);
            //Log.d("LoadCardFragment", grandchild.toString());
            //if there is text view or edit text, change textappearance size.

            if (grandchild.toString().contains("text_view"))
            {
                TextView grandchildTextView = (TextView) grandchild;
                grandchildTextView.setTextAppearance(this.getActivity(), size);
                grandchildTextView.setTextColor(Color.BLACK);
            }
            if (grandchild.toString().contains("edit_text"))
            {
                EditText grandchildEditText = (EditText) grandchild;
                grandchildEditText.setTextAppearance(this.getActivity(), size);
                grandchildEditText.setTextColor(Color.BLACK);
            }

            if (grandchild.toString().contains("data_card_package_uhf_vhf_relative_layout"))
            {
                //Log.d("LoadCardFragment", "grandchild.tostring() = " + grandchild.toString());

                for (int x = 0; x < ((ViewGroup)grandchild).getChildCount(); x++)
                {
                    View greatgrandchild = ((ViewGroup)grandchild).getChildAt(x);

                    if (greatgrandchild.toString().contains("text_view"))
                    {
                        TextView greatgrandchildTextView = (TextView) greatgrandchild;
                        greatgrandchildTextView.setTextAppearance(this.getActivity(), size);
                        greatgrandchildTextView.setTextColor(Color.BLACK);
                    }
                    if (greatgrandchild.toString().contains("edit_text"))
                    {
                        EditText greatgrandchildEditText = (EditText) greatgrandchild;
                        greatgrandchildEditText.setTextAppearance(this.getActivity(), size);
                        greatgrandchildEditText.setTextColor(Color.BLACK);
                    }
                }
            }
        }
    }

    private void instantiateResources()
    {
        jokerEditText = (EditText) view.findViewById(R.id.data_card_joker_edit_text);
        bingoEditText = (EditText) view.findViewById(R.id.data_card_bingo_edit_text);
    }

    private void loadDataCard(String dataCardName)
    {
        //todo make shared preference keys global constants like c ?
        dataCard = getActivity().getSharedPreferences(dataCardName, 0);

        jokerEditText.setText(dataCard.getString("joker", "3000lbs"));
        bingoEditText.setText(dataCard.getString("bingo", "2000lbs"));
    }
}
