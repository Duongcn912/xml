package com.example.admin.demonavigationdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DrawerCustomAdapter extends ArrayAdapter<ObjectDrawerItem>{
    Context context;
    int resource;
    List<ObjectDrawerItem> objectDrawerItemList;
    public DrawerCustomAdapter(@NonNull Context context, int resource, @NonNull List<ObjectDrawerItem> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objectDrawerItemList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if(convertView==null){
            convertView=inflater.inflate(resource,parent,false);
            ViewHolder viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
         ViewHolder viewHolder= (ViewHolder) convertView.getTag();
        ObjectDrawerItem obj=objectDrawerItemList.get(position);
        viewHolder.tvTitle.setText(obj.getName().toString().trim());
        viewHolder.icon.setImageResource(obj.getIcon());
        return convertView;
    }

    public static class ViewHolder{
        ImageButton icon;
        TextView tvTitle;
        public ViewHolder(View view){
            tvTitle=view.findViewById(R.id.tvTitle);
            icon=view.findViewById(R.id.imgNext);
        }
    }
}
