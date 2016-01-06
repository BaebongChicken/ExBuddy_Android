package kr.co.kj_studio.exbuddy.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import kr.co.kj_studio.exbuddy.R;
import kr.co.kj_studio.exbuddy.dataClass.GroupData;
import kr.co.kj_studio.exbuddy.dataClass.InterestedActsData;

public class EditGroupActivity extends BaseActivity {

    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;

    private android.widget.TextView categoryTxt;
    private android.widget.EditText titleEdt;
    private android.widget.LinearLayout subjectLayout;
    private android.widget.ImageView addSubjectBtn;
    private android.widget.EditText locationEdt;
    private android.widget.ToggleButton notConfirmedBtn;
    private android.widget.EditText descriptionEdt;
    private android.widget.Button nextBtn;

    GroupData mGroupData;
    InterestedActsData interestedActsData;
    ArrayList<String> subjectList = new ArrayList<>();

    static final int REQ_FOR_SUBJECT = 100;
    private EditText countEdt;
    private TextView actNameTxt;
    private TextView actLevelTxt;
    private TextView largeCategoryTxt;
    private TextView locationTxt;
    private TextView startDateTxt;
    private TextView startTimeTxt;

    private Calendar mStartDate = Calendar.getInstance();
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd (E)");
    private SimpleDateFormat mTimeFormat = new SimpleDateFormat("a h시 mm분");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);
        setCustomActionbar();
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        super.setValues();
        mGroupData = (GroupData) getIntent().getSerializableExtra("groupData");
        categoryTxt.setText(mGroupData.category);
        setDateText();
        mTitleTextView.setText(R.string.페이지_만들기);
    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeGroupData();
            }
        });

        addSubjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(EditGroupActivity.this, InterestedActsActivity.class);
                mIntent.putExtra("activityName", "EditGroupActivity");
                startActivityForResult(mIntent, REQ_FOR_SUBJECT);
            }
        });

        locationTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;
                try {
                    intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(EditGroupActivity.this);
                    startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });


        startDateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditGroupActivity.this, mDateSetListener, mStartDate.get(Calendar.YEAR), mStartDate.get(Calendar.MONTH), mStartDate.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        startTimeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(EditGroupActivity.this, mTimeSetListener, mStartDate.get(Calendar.HOUR_OF_DAY), mStartDate.get(Calendar.MINUTE), false).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_FOR_SUBJECT) {
            if (resultCode == RESULT_OK) {

                subjectLayout.setVisibility(View.VISIBLE);

                interestedActsData = (InterestedActsData) data.getSerializableExtra("interestedActsData");
                actNameTxt.setText(interestedActsData.actsName);
                actLevelTxt.setText(interestedActsData.actsLevel);

            }
        }
        else if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(EditGroupActivity.this, data);
                Log.i("CHO", "Place Selected: " + place.getName() + " / " + place.getLatLng().latitude + "," + place.getLatLng().longitude);

                locationTxt.setText(place.getName());
                mGroupData.location = place.getName().toString();
                mGroupData.geoLocation = place.getLatLng().latitude + "," + place.getLatLng().longitude;
                // Format the place's details and display them in the TextView.
//                mPlaceDetailsText.setText(formatPlaceDetails(getResources(), place.getName(),
//                        place.getId(), place.getAddress(), place.getPhoneNumber(),
//                        place.getWebsiteUri()));

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(EditGroupActivity.this, data);
                Log.e("CHO", "Error: Status = " + status.toString());
            } else if (resultCode == RESULT_CANCELED) {
                // Indicates that the activity closed before a selection was made. For example if
                // the user pressed the back button.
            }
        }
    }

    private void makeGroupData() {


        mGroupData.title = titleEdt.getText().toString();

        if (mGroupData.title.equals("")) {
            Toast.makeText(EditGroupActivity.this, R.string.모임명을_입력해주세요, Toast.LENGTH_SHORT).show();
            return;
        }

        if (interestedActsData.actsName == null || interestedActsData.actsLevel == null) {
            Toast.makeText(EditGroupActivity.this, R.string.운동종목을_입력해주세요, Toast.LENGTH_SHORT).show();
            return;

        }
        mGroupData.activities = interestedActsData.actsName + "/" + interestedActsData.actsLevel;

        if (mGroupData.geoLocation == null) {

            Toast.makeText(EditGroupActivity.this, R.string.장소를_입력해주세요, Toast.LENGTH_SHORT).show();
            return;
        }

//        mGroupData.
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.nextBtn = (Button) findViewById(R.id.nextBtn);
        this.descriptionEdt = (EditText) findViewById(R.id.descriptionEdt);
        this.countEdt = (EditText) findViewById(R.id.countEdt);
        this.startTimeTxt = (TextView) findViewById(R.id.startTimeTxt);
        this.startDateTxt = (TextView) findViewById(R.id.startDateTxt);
        this.notConfirmedBtn = (ToggleButton) findViewById(R.id.notConfirmedBtn);
        this.locationTxt = (TextView) findViewById(R.id.locationTxt);
        this.locationEdt = (EditText) findViewById(R.id.locationEdt);
        this.addSubjectBtn = (ImageView) findViewById(R.id.addSubjectBtn);
        this.subjectLayout = (LinearLayout) findViewById(R.id.subjectLayout);
        this.actLevelTxt = (TextView) findViewById(R.id.actLevelTxt);
        this.actNameTxt = (TextView) findViewById(R.id.actNameTxt);
        this.titleEdt = (EditText) findViewById(R.id.titleEdt);
        this.categoryTxt = (TextView) findViewById(R.id.categoryTxt);
        this.largeCategoryTxt = (TextView) findViewById(R.id.largeCategoryTxt);
    }


    public void setDateText() {
        startDateTxt.setText(mDateFormat.format(mStartDate.getTime()));
        startTimeTxt.setText(mTimeFormat.format(mStartDate.getTime()));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mStartDate.set(year, monthOfYear, dayOfMonth);
                    setDateText();
                }
            };


    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mStartDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    mStartDate.set(Calendar.MINUTE, minute);
                    setDateText();
                }
            };

}
