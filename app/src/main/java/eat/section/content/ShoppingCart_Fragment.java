package eat.section.content;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.cookforme.R;

    // TODO: Rename and change types and number of parameters
    public class ShoppingCart_Fragment extends Fragment {
        public ShoppingCart_Fragment() {
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
            return inflater.inflate(R.layout.fragment_shopping_cart_, container, false);
        }
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
        }
        @Override
        public void onDetach() {
            super.onDetach();
        }
    }
