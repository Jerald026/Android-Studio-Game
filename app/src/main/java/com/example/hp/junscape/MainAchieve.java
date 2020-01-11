package com.example.hp.junscape;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.hp.junscape.ApplicationClass.trashes;

public class MainAchieve extends AppCompatActivity implements TrashAdapter.ItemClicked {

    Button btnCarInfo, btnOwnerInfo;
    ImageView ivMake;
    TextView tvModel, tvName, tvTel;
    FragmentManager fragmentManager;
    Fragment buttonFrag, listFrag, carInfoFrag, ownerInfoFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_achieve);

        btnCarInfo = (Button) findViewById(R.id.btnCarInfo);
        btnOwnerInfo = (Button) findViewById(R.id.btnOwnerInfo);
        ivMake = (ImageView) findViewById(R.id.ivMake);
        tvModel = (TextView) findViewById(R.id.tvModel);
        tvName = (TextView) findViewById(R.id.tvName);
        tvTel = (TextView) findViewById(R.id.tvTel);


        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag);


        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carInfoFrag)
                .hide(ownerInfoFrag)
                .commit();

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(ownerInfoFrag)
                        .commit();

            }
        });

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(ownerInfoFrag)
                        .commit();

            }
        });

        onItemClicked(0);
    }


    // SETTING IMAGE CARDVIEW
    @Override
    public void onItemClicked(int index) {


        tvName.setText(trashes.get(index).getdispose_detail());
        tvModel.setText(trashes.get(index).gettrash_name());
        tvTel.setText(trashes.get(index).getdispose_info());


        if (trashes.get(index).gettrash_name().equals("banana peel")) {
            ivMake.setImageResource(R.drawable.bbb);
        } else if (trashes.get(index).gettrash_name().equals("leaf")) {
            ivMake.setImageResource(R.drawable.leaf2);
        } else if (trashes.get(index).gettrash_name().equals("milk box")) {
            ivMake.setImageResource(R.drawable.milkkk);
        } else if (trashes.get(index).gettrash_name().equals("crumpled paper")) {
            ivMake.setImageResource(R.drawable.paper);
        } else if (trashes.get(index).gettrash_name().equals("soda can")) {
            ivMake.setImageResource(R.drawable.can);
        } else if (trashes.get(index).gettrash_name().equals("chips")) {
            ivMake.setImageResource(R.drawable.chips2);
        } else if (trashes.get(index).gettrash_name().equals("tire")) {
            ivMake.setImageResource(R.drawable.tire2);
        } else {
            ivMake.setImageResource(R.drawable.fish);
        }
    }
}