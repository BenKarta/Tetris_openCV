package com.tetris.tetris;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.opencv.android.CameraActivity;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class Game extends CameraActivity implements View.OnClickListener {

    DrawView drawView;
    GameState gameState;
    RelativeLayout gameButtons;
    Button left;
    Button right;
    Button rotateAc;
    FrameLayout game;
    LinearLayout layoutlinear1;
    Button pause;
    TextView score;
    TextView difficultyToggle;
    Handler handler;
    Runnable loop;
    int delayFactor;
    int delay;
    int delayLowerLimit;
////
    CameraBridgeViewBase cameraBridgeViewBase;
    CascadeClassifier cascadeClassifier;
    CascadeClassifier cascadeClassifierEYES;
    CascadeClassifier cascadeClassifierMOUTH;
    CascadeClassifier cascadeClassifierEL;
    CascadeClassifier cascadeClassifierER;
    CameraBridgeViewBase camera1;
    Mat gray,rgb,transpose_gray,transpose_rgb;
    MatOfRect rects;
    Integer MOUTHFLAGSIZE=0;
    Integer RITHEYEFLAG=0;
    Integer LEFTYEFLAG=0;
    ///
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getPermission();
        //////////


        layoutlinear1= new LinearLayout(this);
        layoutlinear1.setOrientation(LinearLayout.VERTICAL);
        gameState = new GameState(24, 20, TetraminoType.getRandomTetramino());

        drawView = new DrawView(this, gameState);
        drawView.setBackgroundColor(Color.WHITE);

        game = findViewById(R.id.framelayout1);

        gameButtons = new RelativeLayout(this);

        delay = 500;
        delayLowerLimit = 200;
        delayFactor = 2;

        left = new Button(this);
        left.setText(R.string.left);
        left.setId(R.id.left);

        right = new Button(this);
        right.setText(R.string.right);
        right.setId(R.id.right);

        rotateAc = new Button(this);
        rotateAc.setText(R.string.rotate_ac);
        rotateAc.setId(R.id.rotate_ac);

        pause = new Button(this);
        pause.setText(R.string.pause);
        pause.setId(R.id.pause);

        score = new TextView(this);
        score.setText(R.string.score);
        score.setId(R.id.score);
        score.setTextSize(30);

        difficultyToggle = new TextView(this);
        difficultyToggle.setText("TETRIS-OPENCV");
        difficultyToggle.setId(R.id.difficulty);

        RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams leftButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams rightButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams downButton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams pausebutton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams scoretext = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams speedbutton = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        gameButtons.setLayoutParams(rl);
//        gameButtons.addView(left);
        //gameButtons.addView(right);
//        gameButtons.addView(rotateAc);
        gameButtons.addView(pause);
        gameButtons.addView(score);
        gameButtons.addView(difficultyToggle);

        leftButton.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        leftButton.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

        rightButton.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        rightButton.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

        downButton.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        downButton.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

        pausebutton.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        pausebutton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        scoretext.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        scoretext.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        speedbutton.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        speedbutton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);


        pause.setLayoutParams(pausebutton);
        score.setLayoutParams(scoretext);
        difficultyToggle.setLayoutParams(speedbutton);


        cameraBridgeViewBase=findViewById(R.id.cameraView);
        cameraBridgeViewBase.setCameraIndex(1);



        game.addView(drawView);
        game.addView(gameButtons);










        handler = new Handler(Looper.getMainLooper());
        loop = new Runnable() {
            public void run() {
                if (gameState.status) {
                    Log.e("TETRIS-GAME","RUN");
                    if (!gameState.pause) {
                        boolean success = gameState.moveFallingTetraminoDown();
                        if (!success) {
                            gameState.paintTetramino(gameState.falling);
                            gameState.lineRemove();

                            gameState.pushNewTetramino(TetraminoType.getRandomTetramino());

                            if (gameState.score % 10 == 9 && delay >= delayLowerLimit) {
                                delay = delay / delayFactor + 1;
                            }
                            gameState.incrementScore();
                        }
                        drawView.invalidate();
                        handler.postDelayed(this, delay);
                    } else {
                        handler.postDelayed(this, delay);
                    }
                } else {
                    pause.setText(R.string.start_new_game);
                }
            }

        };


        loop.run();



        cameraBridgeViewBase.setCvCameraViewListener(new CameraBridgeViewBase.CvCameraViewListener2() {
            @Override
            public void onCameraViewStarted(int width, int height) {
                rgb = new Mat();
                gray = new Mat();
                rects = new MatOfRect();
            }

            @Override
            public void onCameraViewStopped() {
                rgb.release();
                gray.release();
                rects.release();
            }

            @Override
            public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
//                setText(difficultyToggle,"*****");
                TextView T1TEXT = (TextView) findViewById(R.id.T1);
                boolean CHECK_FLAG_MOUTH=true;
                boolean CHECK_FLAG_EYES=true;
                rgb = inputFrame.rgba();
                gray = inputFrame.gray();
                Core.flip(rgb, rgb, 1);
                Core.flip(gray, gray, 1);
                transpose_gray = gray.t();

                transpose_rgb = rgb.t();
                MatOfRect faces =new MatOfRect();


                cascadeClassifier.detectMultiScale(transpose_gray,faces,1.1,2);



                for(Rect rect: faces.toList()){

                    Mat submat = transpose_rgb.submat(rect);
                    Mat facepart = transpose_gray.submat(rect);
//                    Imgproc.blur(submat,submat,new Size(10,10));
//                    Imgproc.putText(transpose_rgb, "Face", new Point(rect.x,rect.y-5),
//                            1, 2, new Scalar(0,0,255));
                    Imgproc.rectangle(transpose_rgb,rect,new Scalar(0,255,0),10);
                    MatOfRect mouth =new MatOfRect();



                    cascadeClassifierMOUTH.detectMultiScale(facepart,mouth,1.6,16);

                    Integer MOUTHSIZE = mouth.toList().size();

                    MatOfRect eyes = new MatOfRect();
                    cascadeClassifierEYES.detectMultiScale(transpose_gray,eyes,
                            1.3,25,0);
                    Integer AmountOfEyes = eyes.toList().size();


                    Log.e("OPENCV-TEST","MOUTHSIZE: "+MOUTHSIZE.toString());
                    if(MOUTHSIZE == 0 && AmountOfEyes==2){
                        if(MOUTHFLAGSIZE==3){

                            setText(difficultyToggle,"MOUTH OPEN");
                            //setBackgroundResource(difficultyToggle,"MOUTH OPEN");
                            setText(T1TEXT,"MOUTH OPEN");
                            moveRotate(gameState);

//                            Imgproc.putText(transpose_rgb, "*****"+MOUTHSIZE.toString(), new Point(100, 400)
//                                    , 6, 10, new Scalar(0, 0, 0));
                            MOUTHFLAGSIZE=0;
                            CHECK_FLAG_MOUTH=false;

                        }
                        MOUTHFLAGSIZE+=1;
                    }
                    if(MOUTHFLAGSIZE>3 ){
                        MOUTHFLAGSIZE=0;
                    }






                    if(CHECK_FLAG_MOUTH){
                        for(Rect eYe: eyes.toList()){
                            MatOfRect eyeL = new MatOfRect();
                            MatOfRect eyeR = new MatOfRect();
                            Mat eye_submat = transpose_gray.submat(eYe);


                            cascadeClassifierEL.detectMultiScale(transpose_gray,eyeL,
                                    1.3,24,0);
//                        cascadeClassifierER.detectMultiScale(eye_submat.t(),eyeR,
//                                1.3,25,0);

                            Integer AmountOfLeftEye = eyeL.toList().size();
//                            Integer AmountOfRightEye = eyeR.toList().size();
//                            Log.e("OPENCV-TEST","RIGHT EYE: "+AmountOfRightEye.toString());
                            Log.e("OPENCV-TEST","LEFT EYE: "+AmountOfLeftEye.toString());
                            Log.e("OPENCV-TEST","EYES: "+AmountOfEyes.toString());

                            if(AmountOfEyes==2 && MOUTHSIZE > 0 ) {
                                setText(T1TEXT,"BOTH EYES OPEN");
                                setText(difficultyToggle,"BOTH EYES OPEN");

                                LEFTYEFLAG=0;
                            }

                            if(AmountOfEyes==1 && AmountOfLeftEye==1) {
                                ////RIGHT EYE CLOSED
                                if (RITHEYEFLAG==3){
                                    // T1TEXT.setText("RIGTH EYE CLOSED");
                                    setText(T1TEXT,"RIGTH EYE CLOSED");
                                    //setBackgroundResource(difficultyToggle,"RIGTH EYE CLOSED");
                                    setText(difficultyToggle,"RIGTH EYE CLOSED");
                                    moveRight(gameState);
                                    RITHEYEFLAG=0;

                                }
                                RITHEYEFLAG+=1;

                            }


                            if(AmountOfEyes==1 && AmountOfLeftEye==0) {
                                ////LEFT EYE CLOSED
                                if (LEFTYEFLAG==1){
                                    setText(T1TEXT,"LEFT EYE CLOSED");
                                    //setBackgroundResource(difficultyToggle,"LEFT EYE CLOSED");
                                    setText(difficultyToggle,"LEFT EYE CLOSED");
                                    moveLeft(gameState);
                                    LEFTYEFLAG=0;
                                }
                                LEFTYEFLAG+=1;
                            }


                            Imgproc.rectangle(transpose_rgb,eYe,new Scalar(0,255,0),10);
                        }
                    }


                    submat.release();
                }
                CHECK_FLAG_MOUTH=true;

                return transpose_rgb.t();
            }
        }) ;

        ////INIT OPENCV
        if (OpenCVLoader.initDebug()){
            Log.e("OPENCV-TEST","LOADED");
//            cameraBridgeViewBase.enableView();
//            cameraBridgeViewBase.disableView();

//////////////////////////LOAD FRONT FACE CASCADE
            try{
                InputStream inputStream = getResources()
                        .openRawResource(R.raw.lbpcascade_frontalface);
                File file =new File(getDir("cascade",MODE_PRIVATE),
                        "lbpcascade_frontalface.xml");

                FileOutputStream fileOutputStream=new FileOutputStream(file);

                byte[] data = new byte[4096];
                int read_bytes;

                while((read_bytes = inputStream.read(data)) != -1){
                    fileOutputStream.write(data,0,read_bytes);
                }

                inputStream.close();
                fileOutputStream.close();
                ///////////////////////////////////////////////////////////////////////////////////
                ////LOAD EYES CASCADE
                InputStream inputStreamEYE = getResources().openRawResource(R.raw.haarcascade_eye);
                File fileEYE =new File(getDir("cascadeEYE",
                        MODE_PRIVATE),"haarcascade_eye.xml");

                FileOutputStream fileOutputStreamEYE=new FileOutputStream(fileEYE);

                byte[] dataEYE = new byte[4096];
                int read_bytesEYE;

                while((read_bytesEYE = inputStreamEYE.read(dataEYE)) != -1){
                    fileOutputStreamEYE.write(dataEYE,0,read_bytesEYE);
                }

                inputStreamEYE.close();
                fileOutputStreamEYE.close();
///////////////////////////////////////////////////////////////////////////////////////////////////
                ////LOAD LEFT EYE CASCADE
                InputStream inputStreamEL = getResources().
                        openRawResource(R.raw.haarcascade_lefteye_2splits);
                File fileEL =new File(getDir("cascadeEL",MODE_PRIVATE),
                        "haarcascade_lefteye_2splits.xml");

                FileOutputStream fileOutputStreamEL=new FileOutputStream(fileEL);

                byte[] dataEL = new byte[4096];
                int read_bytesEL;

                while((read_bytesEL = inputStreamEL.read(dataEL)) != -1){
                    fileOutputStreamEL.write(dataEL,0,read_bytesEL);
                }

                inputStreamEL.close();
                fileOutputStreamEL.close();
///////////////////////////////////////////////////////////////////////////////////////////////////
                ////LOAD LEFT EYE CASCADE
                InputStream inputStreamER = getResources().
                        openRawResource(R.raw.haarcascade_righteye_2splits);
                File fileER =new File(getDir("cascadeER",MODE_PRIVATE),
                        "haarcascade_righteye_2splits.xml");

                FileOutputStream fileOutputStreamER=new FileOutputStream(fileER);

                byte[] dataER = new byte[4096];
                int read_bytesER;

                while((read_bytesER = inputStreamER.read(dataER)) != -1){
                    fileOutputStreamER.write(dataER,0,read_bytesER);
                }

                inputStreamER.close();
                fileOutputStreamER.close();
///////////////////////////////////////////////////////////////////////////////////////////////////
                ////LOAD MOUTH CASCADE
                InputStream inputStreamMOUTH = getResources().
                        openRawResource(R.raw.haarcascade_smile);
                File fileMOUTH =new File(getDir("cascadeMOUTH",MODE_PRIVATE),
                        "haarcascade_smile.xml");

                FileOutputStream fileOutputStreamMOUTH=new FileOutputStream(fileMOUTH);

                byte[] dataMOUTH = new byte[4096];
                int read_bytesMOUTH;

                while((read_bytesMOUTH = inputStreamMOUTH.read(dataMOUTH)) != -1){
                    fileOutputStreamMOUTH.write(dataMOUTH,0,read_bytesMOUTH);
                }


                inputStreamMOUTH.close();
                fileOutputStreamMOUTH.close();
                ///////////////////////////////////////////////////////////////////////////////////

                cascadeClassifier =new CascadeClassifier(file.getAbsolutePath());
                cascadeClassifierEYES =new CascadeClassifier(fileEYE.getAbsolutePath());
                cascadeClassifierEL =new CascadeClassifier(fileEL.getAbsolutePath());
                cascadeClassifierMOUTH =new CascadeClassifier(fileMOUTH.getAbsolutePath());
                cascadeClassifierER =new CascadeClassifier(fileER.getAbsolutePath());

                if(cascadeClassifier.empty()||cascadeClassifierEYES.empty()||
                        cascadeClassifierEL.empty() || cascadeClassifierMOUTH.empty()
                        ||cascadeClassifierER.empty()) {
                    cascadeClassifier = null;
                    cascadeClassifierEYES = null;
                    cascadeClassifierEL = null;
                    cascadeClassifierMOUTH = null;
                    cascadeClassifierER = null;
                }





////////////////////////////////////////////////////////////////////////
                fileMOUTH.delete();
                fileEYE.delete();
                fileER.delete();
                fileEL.delete();
                file.delete();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View action) {
        if (action == left) {
            gameState.moveFallingTetraminoLeft();

        } else if (action == right) {
            gameState.moveFallingTetraminoRight();

        } else if (action == rotateAc) {
            gameState.rotateFallingTetraminoAntiClock();

        } else if (action == pause) {
            if (gameState.status) {
                if (gameState.pause) {
                    gameState.pause = false;
                    pause.setText(R.string.pause);

                } else {
                    pause.setText(R.string.play);
                    gameState.pause = true;

                }
            } else {
                pause.setText(R.string.start_new_game);
                Intent intent = new Intent(Game.this, MainActivity.class);
                startActivity(intent);

            }
        }
//        else if (action == difficultyToggle) {
//            if (!gameState.difficultMode) {
//                delay = delay / delayFactor;
//                gameState.difficultMode = true;
//                difficultyToggle.setText(R.string.hard);
//
//            } else {
//                delay = delay * delayFactor;
//                difficultyToggle.setText(R.string.easy);
//                gameState.difficultMode = false;
//
//            }
//
//        }
        gameState.difficultMode = false;
    }


    @Override
    protected void onResume() {
        super.onResume();
        cameraBridgeViewBase.enableView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraBridgeViewBase.disableView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraBridgeViewBase.disableView();
    }

    @Override
    protected List<? extends CameraBridgeViewBase> getCameraViewList() {
        return Collections.singletonList(cameraBridgeViewBase);
    }

    void getPermission(){
        if(checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA},101);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0 && grantResults[0]!=PackageManager.PERMISSION_GRANTED){
            getPermission();
        }
    }
    private void setText(final TextView B1,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                B1.setText(value);


            }
        });
    }

    private void setBackgroundResource(final TextView B1,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (value=="LEFT EYE CLOSED") {
                    B1.setBackgroundResource(R.drawable.red);
                }
                    if(value== "RIGHT EYE CLOSED") {

                        B1.setBackgroundResource(R.drawable.purple);
                    }
                    if(value == "MOUTH OPEN"){
                        B1.setBackgroundResource(R.drawable.green);
                }

            }
        });
    }

    private void moveLeft(final GameState B1){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                B1.moveFallingTetraminoLeft();
            }
        });
    }
    private void moveRight(GameState B1){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                B1.moveFallingTetraminoRight();
            }
        });
    }
    private void moveRotate(final GameState B1){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                B1.rotateFallingTetraminoAntiClock();
            }
        });
    }
}
