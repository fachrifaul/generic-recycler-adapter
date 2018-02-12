package com.fachrifaul.sample;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fachrifaul.genericrecycleradapter.GenericViewHolder;

/**
 * Created by Burak Eregar on 5.05.2017.
 */

public class ContactViewHolder extends GenericViewHolder {

    private final static int SELECTOR_COLOR = 0xFFBDBDBD;

    private TextView name;
    private TextView surname;

    private ContactModel mItem;

    public ContactViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.contact_row_name);
        surname = itemView.findViewById(R.id.contact_row_surname);
    }

    public void bindData(final Object element, boolean isSelected) {
        mItem = (ContactModel) element;
        // set whatever you want. for instance;
        surname.setText(mItem.getSurname());
        name.setText(mItem.getName());

        //background highlight isSelected
        ColorDrawable selectedDrawable = new ColorDrawable(isSelected ? SELECTOR_COLOR : 0X00000000);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            itemView.setBackground(selectedDrawable);
        else
            itemView.setBackgroundDrawable(selectedDrawable);
        itemView.setSelected(isSelected);

        itemView.setOnClickListener(view -> {
            Toast.makeText(itemView.getContext(), "Name: " + mItem.getName() + " Surname: " + mItem.getSurname(), Toast.LENGTH_SHORT).show();
        });
    }

}