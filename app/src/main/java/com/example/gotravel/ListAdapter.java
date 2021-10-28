package com.example.gotravel;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] typeOfPlace;
    private final Integer[] imageId;
    private final String id;

    public ListAdapter(Activity context,String id, String[] typeOfPlace, Integer[] imageId) {
        super(context, R.layout.activity_entertainment_detail, typeOfPlace);
        this.id=id;
        this.context = context;
        this.typeOfPlace = typeOfPlace;
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_layout, null, true);
        TextView texTitle = rowView.findViewById(R.id.text);
        //ImageView imageView = rowView.findViewById(R.id.img);
        texTitle.setText(typeOfPlace[position]);
        //imageView.setImageResource(imageId[0]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
//                intent=new Intent(context,EntertainmentDetailActivity.class);
//                intent.putExtra("key",typeOfPlace[position]);
                switch (id)
                {
                    case "hotel":
                        intent = new Intent(context, HotelDetailActivity.class);
                        intent.putExtra("key", typeOfPlace[position]);
                        context.startActivity(intent);
                        break;
                    case "restaurant":
                        intent = new Intent(context, RestaurantDetailActivity.class);
                        intent.putExtra("key", typeOfPlace[position]);
                        context.startActivity(intent);
                        break;
                    case "entertainment":
                        intent = new Intent(context, EntertainmentDetailActivity.class);
                        intent.putExtra("key", typeOfPlace[position]);
                        context.startActivity(intent);
                        break;
                    case "temple":
                        intent = new Intent(context,TempleDetailActivity.class);
                        intent.putExtra("key", typeOfPlace[position]);
                        context.startActivity(intent);
                        break;
                    case "sightseeing":
                        intent = new Intent(context,SightseeingDetailActivity.class);
                        intent.putExtra("key", typeOfPlace[position]);
                        context.startActivity(intent);
                        break;
                    case "local_food":
                        intent = new Intent(context,LocalFoodDetailActivity.class);
                        intent.putExtra("key", typeOfPlace[position]);
                        context.startActivity(intent);
                        break;
                    default:
                        break;
                }
//                Intent intent = new Intent(context, RestaurantDetailActivity.class);
//                intent.putExtra("key", typeOfPlace[position]);
//                context.startActivity(intent);
            }
        });
        return rowView;
    }
}
