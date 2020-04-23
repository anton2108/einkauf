package com.nikotin.menueinkauf;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static com.nikotin.menueinkauf.MainActivity.LOG_TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link startFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class startFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageView imgViewLogo;
    private ImageView imgViewMenu;
    private RetroController menuRetroController; //used for Retrofit
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public startFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment startFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static startFragment newInstance(String param1, String param2) {
        startFragment fragment = new startFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.start_fragment, container, false);
        imgViewLogo=(ImageView) v.findViewById(R.id.imageViewLogo);
        imgViewLogo.setOnClickListener(this); //DV: clicking reference to current view
        imgViewMenu=(ImageView) v.findViewById(R.id.image_view_menu);
        imgViewMenu.setOnClickListener(this);
        menuRetroController=new RetroController(); //DV: für Retrofit gebraucht
        //StartFragmentBinding binding = DataBindingUtil.bind(v);
        //binding.setFragment(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v==imgViewLogo) {
            //todo: DV-->put here the Code to react when sombody clicks the Menu Logo
            Toast.makeText(getActivity(), "bubu...bubu....", Toast.LENGTH_LONG).show();
            Log.d(LOG_TAG, "ImageLogo wurde geklickt");
            Picasso.with(getContext()).load("https://www.gutekueche.ch/upload/rezept/3608/spaghetti-bolognese.jpg").into(imgViewMenu);
            menuRetroController.start();
        }
        //DV: todo: wenn auf das Bild vom Menu geklickt wird nevigieren wir auf ein neues Fragment e.g. MenuDetail
        if (v==imgViewMenu){
            ((MainActivity) getActivity()).navigateTo(new menuFragment(),true);
        }

    }

}
