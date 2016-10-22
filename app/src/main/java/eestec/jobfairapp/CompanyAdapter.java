package eestec.jobfairapp;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CompanyAdapter extends ArrayAdapter<Company> {

    ArrayList<Company> companies;
    Context context;
    int resource;

    public CompanyAdapter(Context context, int resource, ArrayList<Company> companies) {
        super(context, resource, companies);
        this.companies = companies;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.company_details, null, true);

        }
        Company company = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.company_logo);
        Picasso.with(context).load(company.getImage()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtCompany);
        txtName.setText(company.name);

        return convertView;
    }
}