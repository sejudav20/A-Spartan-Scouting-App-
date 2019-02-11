package com.example.davin.scoutingapp2019;

import java.util.EnumMap;
import java.util.Map;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;



public class Scouter extends AppCompatActivity {


    // All the UI views needed
    static EditText teamNumberView;
    static Spinner robotStartPosition;
    static CheckBox sandstormRocketHatch;
    static CheckBox sandstormCrossedHabLine;
    static CheckBox sandstormCargoShipHatches;
    static CheckBox sandstormRocketShipBalls;
    static CheckBox sandstormCargoShipBalls;

    static NumberPicker cargoShipBallCount;
   static NumberPicker cargoShipHatchPanelCount;
    static TextView rocketNumbers;
    static TextView cargoNumbers;


   static NumberPicker rocketBallCount;
    static NumberPicker rocketHatchPanelCount;

    static Spinner rocketRole;

    static Spinner climbingRole;
    static TextInputLayout overallRole;
    static TextInputLayout otherComments;
    static Button buttonQR;
    static ImageView image;
static String position;
    static String robotRocketRole;
    static String climberRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouter);

        teamNumberView=findViewById(R.id.editText);
      robotStartPosition= findViewById(R.id.spinner);
        sandstormRocketHatch=findViewById(R.id.checkBox6);
         sandstormCrossedHabLine=findViewById(R.id.checkBox2);
        sandstormCargoShipHatches=findViewById(R.id.checkBox3);
         sandstormRocketShipBalls =findViewById(R.id.checkBox5);


      cargoShipBallCount=findViewById(R.id.CargoShipBallCount);
     cargoShipHatchPanelCount=findViewById(R.id.cargoShipHatchPanelCount);

        sandstormCargoShipBalls=findViewById(R.id.checkBox4);

        rocketBallCount=findViewById(R.id.rocketShipBallCount);
         rocketHatchPanelCount=findViewById(R.id.rocketShipHatchPanelCount3);

        rocketRole= findViewById(R.id.RocketRole);

        climbingRole= findViewById(R.id.ClimbingRoles);
        overallRole=findViewById(R.id.Role);
        otherComments=findViewById(R.id.Other);
        buttonQR=findViewById(R.id.CreateQR);
        image=findViewById(R.id.imageView2);


        String[] nums = new String[21];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.toString(i);
        }
        cargoShipHatchPanelCount.setDisplayedValues(nums);
        cargoShipBallCount.setDisplayedValues(nums);
        rocketHatchPanelCount.setDisplayedValues(nums);
        rocketBallCount.setDisplayedValues(nums);
        cargoShipHatchPanelCount.setMaxValue(20);
        cargoShipBallCount.setMaxValue(20);
        rocketBallCount.setMaxValue(20);
rocketHatchPanelCount.setMaxValue(20);
        cargoShipHatchPanelCount.setMinValue(0);
        cargoShipBallCount.setMinValue(0);
        rocketBallCount.setMinValue(0);
        rocketHatchPanelCount.setMinValue(0);






























        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        robotStartPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Scouter.position= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        climbingRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Scouter.climberRole= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        rocketRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Scouter.robotRocketRole= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



        buttonQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=createString();

                Bitmap bitmap;
                try {

                    bitmap=encodeAsBitmap(o,BarcodeFormat.QR_CODE, 600, 300);
                    image.setImageBitmap(bitmap);
                    image.setVisibility(View.VISIBLE);
                } catch (WriterException e) {
                    e.printStackTrace();
                }


            }
        });




    }


public static String createString(){
String sandstorm=sandstormCrossedHabLine.isChecked()+" "+sandstormCargoShipBalls.isChecked()+" "+sandstormCargoShipHatches.isChecked()+" "+sandstormRocketShipBalls.isChecked()+" "+sandstormRocketHatch.isChecked();
String teleop= cargoShipBallCount.getValue()+"|"+cargoShipHatchPanelCount.getValue()+"|"+rocketBallCount.getValue()+"|"+rocketHatchPanelCount.getValue();

return teamNumberView.getText()+"|"+ position+"|"+sandstorm+"|"+teleop+"|"+robotRocketRole+"|"+climberRole+"|"+overallRole.getEditText().getText()+"| "+otherComments.getEditText().getText();

}

    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;

    Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int img_width, int img_height) throws WriterException {
        String contentsToEncode = contents;
        if (contentsToEncode == null) {
            return null;
        }
        Map<EncodeHintType, Object> hints = null;
        String encoding = guessAppropriateEncoding(contentsToEncode);
        if (encoding != null) {
            hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result;
        try {
            result = writer.encode(contentsToEncode, format, img_width, img_height, hints);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }







}
