package com.example.navjeevan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String MSG ="com.navjeevan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ArrayList<ImageSlidesModel> autoImageList = new ArrayList<>();

        // find and initialize ImageSlider
        AutoImageSlider autoImageSlider = findViewById(R.id.autoImageSlider);

        // add some images or titles (text) inside the imagesArrayList
        autoImageList.add(new ImageSlidesModel(R.drawable.hp6));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp4));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp1));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp6));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp1));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp4));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp1));
        autoImageList.add(new ImageSlidesModel(R.drawable.hp4));

        // set the added images inside the AutoImageSlider
        autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void login(View view){
        //Intent helps to provide communication between 2 activities
        Intent intent = new Intent (this, AfterLogIn.class );
        EditText Username = findViewById(R.id.email2);
        EditText Password = findViewById(R.id.password);
        String message = "Namaste,"+ Username.getText().toString();
        //+ "&" + password.getText().toString();
        intent.putExtra(MSG, message);
        startActivity(intent);

    }
}