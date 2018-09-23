package com.jacobjacob.colorswitch2;

import android.app.usage.UsageEvents;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SeekBar sbGreen;
    SeekBar sbRed;
    SeekBar modes1;
    SeekBar sbBlue;
    SeekBar Time;
    TextView Mode;
    TextView Steps;
    TextView Red;
    TextView Green;
    TextView Blue;
    TextView Hex;
    TextView XWert;
    TextView YWert;
    TextView XWert1;
    TextView YWert1;
    ImageView imgCircle;
    Paint paint;
    String hex;
    public int green;
    public int red;
    public int modes;
    public int blue;
    public int time;
    public int r1;
    public int g1;
    public int b1;
    //public  hex;
    private RelativeLayout layout;
    //
    public int colorRed = 0;
    public int colorGreen = colorRed + 85;
    public int colorBlue = colorGreen + 85;
    public int xvalue;
    public double cR = 0;
    public double cG = 0;
    public double cB = 0;
    public int Red1 = 255;
    public int Green1 = 0;
    public int Blue1 = 0;
    public float xvalue1;
    public float yvalue1;
    public float touchX;
    public float touchY;
    public float xmouse;
    public float ymouse;
    public float xscreen;
    public float yscreen;
    public float Circleradius;
    public float xCircle;
    public float yCircle;
    public float xCircle2;
    public float yCircle2;
    public float xCircle1;
    public float yCircle1;
    public float yCircle5;
    public float xCircle5;
    public float yCircle4;
    public float xCircle4;
    public float yCircle3;
    public float xCircle3;
    public float angle;
    public float Wert;
    Boolean bool1;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        xscreen = size.x;
        yscreen = size.y;

        bool1 = true;

        layout = findViewById(R.id.layout1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        Time = findViewById(R.id.Time);
        XWert = findViewById(R.id.XWert);
        YWert = findViewById(R.id.YWert);
        XWert1 = findViewById(R.id.XWert1);
        YWert1 = findViewById(R.id.YWert1);
        imgCircle = findViewById(R.id.imageView);

        sbRed.setProgress(128);
        sbGreen.setProgress(128);
        sbBlue.setProgress(128);
        Time.setProgress(128);

        sbRed.getThumb().setColorFilter(Color.rgb(255,0,0), PorterDuff.Mode.SCREEN);
        sbGreen.getThumb().setColorFilter(Color.rgb(0,255,0), PorterDuff.Mode.SCREEN);
        sbBlue.getThumb().setColorFilter(Color.rgb(0,0,255), PorterDuff.Mode.SCREEN);
        sbRed.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.rgb(255,0,0), PorterDuff.Mode.MULTIPLY));
        sbGreen.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.rgb(0,255,0), PorterDuff.Mode.MULTIPLY));
        sbBlue.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.rgb(0,0,255), PorterDuff.Mode.MULTIPLY));

        colorRed = 128;
        colorGreen = 128;
        colorBlue = 128;

        red = 128;
        green = 128;
        blue = 128;

        r1 = 255 - red;
        g1 = 255 - green;
        b1 = 255 - blue;

        layout.setBackgroundColor(Color.argb(255, red, green, blue));

        modes1 = findViewById(R.id.modes1);
        Mode = findViewById(R.id.Mode);
        Steps = findViewById(R.id.Steps);
        Red = findViewById(R.id.Red);
        Green = findViewById(R.id.Green);
        Blue = findViewById(R.id.Blue);

        Hex = findViewById(R.id.Hex);

        method2();

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red = i;
                method();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }@Override public void onStopTrackingTouch(SeekBar seekBar) { }});

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                green = i;
                method();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }@Override public void onStopTrackingTouch(SeekBar seekBar) { }});

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blue = i;
                method();
            }@Override public void onStartTrackingTouch(SeekBar seekBar) { }@Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        //Modes
        modes1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                modes = i;
                method();
                if (modes == 6){
                    layout.setBackgroundColor(Color.rgb(255,255,255));
                }
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }@Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        Time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                time = i;
                method();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }@Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

    }
