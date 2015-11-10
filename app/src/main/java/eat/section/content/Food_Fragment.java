package eat.section.content;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.john.cookforme.R;

/**
 * Created by John on 10/2/2015.
 */
public class Food_Fragment extends Fragment implements View.OnClickListener{
    public Food_Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_food, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.food_1);
        imageView.setOnClickListener(this);

        return view;

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
    public void onClick(View view){
        switch (view.getId()){
            case R.id.food_1:
                specFood_Fragment fragment = new specFood_Fragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.food_1_fragholder, fragment);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.food_2:
               break;
        }

    }  **/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.food_1:
                Intent intent = new Intent(getActivity(), specFood_page.class);
                startActivity(intent);
        }
    }
}
