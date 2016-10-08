package eestec.jobfairapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by XMAN on 8.10.2016.
 */
public class NewsAdapter extends ArrayAdapter<News> {

        Context context;
        int layoutResourceId;
        ArrayList<News> data = null;

public NewsAdapter(Context context, int layoutResourceId, ArrayList<News> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NewsHolder holder = null;

        if(row == null)
        {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new NewsHolder();
                holder.name = (TextView)row.findViewById(R.id.news_name);
                holder.description = (TextView)row.findViewById(R.id.news_description);


                row.setTag(holder);
        }
        else
        {
                 holder = (NewsHolder)row.getTag();
        }

        News news = data.get(position);
        holder.name.setText(news.name);
        holder.description.setText(news.description);

        return row;
        }

    static class NewsHolder
    {
        TextView name;
        TextView description;
    }
}