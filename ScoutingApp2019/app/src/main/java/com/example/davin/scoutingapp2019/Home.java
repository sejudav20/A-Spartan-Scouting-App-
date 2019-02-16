package com.example.davin.scoutingapp2019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import static com.example.davin.scoutingapp2019.DataDisplay.NEW_WORD_ACTIVITY_REQUEST_CODE;

public class Home extends AppCompatActivity {


    ImageView imgView;
    Team newTeam;
    TextView qrstring;
    private TeamViewModel teamViewModel = DataDisplay.teamViewModel;

    @Override


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getIntent().getIntExtra("pass",0)==9){

            teamViewModel.insert(newTeam);

        }


Log.d("View","created");
        qrstring = findViewById(R.id.txtcontent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgView = findViewById(R.id.imageView);


        Button newButton = findViewById(R.id.newButton);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Scouter.class);
                startActivity(intent);

            }
        });

        Button scanButton = findViewById(R.id.ScanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Me", "start process");
                dispatchTakePictureIntent();

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, DataDisplay.class);
                startActivity(intent);
            }
        });

    }

    final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Log.d("Me", "Thinking its working");
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            Log.d("Me", "Hi ");
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("View", "I entered the wrong onActivityResult");


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Log.d("Me", "On Activity result ");

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgView.setImageBitmap(imageBitmap);
            BarcodeDetector detector =
                    new BarcodeDetector.Builder(getApplicationContext())
                            .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                            .build();
            if (!detector.isOperational()) {
                qrstring.setText("Could not set up the detector!");
                return;
            }
            Frame frame = new Frame.Builder().setBitmap(imageBitmap).build();
            SparseArray<Barcode> barcodes = detector.detect(frame);
            Barcode thisCode = barcodes.valueAt(0);
            qrstring.setText(thisCode.rawValue);



            Log.d("View", "got data: " +thisCode.rawValue );
            Destring destring = new Destring(thisCode.rawValue);
            newTeam = new Team(destring.getTeamNumber(), destring.getPosition(), destring.getSandstorm("hab line"), destring.getSandstorm("cargo balls"), destring.getSandstorm("cargo hatches"), destring.getSandstorm("rocket balls"), destring.getSandstorm("rocket hatches"), destring.getTeleop("cargo balls"), destring.getTeleop("cargo hatches"), destring.getTeleop("rocket balls"), destring.getTeleop("rocket hatches"), destring.getRocketRole(), destring.getClimberRole(), destring.getOverallRole(), destring.getOtherComments());




            Log.d("View", "inserted new team: " + newTeam.getTeamNumber());

            Intent in=new Intent(this,DataDisplay.class);
            in.putExtra("type",7);


            Log.d("View","Changed activities");
            startActivity(in);
// teamViewModel.insert(newTeam);



            /*
            Intent intent = new Intent(Home.this, DataDisplay.class);

            intent.putExtra("str",thisCode.rawValue);

            Log.d("View","Starting launch of new Activity with  "+ thisCode.rawValue);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
*/


        } else if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Log.d("View", "reached data display " + requestCode + " result:" + resultCode);

            Destring destring = new Destring(data.getStringExtra("str"));
            Team newTeam = new Team(destring.getTeamNumber(), destring.getPosition(), destring.getSandstorm("hab line"), destring.getSandstorm("cargo balls"), destring.getSandstorm("cargo hatches"), destring.getSandstorm("rocket balls"), destring.getSandstorm("rocket hatches"), destring.getTeleop("cargo balls"), destring.getTeleop("cargo hatches"), destring.getTeleop("rocket balls"), destring.getTeleop("rocket hatches"), destring.getRocketRole(), destring.getClimberRole(), destring.getOverallRole(), destring.getOtherComments());

            Log.d("View", "inserted new team: " + newTeam.getTeamNumber());
            teamViewModel.insert(newTeam);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
