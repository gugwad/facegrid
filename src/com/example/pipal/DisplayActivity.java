package com.example.pipal;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;



public class DisplayActivity  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        int imageInt = getIntent().getIntExtra("Image Int", 0);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(imageInt);
    }
}
