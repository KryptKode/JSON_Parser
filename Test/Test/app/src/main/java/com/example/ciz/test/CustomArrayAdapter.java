package com.example.ciz.test;

/**
 * Created by Ciz on 3/15/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

    public class CustomArrayAdapter extends ArrayAdapter<Data> {

        List<Data> modelList;
        Context context;
        private LayoutInflater mInflater;

        // Constructors
        public CustomArrayAdapter(Context context,List<Data> objects) {
            super(context, 0, objects);
            this.context = context;
            this.mInflater = LayoutInflater.from(context);
            modelList = objects;
        }

        @Override
        public Data getItem(int position) {
            return modelList.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder vh;
            if (convertView == null) {
                View view = mInflater.inflate(R.layout.custom_row, parent, false);
                vh = ViewHolder.create((RelativeLayout) view);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            Data item = getItem(position);

            vh.textViewName.setText(item.getUserName());
            Picasso.with(getContext()).load(item.getImage()).placeholder(R.drawable.ic_profile_pic).error(R.drawable.ic_profile_pic).into(vh.imageView);
            return vh.rootView;
        }

        private static class ViewHolder {
            public final RelativeLayout rootView;
            public final ImageView imageView;
            public final TextView textViewName;

            private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName) {
                this.rootView = rootView;
                this.imageView = imageView;
                this.textViewName = textViewName;
            }

            public static ViewHolder create(RelativeLayout rootView) {
                ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
                TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
                return new ViewHolder(rootView, imageView, textViewName);
            }
        }
    
}
