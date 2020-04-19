package com.mm.aplikacjakontakty;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter{

    Context context;

    private List_row.OnListFragmentClickInteractionListener mListener;

    public MyAdapter(List_row.OnListFragmentClickInteractionListener listener){
        mListener=listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_row,parent,false);

        return  new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        ((ListViewHolder)holder).bindView(position);

       final OurData.Contact current_contact = OurData.NAMES.get(position);
        ((ListViewHolder) holder).setListeners();








////////////////////////////////////////////////////////////////////////////////////////////////////////
        ((ListViewHolder) holder).mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (null !=mListener){
                    mListener.OnListFragmentClickInteraction(current_contact,position);

                }



//                Context mContext = v.getContext();
//              //  Toast.makeText(v.getContext(),OurData.names[position],Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(v.getContext(), SingleContactActivity.class);
//                OurData.Contact contact= OurData.NAMES.get(position);
//                intent.putExtra("image_name", contact.name);
//                intent.putExtra("image_url",contact.picture);
//                intent.putExtra("image_phone_number", contact.phonenumber);
//                intent.putExtra("image_birthday", contact.birthday);
//
//                mContext.startActivity(intent);

            }
        });


((ListViewHolder) holder).mView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(final View v) {
        OurData.Contact contact= OurData.NAMES.get(position);

        AlertDialog dialog = new AlertDialog.Builder(v.getContext()).setMessage("Call to " + contact.name + " ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(v,"Calling...", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();


        return false;
    }
});




////////////////////////////////////////////////////////////////////////////////////////////////////
//        int currentPosition = position;
//        OurData.Contact contactdelate = OurData.NAMES.get(position);






    }




    @Override
    public int getItemCount() {
        return OurData.NAMES.size();
    }



    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mItemText;
        private ImageView mItemImage;
        private ImageButton mItemTrash;
        LinearLayout parentLayout;
        public View mView;
        private int position;



        public ListViewHolder(View itemView) {
            super(itemView);
            mItemText= (TextView) itemView.findViewById(R.id.name);
            mItemImage=(ImageView) itemView.findViewById(R.id.image);
            mItemTrash=(ImageButton) itemView.findViewById(R.id.trash);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            mView= itemView;




        }
        public void bindView (int position){
        //   mItemText.setText(OurData.names[position]);


//            OurData.Contact firstName= OurData.NAMES.get(position);
//            String tested= firstName.toString();

            OurData.Contact contact= OurData.NAMES.get(position);
            mItemText.setText(contact.name);
            this.position=position;


           // mItemText.setText(tested);

            //int number = (int)(OurData.pictures.length * Math.random());
           mItemImage.setImageResource(contact.picture);

        }


        public void setListeners(){
            mItemTrash.setOnClickListener(ListViewHolder.this);
        }


        @Override
        public void onClick(View v) {


            AlertDialog dialog = new AlertDialog.Builder(v.getContext()).setMessage("Delete selected contact ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    removeItem(position);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();






        }
    }
        public void removeItem(int position){

        OurData.NAMES.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position,OurData.NAMES.size());
        notifyDataSetChanged();
        }


}




