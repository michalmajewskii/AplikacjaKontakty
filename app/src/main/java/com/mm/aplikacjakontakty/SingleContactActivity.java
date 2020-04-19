package com.mm.aplikacjakontakty;



import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SingleContactActivity extends AppCompatActivity {

     private static final String TAG = "SingleContactActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singe_contact);

        getIncomingIntent();


    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("image_url")&& getIntent().hasExtra("image_name") && getIntent().hasExtra("image_phone_number") && getIntent().hasExtra("image_birthday")) {
            //String imageUrl= getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imagePhoneNumber = getIntent().getStringExtra("image_phone_number");
            String imageBirthday = getIntent().getStringExtra("image_birthday");



            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                int imageUrl = bundle.getInt("image_url");
                setImage(imageUrl, imageName, imagePhoneNumber,imageBirthday);
            }
        }

    }

    private void setImage(int imageUrl, String imageName, String imagePhoneNumber, String imageBirthday){

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        TextView phoneNumber=findViewById(R.id.textViewPhoneNumber);
        phoneNumber.setText("Phone Number: " + imagePhoneNumber);

        TextView birthday = findViewById(R.id.textViewBirthday);
        birthday.setText("Birthday: "+ imageBirthday);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(imageUrl);



    }


}
