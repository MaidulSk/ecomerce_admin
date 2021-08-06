package in.maidul.ecomercegarments.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.maidul.ecomercegarments.R;
import in.maidul.ecomercegarments.activity.ProductAdd;


public class ProductsPage extends Fragment {

    private ImageView iv_add_product;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);
        iv_add_product = view.findViewById(R.id.iv_add_product);

        iv_add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductAdd.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return view;

    }
}