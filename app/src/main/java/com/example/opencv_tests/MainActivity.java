package com.example.opencv_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.opencv.android.CameraActivity;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class MainActivity extends CameraActivity {

    CameraBridgeViewBase cameraBridgeViewBase;
    CascadeClassifier cascadeClassifier;
    CascadeClassifier cascadeClassifierEYES;
    CascadeClassifier cascadeClassifierMOUTH;
    CascadeClassifier cascadeClassifierEL;
    CascadeClassifier cascadeClassifierER;
    Mat gray,rgb,transpose_gray,transpose_rgb;
    MatOfRect rects;
    Integer MOUTHFLAGSIZE=0;
    Integer RITHEYEFLAG=0;
    Integer LEFTYEFLAG=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getPermission();

        cameraBridgeViewBase=findViewById(R.id.cameraView);
        cameraBridgeViewBase.setCameraIndex(1);
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

//                    Imgproc.blur(submat,submat,new Size(10,10));
//                    Imgproc.putText(transpose_rgb, "Face", new Point(rect.x,rect.y-5),
//                            1, 2, new Scalar(0,0,255));
//                    Imgproc.rectangle(transpose_rgb,rect,new Scalar(0,255,0),10);
                    MatOfRect mouth =new MatOfRect();
                    Mat facepart = transpose_gray.submat(rect);
                    cascadeClassifierMOUTH.detectMultiScale(facepart,mouth,1.5,25);
                    Integer MOUTHSIZE = mouth.toList().size();



                    if(MOUTHSIZE == 0){
                        if(MOUTHFLAGSIZE==3){
                            Log.e("OPENCV-TEST","MOUTHSIZE: "+MOUTHSIZE.toString());
                            //T1TEXT.setText("MOUTH OPEN");
                            setText(T1TEXT,"Mouth open");
//                            Imgproc.putText(transpose_rgb, "*****"+MOUTHSIZE.toString(), new Point(100, 400)
//                                    , 6, 10, new Scalar(0, 0, 0));
                            MOUTHFLAGSIZE=0;

                        }
                        MOUTHFLAGSIZE+=1;
                    }
                    if(MOUTHFLAGSIZE>3 ){
                        MOUTHFLAGSIZE=0;
                        RITHEYEFLAG=0;
                    }


                    MatOfRect eyes = new MatOfRect();
                    cascadeClassifierEYES.detectMultiScale(transpose_gray,eyes,
                            1.3,25,0);
                    if (eyes.toList().size()==2 &&  mouth.toList().size()>0 ){
                        setText(T1TEXT,"");
                    }



                    for(Rect eYe: eyes.toList()){
                        MatOfRect eyeL = new MatOfRect();
                        MatOfRect eyeR = new MatOfRect();
                        Mat eye_submat = transpose_gray.submat(eYe);


                        cascadeClassifierEL.detectMultiScale(transpose_gray,eyeL,
                                1.3,25,0);
//                        cascadeClassifierER.detectMultiScale(eye_submat.t(),eyeR,
//                                1.3,25,0);
                        Integer AmountOfEyes = eyes.toList().size();
                        Integer AmountOfLeftEye = eyeL.toList().size();
                        Integer AmountOfRightEye = eyeR.toList().size();
                        Log.e("OPENCV-TEST","RIGHT EYE: "+AmountOfRightEye.toString());
                        Log.e("OPENCV-TEST","LEFT EYE: "+AmountOfLeftEye.toString());
                        Log.e("OPENCV-TEST","EYES: "+AmountOfEyes.toString());
                        if(AmountOfEyes==1 && AmountOfLeftEye==1) {
                            ////RIGHT EYE CLOSED
                            if (RITHEYEFLAG==3){
                               // T1TEXT.setText("RIGTH EYE CLOSED");
                                setText(T1TEXT,"RIGTH EYE CLOSED");
//                                Imgproc.putText(transpose_rgb, "@@@@", new Point(eR.x, eR.y - 5)
//                                        , 5, 5, new Scalar(0, 0, 255));
                                RITHEYEFLAG=0;

                            }
                            RITHEYEFLAG+=1;

                        }
                        if(AmountOfEyes==1 && AmountOfLeftEye==0) {
                            ////LEFT EYE CLOSED
                            if (LEFTYEFLAG==1){

                                setText(T1TEXT,"LEFT EYE CLOSED");
//                                Imgproc.putText(transpose_rgb, "$$$$", new Point(eR.x, eR.y - 5)
//                                        , 5, 5, new Scalar(0, 0, 255));
                                RITHEYEFLAG=0;
                                LEFTYEFLAG=0;
                            }
                            LEFTYEFLAG+=1;
                        }
                        if(LEFTYEFLAG>1){
                            LEFTYEFLAG=0;
                            RITHEYEFLAG=0;

                        }
                        Imgproc.rectangle(transpose_rgb,eYe,new Scalar(0,255,0),10);
                    }

                    submat.release();
                }


                return transpose_rgb.t();
            }
        }) ;

        ////INIT OPENCV
        if (OpenCVLoader.initDebug()){
            cameraBridgeViewBase.enableView();
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
    public Mat rotateMat(Mat matImage) {
        Mat rotated = matImage.t();
        Core.flip(rotated, rotated, 1);
        return rotated;
    }


    private void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }


}
