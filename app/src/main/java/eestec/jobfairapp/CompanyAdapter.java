package eestec.jobfairapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XMAN on 5.10.2016.
 */
public class CompanyAdapter extends ArrayAdapter<Company> {

    ArrayList<Company> companyList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public CompanyAdapter(Context context, int resource, ArrayList<Company> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        companyList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);

            holder.company_name = (TextView) v.findViewById(R.id.company_name);
            holder.company_email = (TextView) v.findViewById(R.id.company_email);
            holder.company_web = (TextView) v.findViewById(R.id.company_web);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.company_name.setText(companyList.get(position).getName());
        holder.company_email.setText(companyList.get(position).getEmail());
        holder.company_web.setText("Web: " + companyList.get(position).getWeb());
        return v;

    }
    static class ViewHolder {
        public TextView company_name;
        public TextView company_email;
        public TextView company_web;

    }

}
