package in.maidul.ecomercegarments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import in.maidul.ecomercegarments.R;

public class FlashPage2 extends AppCompatActivity {

    private AppCompatButton btn_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_page2);

        btn_skip = findViewById(R.id.btn_skip);

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashPage2.this, FlashPage3.class);
                startActivity(intent);
            }
        });

    }
}