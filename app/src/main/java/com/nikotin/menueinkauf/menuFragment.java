package com.nikotin.menueinkauf;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.nikotin.menueinkauf.MainActivity.LOG_TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menuFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imgViewMenu;
    private TextView txtViewMenuTitle;
    private TextView txtViewMenuKueche;
    private TextView txtViewMenuArt;
    private TextView txtViewMenuZutaten;
    private MenuNormal mn;

    public menuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static menuFragment newInstance(String param1, String param2) {
        menuFragment fragment = new menuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Menu Fragment is started");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.menu_fragment, container, false);
        imgViewMenu=(ImageView) v.findViewById(R.id.image_view_menu);
        imgViewMenu.setOnClickListener(this);
        txtViewMenuTitle=(TextView) v.findViewById(R.id.txtViewMenueTitle);
        txtViewMenuKueche=(TextView) v.findViewById(R.id.txtViewMenueKueche);
        txtViewMenuArt=(TextView) v.findViewById(R.id.txtViewMenueArt);
        txtViewMenuZutaten=(TextView) v.findViewById(R.id.txtViewMenueZutaten);
        mn=((MainActivity) getActivity()).getSelectedMenu();
        fillMenu();
        return v;
    }

    //DV: View will be filled with information stored in the selectedMenu Object from MainActivity
    public void fillMenu(){
        Picasso.with(getContext()).load(mn.getBildUrl()).into(imgViewMenu);
        txtViewMenuTitle.setText(mn.getName());
        txtViewMenuKueche.setText("Küche: "+mn.getKueche());
        txtViewMenuArt.setText("Art: "+mn.getArt());
        txtViewMenuZutaten.setText("Zutaten für "+mn.getAnzPersonen().toString()+" Personen: \n"
                +mn.getZutaten());
    }

    @Override
    public void onClick(View v) {
        //todo: falls noch auf das Bild geklickt werden soll
    }
}
