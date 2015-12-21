package kr.co.kj_studio.exbuddy.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import kr.co.kj_studio.exbuddy.R;

public class SignUp4Activity extends BaseActivity {

    private ImageButton signupPhotoBtn1;
    private ImageButton signupPhotoBtn2;
    private ImageButton signupPhotoBtn3;
    private ImageButton signupPhotoBtn4;
    private Button startBtn;
    private ArrayList<ImageButton> galleryBtnArray = new ArrayList<ImageButton>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);
        setCustomActionbar();
        bindViews();
        setValues(R.string.signup4_title);
        setupEvents();
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.startBtn = (Button) findViewById(R.id.startBtn);
        this.signupPhotoBtn4 = (ImageButton) findViewById(R.id.signupPhotoBtn4);
        this.signupPhotoBtn3 = (ImageButton) findViewById(R.id.signupPhotoBtn3);
        this.signupPhotoBtn2 = (ImageButton) findViewById(R.id.signupPhotoBtn2);
        this.signupPhotoBtn1 = (ImageButton) findViewById(R.id.signupPhotoBtn1);
        setGalleryButtonsToArray();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
                finishAllActivities();
                startActivity(mIntent);
//                finish();
            }
        });

        setGalleryCallEvent();
    }

    private void setGalleryButtonsToArray() {
        galleryBtnArray.add(signupPhotoBtn1);
        galleryBtnArray.add(signupPhotoBtn2);
        galleryBtnArray.add(signupPhotoBtn3);
        galleryBtnArray.add(signupPhotoBtn4);
    }

    private void setGalleryCallEvent() {
        for (int i = 0; i < galleryBtnArray.size(); i++) {
            final int mBtnNum = i;
            galleryBtnArray.get(mBtnNum).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent();
                    mIntent.setType("image/*");
                    mIntent.setAction(Intent.ACTION_GET_CONTENT);
                    mIntent.putExtra("crop", "true");
                    mIntent.putExtra("aspectX", 1);
                    mIntent.putExtra("aspectY", 1);
                    mIntent.putExtra("outputX", 500);
                    mIntent.putExtra("outputY", 500);
                    try {
                        mIntent.putExtra("return-data", true);
                        startActivityForResult(Intent.createChooser(mIntent,
                                "Complete action using"), mBtnNum);
                    } catch (ActivityNotFoundException e) {
                        // Do nothing for now
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap image = extras.getParcelable("data");

            switch (requestCode) {
                case 0:
                    galleryBtnArray.get(0).setImageBitmap(image);
                    break;
                case 1:
                    galleryBtnArray.get(1).setImageBitmap(image);
                    break;
                case 2:
                    galleryBtnArray.get(2).setImageBitmap(image);
                    break;
                case 3:
                    galleryBtnArray.get(3).setImageBitmap(image);
                    break;
            }
        }
    }
}
