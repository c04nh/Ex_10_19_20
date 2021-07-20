package kr.hs.emirim.w2038.ex_10_19_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.btn_call);
        Button btnHome = findViewById(R.id.btn_homepage);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnSMS = findViewById(R.id.btn_sms);
        Button btnPhoto = findViewById(R.id.btn_photo);

        btnCall.setOnClickListener(btnListener);
        btnHome.setOnClickListener(btnListener);
        btnMap.setOnClickListener(btnListener);
        btnSearch.setOnClickListener(btnListener);
        btnSMS.setOnClickListener(btnListener);
        btnPhoto.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            Uri uri = null;
            switch (v.getId()){
                case R.id.btn_call:
                    uri = Uri.parse("tel:01033337777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_homepage:
                    uri = Uri.parse("https://www.e-mirim.hs.kr/main.do");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    uri = Uri.parse("https://maps.google.co.kr/maps?q="+ 37.46670485990856 + "," + 126.93284362495359 + "&z = 15");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "미림여자정보과학고등학교");
                    break;
                case R.id.btn_sms:
                    uri = Uri.parse("smsto:" + Uri.encode("010-2657-7498"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "떡볶이 사줘");
                    intent.setData(uri);
                    break;
                case R.id.btn_photo:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}