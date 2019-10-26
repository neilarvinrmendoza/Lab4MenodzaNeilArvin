package com.mendoza.lab4menodzaneilarvin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {
    private Context context;
    private int resource;

    public AndroidAdapter(@NonNull Context context, int resource, @NonNull List<AndroidVersion> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent){
        int logo = getItem(i).getLogo();
        String company = getItem(i).getCompany();
        String country = getItem(i).getCountry();
        String industry = getItem(i).getIndustry();
        String ceo = getItem(i).getCeo();


        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.ivLogo);
        TextView companyName = convertView.findViewById(R.id.tvCompany);
        TextView countryName = convertView.findViewById(R.id.tvCountry);
        TextView industryName = convertView.findViewById(R.id.tvIndustry);
        TextView ceoName = convertView.findViewById(R.id.tvCEO);

        img.setImageResource(logo);
        companyName.setText(company);
        countryName.setText(country);
        industryName.setText(industry);
        ceoName.setText(ceo);
        return convertView;
    }
}
