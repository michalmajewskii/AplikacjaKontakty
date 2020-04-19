package com.mm.aplikacjakontakty;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements List_row.OnListFragmentClickInteractionListener {
    private OurData.Contact currentContact;
    private final String CURRENT_TASK_KEY = "CurrentTask";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List_row fragment = new List_row();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//       fragmentTransaction.add(R.id.placeholder, fragment);
//
//        fragmentTransaction.commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "Click!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), AddContactActivity.class);
                startActivityForResult(intent, RESULT_OK);



            }
        });


    }
    @Override
    protected void onResume() {

        super.onResume();
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            if(currentContact != null) {
                SingleContactFragment singleContactFragment = ((SingleContactFragment)getSupportFragmentManager().findFragmentById(R.id.displayFragment));
                if(singleContactFragment != null){
                    singleContactFragment.displayTask(currentContact);
                }
            }

        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
         // Toast.makeText(this, "someData", Toast.LENGTH_SHORT).show();
     ((List_row)Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.MAlistRecycler))).notifyDataChange();



        }

    }


    @Override
    public void OnListFragmentClickInteraction(OurData.Contact contact, int position) {
        currentContact= contact;
      //  Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

           SingleContactFragment singleContactFragment = ((SingleContactFragment)getSupportFragmentManager().findFragmentById(R.id.displayFragment));
            if(singleContactFragment != null){
                singleContactFragment.displayTask(contact);
            }
        }else{

//              //  Toast.makeText(v.getContext(),OurData.names[position],Toast.LENGTH_SHORT).show();
//
                Intent intent = new Intent(this, SingleContactActivity.class);
                OurData.Contact contact2= OurData.NAMES.get(position);
                intent.putExtra("image_name", contact.name);
                intent.putExtra("image_url",contact.picture);
                intent.putExtra("image_phone_number", contact.phonenumber);
                intent.putExtra("image_birthday", contact.birthday);

             startActivity(intent);
        }

    }


}
