package com.mm.aplikacjakontakty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddContactActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

//        EditText nameEditTxt = (EditText) findViewById(R.id.editName);
//        EditText surnameEditTxt = findViewById(R.id.editSurname);
     //  EditText birthdayEditTxt = findViewById(R.id.editBirthdate);
//        EditText phoneNumberEditTxt = findViewById(R.id.editPhonenumber);
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);

//         String nameEdit = nameEditTxt.getText().toString();
//         String surnameEdit = surnameEditTxt.getText().toString();
          // String birthdayEdit = birthdayEditTxt.getText().toString();
//         String phoneNumberEdit = phoneNumberEditTxt.getText().toString();

//
//        nameEditTxt.requestFocus();
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(nameEditTxt, InputMethodManager.SHOW_IMPLICIT);






        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEditTxt = (EditText) findViewById(R.id.editName);
                EditText surnameEditTxt = findViewById(R.id.editSurname);
                EditText birthdayEditTxt = findViewById(R.id.editBirthdate);
                EditText phoneNumberEditTxt = findViewById(R.id.editPhonenumber);


                String nameEdit = nameEditTxt.getText().toString();
                String surnameEdit = surnameEditTxt.getText().toString();
                String birthdayEdit = birthdayEditTxt.getText().toString();
                String phoneNumberEdit = phoneNumberEditTxt.getText().toString();
                int number = (int) (OurData.pictures.length * Math.random());


                if (nameEdit.isEmpty() || surnameEdit.isEmpty() || birthdayEdit.isEmpty() || phoneNumberEdit.isEmpty()) {
                    //TODO dane fill all inputs
                    Toast.makeText(v.getContext(),"Fill all inputs", Toast.LENGTH_SHORT).show();

                    OurData.addContact(new OurData.Contact(getString(R.string.default_title), getString(R.string.default_title), getString(R.string.default_title), getString(R.string.default_title), OurData.pictures[number]));
                } else {
                    if (phoneNumberEdit.length() < 9) {

                        //TODO invalid phona number
                        Toast.makeText(v.getContext(),"Invalid Phone Number", Toast.LENGTH_SHORT).show();

                    } else {



                        OurData.addContact(new OurData.Contact(nameEdit, surnameEdit, birthdayEdit, phoneNumberEdit, OurData.pictures[number]));
                        setResult(RESULT_OK);
                        finish();


                    }
                }


            }

        });





}






}




