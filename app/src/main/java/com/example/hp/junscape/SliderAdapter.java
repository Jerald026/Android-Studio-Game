package com.example.hp.junscape;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;


public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.fingergif,
            0,
            0
    };

    public int[] bio_gif = {
            0,
            R.drawable.biogif,
            0
    };

    public int[] nonbio_gif = {
            0,
            R.drawable.nonbiogif,
            0
    };

    public int[] plus_gif = {
            0,
            0,
            R.drawable.plusgif
    };

    public int[] bomb_gif = {
            0,
            0,
            R.drawable.bombaf
    };

    public int[] heart_gif = {
            0,
            0,
            R.drawable.heartgifff
    };

    public int[] slide_headings = {
            R.drawable.howtoplayyy,
            R.drawable.segregate2,
            R.drawable.powerup2
    };

    public int[] slide_desc = {
            R.drawable.ins1,
            R.drawable.ins2,
            0
    };

    public int[] ins_over = {
            0,
            0,
            R.drawable.ins5
    };

    public int[] ins_life = {
            0,
            0,
            R.drawable.ins4
    };

    public int[] ins_points = {
            0,
            0,
            R.drawable.ins3
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        GifImageView slideImageView = (GifImageView) view.findViewById(R.id.slide_image);
        GifImageView bioGif = (GifImageView) view.findViewById(R.id.bio_gif);
        GifImageView nonBioGif = (GifImageView) view.findViewById(R.id.nonbio_gif);
        GifImageView plus = (GifImageView) view.findViewById(R.id.plus_gif);
        GifImageView bomb = (GifImageView) view.findViewById(R.id.bomb_gif);
        GifImageView heart = (GifImageView) view.findViewById(R.id.heart_gif);
        ImageView slideHeading = (ImageView) view.findViewById(R.id.slide_heading);
        ImageView slideDescription = (ImageView) view.findViewById(R.id.slide_desc);
        ImageView life = (ImageView) view.findViewById(R.id.ins_life);
        ImageView points = (ImageView) view.findViewById(R.id.ins_points);
        ImageView over = (ImageView) view.findViewById(R.id.ins_over);


        slideImageView.setImageResource(slide_images[position]);
        bioGif.setImageResource(bio_gif[position]);
        nonBioGif.setImageResource(nonbio_gif[position]);
        plus.setImageResource(plus_gif[position]);
        bomb.setImageResource(bomb_gif[position]);
        heart.setImageResource(heart_gif[position]);
        slideHeading.setImageResource(slide_headings[position]);
        slideDescription.setImageResource(slide_desc[position]);
        life.setImageResource(ins_life[position]);
        points.setImageResource(ins_points[position]);
        over.setImageResource(ins_over[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }



}
