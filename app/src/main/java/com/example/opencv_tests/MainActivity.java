package com.example.opencv_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
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
    CascadeClassifier cascadeClassifierER;
    CascadeClassifier cascadeClassifierEL;
    Mat gray,rgb,transpose_gray,transpose_rgb;
    MatOfRect rects;
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
                    Imgproc.putText(transpose_rgb, "Face", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));
                    Imgproc.rectangle(transpose_rgb,rect,new Scalar(0,255,0),10);
                    MatOfRect eyeR = new MatOfRect();
                    cascadeClassifierER.detectMultiScale(gray,eyeR);
                    MatOfRect eyeL = new MatOfRect();
                    cascadeClassifierEL.detectMultiScale(gray,eyeL);
                    for(Rect eR: eyeR.toList()){
                        Imgproc.putText(transpose_rgb, "EYES Right", new Point(eR.x,eR.y-5), 1, 2, new Scalar(0,0,255));
                        Imgproc.rectangle(transpose_rgb,eR,new Scalar(0,255,0),10);
                    }
                    for(Rect eL: eyeL.toList()){
                        Imgproc.putText(transpose_rgb, "EYES left", new Point(eL.x,eL.y-5), 1, 2, new Scalar(0,0,255));
                        Imgproc.rectangle(transpose_rgb,eL,new Scalar(0,255,0),10);
                    }
                    submat.release();
                }


                return transpose_rgb.t();
            }
        }) ;
        if (OpenCVLoader.initDebug()){
            cameraBridgeViewBase.enableView();


            try{
                InputStream inputStream = getResources().openRawResource(R.raw.lbpcascade_frontalface);
                File file =new File(getDir("cascade",MODE_PRIVATE),"lbpcascade_frontalface.xml");

                FileOutputStream fileOutputStream=new FileOutputStream(file);

                byte[] data = new byte[4096];
                int read_bytes;

                while((read_bytes = inputStream.read(data)) != -1){
                    fileOutputStream.write(data,0,read_bytes);
                }
//
//                cascadeClassifier =new CascadeClassifier(file.getAbsolutePath());
//                if(cascadeClassifier.empty()) cascadeClassifier = null;
                inputStream.close();
                fileOutputStream.close();
                //////////////////////////////////////////////////////
                InputStream inputStreamER = getResources().openRawResource(R.raw.haarcascade_righteye_2splits);
                File fileER =new File(getDir("cascadeER",MODE_PRIVATE),"haarcascade_righteye_2splits.xml");

                FileOutputStream fileOutputStreamER=new FileOutputStream(fileER);

                byte[] dataER = new byte[4096];
                int read_bytesER;

                while((read_bytesER = inputStreamER.read(dataER)) != -1){
                    fileOutputStreamER.write(dataER,0,read_bytesER);
                }


                inputStreamER.close();
                fileOutputStreamER.close();
//////////////////////////////////////////////////////////////////////////////////////////////////////

                InputStream inputStreamEL = getResources().openRawResource(R.raw.haarcascade_lefteye_2splits);
                File fileEL =new File(getDir("cascadeEL",MODE_PRIVATE),"haarcascade_lefteye_2splits.xml");

                FileOutputStream fileOutputStreamEL=new FileOutputStream(fileEL);

                byte[] dataEL = new byte[4096];
                int read_bytesEL;

                while((read_bytesEL = inputStreamEL.read(dataEL)) != -1){
                    fileOutputStreamEL.write(dataEL,0,read_bytesEL);
                }


                inputStreamEL.close();
                fileOutputStreamEL.close();


                cascadeClassifier =new CascadeClassifier(file.getAbsolutePath());
                cascadeClassifierER =new CascadeClassifier(fileER.getAbsolutePath());
                cascadeClassifierEL =new CascadeClassifier(file.getAbsolutePath());
                if(cascadeClassifier.empty()||cascadeClassifierER.empty()) {
                    cascadeClassifier = null;
                    cascadeClassifierER = null;
                    cascadeClassifierEL = null;
                }





////////////////////////////////////////////////////////////////////////
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
}