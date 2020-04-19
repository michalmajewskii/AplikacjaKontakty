package com.mm.aplikacjakontakty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;
import java.util.jar.Attributes;

import static android.app.Activity.RESULT_OK;


public class List_row extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";

    private MyAdapter mRecyclerViewAdapter;
    public OnListFragmentClickInteractionListener mListener;

    public static List_row newInstance(int columnCount) {
        List_row fragment = new List_row();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.rv_fragment_list, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecycler);
        MyAdapter myAdapter= new MyAdapter(mListener);
        recyclerView.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentClickInteractionListener) {
            mListener = (OnListFragmentClickInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void notifyDataChange(){
        mRecyclerViewAdapter.notifyDataSetChanged();
    }


public interface OnListFragmentClickInteractionListener {
    void OnListFragmentClickInteraction(OurData.Contact contact, int position);

}

}
