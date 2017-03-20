package com.example.ciz.test;

/**
 * Created by Ciz on 3/15/2017.
 */
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfileScreen extends AppCompatActivity {
    String username, url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Bitmap bmp = this.getIntent().getParcelableExtra("BitmapImage");
        String gURL = extras.getString("gURL");
        String uName = extras.getString("uName");
        username = uName;
        url = gURL;
        String imgURL = extras.getString("imgURL");

        final TextView textView = (TextView)
                findViewById(R.id.username_profile_screen);
        textView.setText("@" + uName);
        final TextView url = (TextView)
                findViewById(R.id.profileURL);
        final ImageView img = (ImageView)
                findViewById(R.id.profilePic_profileScreen);
       //img.setImageBitmap(bmp);
        Picasso.with(this).load(imgURL).placeholder(R.drawable.ic_profile_pic).error(R.drawable.ic_profile_pic).into(img);

        Spanned Text = Html.fromHtml("Click on this link to see profile on GitHub <br />" +
                "<a href='" + gURL + "'>" + gURL + "</a>");

        url.setMovementMethod(LinkMovementMethod.getInstance());
        url.setText(Text);
    }

public void onClick(View v){
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer\n Username: @" + username +"\n GitHub URL:"+ url + ".");
    sendIntent.setType("text/plain");
    startActivity(sendIntent);
}


}