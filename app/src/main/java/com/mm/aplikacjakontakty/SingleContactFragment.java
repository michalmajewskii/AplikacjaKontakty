package com.mm.aplikacjakontakty;
import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class SingleContactFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIncomingIntent();

    }


    public void displayTask(OurData.Contact contact){
        FragmentActivity activity=getActivity();
        (activity.findViewById(R.id.displayFragment)).setVisibility(View.VISIBLE);
        setImage(contact.picture, contact.name, contact.phonenumber,contact.birthday);

    }


@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_single_contact, container, false);

        return view;



    }
    private void getIncomingIntent(){

        if(getActivity().getIntent().hasExtra("image_url")&& getActivity().getIntent().hasExtra("image_name") && getActivity().getIntent().hasExtra("image_phone_number") && getActivity().getIntent().hasExtra("image_birthday")) {
            String imageUrl= getActivity().getIntent().getStringExtra("image_url");
            String imageName = getActivity().getIntent().getStringExtra("image_name");
            String imagePhoneNumber = getActivity().getIntent().getStringExtra("image_phone_number");
            String imageBirthday = getActivity().getIntent().getStringExtra("image_birthday");



            Bundle bundle = getActivity().getIntent().getExtras();
            if (bundle != null) {
                int imageUrl2 = bundle.getInt("image_url");
                setImage(imageUrl2, imageName, imagePhoneNumber,imageBirthday);
            }
        }

    }


    private void setImage(int imageUrl, String imageName, String imagePhoneNumber, String imageBirthday){

        TextView name = getActivity().findViewById(R.id.image_description2);
        name.setText(imageName);

        TextView phoneNumber=getActivity().findViewById(R.id.textViewPhoneNumber2);
        phoneNumber.setText("Phone Number: " + imagePhoneNumber);

        TextView birthday = getActivity().findViewById(R.id.textViewBirthday2);
        birthday.setText("Birthday: "+ imageBirthday);

        ImageView image = getActivity().findViewById(R.id.image2);
        image.setImageResource(imageUrl);



    }






}
