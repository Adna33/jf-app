package eestec.jobfairapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class CompanyAdapter extends ArrayAdapter<Company>{

    Context context;
    int layoutResourceId;
    ArrayList<Company> data = null;

    public CompanyAdapter(Context context, int layoutResourceId, ArrayList<Company> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CompanyHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CompanyHolder();
            holder.name = (TextView)row.findViewById(R.id.company_name);

           // holder.email = (TextView)row.findViewById(R.id.company_email);
            //holder.web = (TextView)row.findViewById(R.id.company_web);

            row.setTag(holder);
        }
        else
        {
            holder = (CompanyHolder)row.getTag();
        }

        Company company = data.get(position);
        holder.name.setText(company.name);
        //holder.email.setText(company.email);
        //holder.web.setText(company.web);


        return row;
    }

    static class CompanyHolder
    {
        TextView name;
        //TextView email;
        //TextView web;
    }
}