///////////////////////////////////////////////////////////////////////////////////////////////////7
    private void method() {

        drawCircle();
        if (modes == 1) {
            colorRed = time + 1;
            colorGreen = colorRed + 85;
            colorBlue = colorRed + 170;

            if (colorRed > 255) colorRed = 0;
            if (colorGreen > 255) colorGreen = colorGreen - 255;
            if (colorBlue > 255) colorBlue = colorBlue - 255;

            colorRed = (int)colorRed + 2 * (red - 127);
            colorGreen = (int)colorGreen + 2 * (green - 127);
            colorBlue = (int)colorBlue + 2 * (blue - 127);
        }

        if (modes == 2) {
            cR = 255 / 2 + 255 / 2 * Math.sin(0.025 * time);
            cG = 255 / 2 + 255 / 2 * Math.sin(0.025 * time + 2 * Math.PI / 3);
            cB = 255 / 2 + 255 / 2 * Math.sin(0.025 * time + 4 * Math.PI / 3);
            colorRed = (int) cR;
            colorGreen = (int) cG;
            colorBlue = (int) cB;


            colorRed = (int)colorRed + 2 * (red - 127);
            colorGreen = (int)colorGreen + 2 * (green - 127);
            colorBlue = (int)colorBlue + 2 * (blue - 127);

        }

        if (modes == 3) {
            time = time + 1;
            if (time > 255) time = 0;
            cR = 255 / 2 + 255 / 2 * Math.sin(0.025 * time);
            cG = 255 / 2 + 255 / 2 * Math.sin(0.025 * time + Math.PI / 3);
            colorRed = (int) (cR + (int) cG) / 2;
            colorGreen = (int) (cR + (int) cG) / 2;
            colorBlue = (int) (cR + (int) cG) / 2;

            colorRed = (int)colorRed + 2 * (red - 127);

            //colorGreen = colorGreen + green;
            colorGreen = (int)colorGreen + 2 * (green - 127);

            //colorBlue = colorBlue + blue;
            colorBlue = (int)colorBlue + 2 * (blue - 127);

        }

        if (modes == 4) {
            xvalue1 = xmouse / xscreen;
            yvalue1 = ymouse / yscreen;
            cR = (yvalue1 * 255 * ((Math.sin(1 * Math.PI * xvalue1))));
            cG = (yvalue1 * 255 * ((Math.sin(1 * Math.PI * xvalue1 + 2 * Math.PI / 3))));
            cB = (yvalue1 * 255 * ((Math.sin(1 * Math.PI * xvalue1 + 4 * Math.PI / 3))));
            cR = cR * 2;
            cG = cG * 2;
            cB = cB * 2;
            if (cR < 0) cR = -cR;
            if (cG < 0) cG = -cG;
            if (cB < 0) cB = -cB;
            if (cR > 255) cR = 255;
            if (cG > 255) cG = 255;
            if (cB > 255) cB = 255;
            colorRed = (int) cR;
            colorGreen = (int) cG;
            colorBlue = (int) cB;
        }

        if (modes == 5) {
            xvalue1 = xmouse / xscreen;
            yvalue1 = ymouse / yscreen;
            cR = (xvalue1 * 255 * ((Math.sin(1 * Math.PI * yvalue1))));
            cG = (xvalue1 * 255 * ((Math.sin(1 * Math.PI * yvalue1 + 2 * Math.PI / 3))));
            cB = (xvalue1 * 255 * ((Math.sin(1 * Math.PI * yvalue1 + 4 * Math.PI / 3))));
            if (cR < 0) cR = -cR;
            if (cG < 0) cG = -cG;
            if (cB < 0) cB = -cB;
            if (cR > 255) cR = 255;
            if (cG > 255) cG = 255;
            if (cB > 255) cB = 255;
            colorRed = (int) cR;
            colorGreen = (int) cG;
            colorBlue = (int) cB;
        }
        if (colorRed > 255)
            colorRed = 255;
        if (colorGreen > 255)
            colorGreen= 255;
        if (colorBlue > 255)
            colorBlue = 255;

        if (colorRed < 0)
            colorRed = 0;
        if (colorGreen < 0)
            colorGreen = 0;
        if (colorBlue < 0)
            colorBlue = 0;

        if (modes == 6){

            layout.setBackgroundColor(Color.rgb(0,0,0));
            Circleradius = (float)Math.sqrt(Math.pow( xscreen/2-xmouse,2) + Math.pow(yscreen/2-ymouse,2));
            drawCircle();
            method2();
        }

        if (modes == 1 || modes == 2|| modes == 3 || modes == 4 || modes == 5) {
            method2();

            //String r, g, b;
            //int hex = (colorRed & 0xff) << 16 | (colorGreen & 0xff) << 8 | (colorBlue & 0xff);
            //String hex = String.format("#%06X", (0xFFFFFF & colorRed, colorGreen,colorBlue);
            //String hex1 = String.format("#%02x%02x%02x", red, green, blue);
            //Hex.setText(hex1);

            layout.setBackgroundColor(Color.argb(255, colorRed, colorGreen, colorBlue));
            r1 = 255 - colorRed;
            g1 = 255 - colorGreen;
            b1 = 255 - colorBlue;
        }
        if(modes == 0) {
            layout.setBackgroundColor(Color.argb(255, red, green, blue));

            r1 = 255 - red;
            g1 = 255 - green;
            b1 = 255 - blue;
            //method2();
        }
        method2();
        //Mode.setTextColor(Color.rgb(r1,g1,b1));
        //Steps.setTextColor(Color.rgb(r1,g1,b1));
        //Red.setTextColor(Color.rgb(r1,g1,b1));
        //Green.setTextColor(Color.rgb(r1,g1,b1));
        //Blue.setTextColor(Color.rgb(r1,g1,b1));
        //Hex.setTextColor(Color.rgb(r1,g1,b1));
        //XWert.setTextColor(Color.rgb(r1,g1,b1));
        //YWert.setTextColor(Color.rgb(r1,g1,b1));
        //XWert1.setTextColor(Color.rgb(r1,g1,b1));
        //YWert1.setTextColor(Color.rgb(r1,g1,b1));

    }

    ////////////////////////////////////////////////////////////////////////////////////////7

    private void method2() {

        drawCircle();
        Mode.setText("Mode:" + " " + modes);
        Steps.setText("Step:" + " " + time);

        if(modes == 0) {
            Red.setText("Red:" + " " + red);
            Green.setText("Green:" + " " + green);
            Blue.setText("Blue:" + " " + blue);
            Hex.setTextColor(Color.rgb(red,green ,blue ));
        }
        if (modes == 1 || modes == 2|| modes == 3 || modes == 4 || modes == 5) {
            Red.setText("Red:" + " " + colorRed);
            Green.setText("Green:" + " " + colorGreen);
            Blue.setText("Blue:" + " " + colorBlue);
            Hex.setTextColor(Color.rgb(colorRed, colorGreen ,colorBlue ));
        }

        Mode.setTextColor(Color.rgb(r1,g1,b1));
        Steps.setTextColor(Color.rgb(r1,g1,b1));

        Red.setTextColor(Color.rgb(r1,g1,b1));
        Green.setTextColor(Color.rgb(r1,g1,b1));
        Blue.setTextColor(Color.rgb(r1,g1,b1));
        XWert.setTextColor(Color.rgb(r1,g1,b1));
        YWert.setTextColor(Color.rgb(r1,g1,b1));
        XWert1.setTextColor(Color.rgb(r1,g1,b1));
        YWert1.setTextColor(Color.rgb(r1,g1,b1));

        //String r2, g2, b2;
        //r2  = Red.getText().toString();
        //g2 = Green.getText().toString();
        //b2 = Blue.getText().toString();
        //Integer rInt = Integer.parseInt(r2);
        //Integer gInt = Integer.parseInt(g2);
        //Integer bInt = Integer.parseInt(b2);
        //String hex = String.format("#%02x%02x%02x", r2, g2, b2);
        //Hex.setText(hex);
        //Hex.setTextColor(Color.rgb( rInt, gInt , bInt ));

        //Hex.setText("Hex:"+" " + hex);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////7

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        xmouse = touchX;
        ymouse = touchY;

        XWert.setText("X:" + " " + (int)xmouse);
        YWert.setText("Y:" + " " + (int)ymouse);
        XWert1.setText("X:" + " " + (xmouse/xscreen));
        //YWert1.setText("Y:" + " " + (ymouse/yscreen));

        if (modes == 4 || modes ==5 || modes == 6){
            method();
        }
        drawCircle();

        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////////7

    public void drawCircle() {

        Bitmap bmp = Bitmap.createBitmap((int) xscreen, (int) yscreen, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();

        //red/green/blue
        if (modes == 0) {

            paint.setColor(Color.rgb(red, green, blue));
            Canvas canvas = new Canvas(bmp);
            canvas.drawCircle(xscreen/ 2, yscreen/ 2, 0, paint);

            imgCircle.setImageBitmap(bmp);
        }
        //coloRed/Green/Blue
        if (modes == 1 || modes == 2 || modes == 3 || modes == 4 || modes == 5) {

            paint.setColor(Color.rgb(colorRed, colorGreen, colorBlue));
            Canvas canvas = new Canvas(bmp);
            canvas.drawCircle(xscreen/ 2, yscreen/ 2, 0, paint);

            imgCircle.setImageBitmap(bmp);
        }

        if (modes == 6) {
            if (red == 255){
                xmouse = xscreen*green/255;
                ymouse = yscreen*blue/255;
                Green.setText("Green:" + " " + green);
                Blue.setText("Blue:" + " " + blue);
            }

            Circleradius = (float)Math.sqrt(Math.pow( xscreen/2-xmouse,2) + Math.pow(yscreen/2-ymouse,2));

            Canvas canvas = new Canvas(bmp);


            Wert = 20; //20

            YWert1.setText("y1:"+ " "+ Circleradius);
            if (Circleradius > Wert) {

                angle = (float) Math.toDegrees(Math.atan2(yscreen / 2 - ymouse, xscreen / 2 - xmouse));

                //if (Circleradius < 50 & Math.sqrt(Math.pow( xCircle2/2-xCircle,2) + Math.pow(yCircle2/2-yCircle2,2)) > xscreen){
                //    bool1 = !bool1;
                //}
            }
            if (Circleradius < Wert & Math.sqrt(Math.pow( xCircle5/2-xCircle,2) + Math.pow(yCircle2/2-yCircle5,2)) > yscreen*3){
                bool1 = !bool1;
            }
            if (bool1){
                paint.setColor(Color.rgb(255,255,255));
                layout.setBackgroundColor(Color.rgb(0,0,0));
            }
            if (!bool1){
                paint.setColor(Color.rgb(0,0,0));
                layout.setBackgroundColor(Color.rgb(255,255,255));
            }
            if (red == 255 & (green == 128 || blue == 128)){
                if (blue < 128 || green < 128){
                    paint.setColor(Color.rgb(255,255,255));
                    layout.setBackgroundColor(Color.rgb(0,0,0));
                }
                if (blue > 128 || green < 128){
                    paint.setColor(Color.rgb(0,0,0));
                    layout.setBackgroundColor(Color.rgb(255,255,255));
                }
                //if (blue == 128 & green == 128){
                //    paint.setColor(Color.rgb(128,128,128));
                //    layout.setBackgroundColor(Color.rgb(128,128,128));
                //}
            }
            xCircle5 = xCircle4;
            yCircle5 = yCircle4;
            xCircle4 = xCircle3;
            yCircle4 = yCircle3;
            xCircle3 = xCircle2;
            yCircle3 = yCircle2;
            xCircle2 = xCircle1;
            yCircle2 = yCircle1;
            xCircle1 = xCircle;
            yCircle1 = yCircle;

            float C1;
            C1 = Circleradius;
            Circleradius = 100000/Circleradius;
            xCircle = (float) (Circleradius*Math.cos(Math.toRadians(angle))) + xscreen/2;
            yCircle = (float) (Circleradius*Math.sin(Math.toRadians(angle))) + yscreen/2;

            canvas.drawCircle( xCircle, yCircle, Circleradius, paint);
            if (red == 255) {
                paint.setColor(Color.argb(128,0, 255, 0));
                canvas.drawCircle(xscreen / 2, yscreen / 2, C1, paint);
                //paint.setColor(Color.argb(128,255,0,0));
                //canvas.drawCircle( xscreen/2, yscreen/2, Wert, paint);
            }
            paint.setColor(Color.argb(128,255,0,0));
            canvas.drawCircle( xscreen/2, yscreen/2, Wert, paint);
            imgCircle.setImageBitmap(bmp);
        }

    }
}
