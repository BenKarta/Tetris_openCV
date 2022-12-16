package com.example.myfirstapp


import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.game.*
import kotlin.random.Random
import kotlin.random.nextInt


class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        next_shape()
    }

    var nextUp:Int = 0
    var starting = 0
    var num1 = 0
    var num2 = 0
    var num3 = 0
    var num4 = 0
    var shape_is = 0
    var stop = 0
    var lines = 0
    var once = 0

    private fun loseAline(){
        if(B11.text == "0"&&B12.text == "0"&&B13.text == "0"&&B14.text == "0"&&B15.text == "0"&&B16.text == "0"&&B17.text == "0"&&B18.text == "0"&&B19.text == "0"&&B20.text == "0"){
            B11.setBackgroundResource(R.drawable.gray);B12.setBackgroundResource(R.drawable.gray);B13.setBackgroundResource(R.drawable.gray);B14.setBackgroundResource(R.drawable.gray);
            B15.setBackgroundResource(R.drawable.gray);B16.setBackgroundResource(R.drawable.gray);B17.setBackgroundResource(R.drawable.gray);B18.setBackgroundResource(R.drawable.gray);B19.setBackgroundResource(R.drawable.gray);B20.setBackgroundResource(R.drawable.gray);
            B11.text="0";B12.text="0";B13.text="0";B14.text="0";B15.text="0";B16.text="0";B17.text="0";B18.text="0";B19.text="0";B20.text="0";
        }
        if(B21.text == "0"&&B22.text == "0"&&B23.text == "0"&&B24.text == "0"&&B25.text == "0"&&B26.text == "0"&&B27.text == "0"&&B28.text == "0"&&B29.text == "0"&&B30.text == "0"){
            B21.setBackgroundResource(R.drawable.gray);B22.setBackgroundResource(R.drawable.gray);B23.setBackgroundResource(R.drawable.gray);B24.setBackgroundResource(R.drawable.gray);
            B25.setBackgroundResource(R.drawable.gray);B26.setBackgroundResource(R.drawable.gray);B27.setBackgroundResource(R.drawable.gray);B28.setBackgroundResource(R.drawable.gray);
            B29.setBackgroundResource(R.drawable.gray);B30.setBackgroundResource(R.drawable.gray);
            B21.text="0";B22.text="0";B23.text="0";B24.text="0";B25.text="0";B26.text="0";B27.text="0";B28.text="0";B29.text="0";B30.text="0";
        }
        if(B31.text == "0"&&B32.text == "0"&&B33.text == "0"&&B34.text == "0"&&B35.text == "0"&&B36.text == "0"&&B37.text == "0"&&B38.text == "0"&&B39.text == "0"&&B40.text == "0"){
            B31.setBackgroundResource(R.drawable.gray);
            B32.setBackgroundResource(R.drawable.gray);
            B33.setBackgroundResource(R.drawable.gray);
            B34.setBackgroundResource(R.drawable.gray);
            B35.setBackgroundResource(R.drawable.gray);
            B36.setBackgroundResource(R.drawable.gray);
            B37.setBackgroundResource(R.drawable.gray);
            B38.setBackgroundResource(R.drawable.gray);
            B39.setBackgroundResource(R.drawable.gray);
            B40.setBackgroundResource(R.drawable.gray);
            B31.text="0";B32.text="0";B33.text="0";B34.text="0";B35.text="0";B36.text="0";B37.text="0";B38.text="0";B39.text="0";B40.text="0";
        }
        if(B41.text == "0"&&B42.text == "0"&&B43.text == "0"&&B44.text == "0"&&B45.text == "0"&&B46.text == "0"&&B47.text == "0"&&B48.text == "0"&&B49.text == "0"&&B50.text == "0"){
            B41.setBackgroundResource(R.drawable.gray);
            B42.setBackgroundResource(R.drawable.gray);
            B43.setBackgroundResource(R.drawable.gray);
            B44.setBackgroundResource(R.drawable.gray);
            B45.setBackgroundResource(R.drawable.gray);
            B46.setBackgroundResource(R.drawable.gray);
            B47.setBackgroundResource(R.drawable.gray);
            B48.setBackgroundResource(R.drawable.gray);
            B49.setBackgroundResource(R.drawable.gray);
            B50.setBackgroundResource(R.drawable.gray);
            B41.text="0";B42.text="0";B43.text="0";B44.text="0";B45.text="0";B46.text="0";B47.text="0";B48.text="0";B49.text="0";B50.text="0";
        }
        if(B51.text == "0"&&B52.text == "0"&&B53.text == "0"&&B54.text == "0"&&B55.text == "0"&&B56.text == "0"&&B57.text == "0"&&B58.text == "0"&&B59.text == "0"&&B60.text == "0"){
            B51.setBackgroundResource(R.drawable.gray);
            B52.setBackgroundResource(R.drawable.gray);
            B53.setBackgroundResource(R.drawable.gray);
            B54.setBackgroundResource(R.drawable.gray);
            B55.setBackgroundResource(R.drawable.gray);
            B56.setBackgroundResource(R.drawable.gray);
            B57.setBackgroundResource(R.drawable.gray);
            B58.setBackgroundResource(R.drawable.gray);
            B59.setBackgroundResource(R.drawable.gray);
            B60.setBackgroundResource(R.drawable.gray);
            B51.text="0";B52.text="0";B53.text="0";B54.text="0";B55.text="0";B56.text="0";B57.text="0";B58.text="0";B59.text="0";B60.text="0";
        }
        if(B61.text == "0"&&B62.text == "0"&&B63.text == "0"&&B64.text == "0"&&B65.text == "0"&&B66.text == "0"&&B67.text == "0"&&B68.text == "0"&&B69.text == "0"&&B70.text == "0"){
            B61.setBackgroundResource(R.drawable.gray);
            B62.setBackgroundResource(R.drawable.gray);
            B63.setBackgroundResource(R.drawable.gray);
            B64.setBackgroundResource(R.drawable.gray);
            B65.setBackgroundResource(R.drawable.gray);
            B66.setBackgroundResource(R.drawable.gray);
            B67.setBackgroundResource(R.drawable.gray);
            B68.setBackgroundResource(R.drawable.gray);
            B69.setBackgroundResource(R.drawable.gray);
            B70.setBackgroundResource(R.drawable.gray);
            B61.text="0";B62.text="0";B63.text="0";B64.text="0";B65.text="0";B66.text="0";B67.text="0";B68.text="0";B69.text="0";B70.text="0";
        }
        if(B71.text == "0"&&B72.text == "0"&&B73.text == "0"&&B74.text == "0"&&B75.text == "0"&&B76.text == "0"&&B77.text == "0"&&B78.text == "0"&&B79.text == "0"&&B80.text == "0"){
            B71.setBackgroundResource(R.drawable.gray);
            B72.setBackgroundResource(R.drawable.gray);
            B73.setBackgroundResource(R.drawable.gray);
            B74.setBackgroundResource(R.drawable.gray);
            B75.setBackgroundResource(R.drawable.gray);
            B76.setBackgroundResource(R.drawable.gray);
            B77.setBackgroundResource(R.drawable.gray);
            B78.setBackgroundResource(R.drawable.gray);
            B79.setBackgroundResource(R.drawable.gray);
            B80.setBackgroundResource(R.drawable.gray);
            ;B71.text="0";B72.text="0";B73.text="0";B74.text="0";B75.text="0";B76.text="0";B77.text="0";B78.text="0";B79.text="0";B80.text="0";
        }
        if(B81.text == "0"&&B82.text == "0"&&B83.text == "0"&&B84.text == "0"&&B85.text == "0"&&B86.text == "0"&&B87.text == "0"&&B88.text == "0"&&B89.text == "0"&&B90.text == "0"){
            B81.setBackgroundResource(R.drawable.gray);
            B82.setBackgroundResource(R.drawable.gray);
            B83.setBackgroundResource(R.drawable.gray);
            B84.setBackgroundResource(R.drawable.gray);
            B85.setBackgroundResource(R.drawable.gray);
            B86.setBackgroundResource(R.drawable.gray);
            B87.setBackgroundResource(R.drawable.gray);
            B88.setBackgroundResource(R.drawable.gray);
            B89.setBackgroundResource(R.drawable.gray);
            B90.setBackgroundResource(R.drawable.gray);
            B81.text="0";B82.text="0";B83.text="0";B84.text="0";B85.text="0";B86.text="0";B87.text="0";B88.text="0";B89.text="0";B90.text="0";
        }
        if(B91.text == "0"&&B92.text == "0"&&B93.text == "0"&&B94.text == "0"&&B95.text == "0"&&B96.text == "0"&&B97.text == "0"&&B98.text == "0"&&B99.text == "0"&&B100.text == "0"){
            B91.setBackgroundResource(R.drawable.gray);
            B92.setBackgroundResource(R.drawable.gray);
            B93.setBackgroundResource(R.drawable.gray);
            B94.setBackgroundResource(R.drawable.gray);
            B95.setBackgroundResource(R.drawable.gray);
            B96.setBackgroundResource(R.drawable.gray);
            B97.setBackgroundResource(R.drawable.gray);
            B98.setBackgroundResource(R.drawable.gray);
            B99.setBackgroundResource(R.drawable.gray);
            B91.text="0";B92.text="0";B93.text="0";B94.text="0";B95.text="0";B96.text="0";B97.text="0";B98.text="0";B99.text="0";B100.text="0";
        }
        if(B101.text == "0"&&B102.text == "0"&&B103.text == "0"&&B104.text == "0"&&B105.text == "0"&&B106.text == "0"&&B107.text == "0"&&B108.text == "0"&&B109.text == "0"&&B110.text == "0"){
            B101.setBackgroundResource(R.drawable.gray);
            B102.setBackgroundResource(R.drawable.gray);
            B103.setBackgroundResource(R.drawable.gray);
            B104.setBackgroundResource(R.drawable.gray);
            B105.setBackgroundResource(R.drawable.gray);
            B106.setBackgroundResource(R.drawable.gray);
            B107.setBackgroundResource(R.drawable.gray);
            B108.setBackgroundResource(R.drawable.gray);
            B109.setBackgroundResource(R.drawable.gray);
            B110.setBackgroundResource(R.drawable.gray);
            B101.text="0";B102.text="0";B103.text="0";B104.text="0";B105.text="0";B106.text="0";B107.text="0";B108.text="0";B109.text="0";B110.text="0";
        }
        if(B111.text == "0"&&B112.text == "0"&&B113.text == "0"&&B114.text == "0"&&B115.text == "0"&&B116.text == "0"&&B117.text == "0"&&B118.text == "0"&&B119.text == "0"&&B120.text == "0"){
            B111.setBackgroundResource(R.drawable.gray);
            B112.setBackgroundResource(R.drawable.gray);
            B113.setBackgroundResource(R.drawable.gray);
            B114.setBackgroundResource(R.drawable.gray);
            B115.setBackgroundResource(R.drawable.gray);
            B116.setBackgroundResource(R.drawable.gray);
            B117.setBackgroundResource(R.drawable.gray);
            B118.setBackgroundResource(R.drawable.gray);
            B119.setBackgroundResource(R.drawable.gray);
            B120.setBackgroundResource(R.drawable.gray);
            B111.text="0";B112.text="0";B113.text="0";B114.text="0";B115.text="0";B116.text="0";B117.text="0";B118.text="0";B119.text="0";B120.text="0";
        }
        if(B121.text == "0"&&B122.text == "0"&&B123.text == "0"&&B124.text == "0"&&B125.text == "0"&&B126.text == "0"&&B127.text == "0"&&B128.text == "0"&&B129.text == "0"&&B130.text == "0"){
            B121.setBackgroundResource(R.drawable.gray);
            B122.setBackgroundResource(R.drawable.gray);
            B123.setBackgroundResource(R.drawable.gray);
            B124.setBackgroundResource(R.drawable.gray);
            B125.setBackgroundResource(R.drawable.gray);
            B126.setBackgroundResource(R.drawable.gray);
            B127.setBackgroundResource(R.drawable.gray);
            B128.setBackgroundResource(R.drawable.gray);
            B129.setBackgroundResource(R.drawable.gray);
            B130.setBackgroundResource(R.drawable.gray);
            B121.text="0";B122.text="0";B123.text="0";B124.text="0";B125.text="0";B126.text="0";B127.text="0";B128.text="0";B129.text="0";B130.text="0";
        }
        if(B131.text == "0"&&B132.text == "0"&&B133.text == "0"&&B134.text == "0"&&B135.text == "0"&&B136.text == "0"&&B137.text == "0"&&B138.text == "0"&&B139.text == "0"&&B140.text == "0"){
            B131.setBackgroundResource(R.drawable.gray);
            B132.setBackgroundResource(R.drawable.gray);
            B133.setBackgroundResource(R.drawable.gray);
            B134.setBackgroundResource(R.drawable.gray);
            B135.setBackgroundResource(R.drawable.gray);
            B136.setBackgroundResource(R.drawable.gray);
            B137.setBackgroundResource(R.drawable.gray);
            B138.setBackgroundResource(R.drawable.gray);
            B139.setBackgroundResource(R.drawable.gray);
            B140.setBackgroundResource(R.drawable.gray);
            B131.text="0";B132.text="0";B133.text="0";B134.text="0";B135.text="0";B136.text="0";B137.text="0";B138.text="0";B139.text="0";B140.text="0";
        }
        if(B141.text == "0"&&B142.text == "0"&&B143.text == "0"&&B144.text == "0"&&B145.text == "0"&&B146.text == "0"&&B147.text == "0"&&B148.text == "0"&&B149.text == "0"&&B150.text == "0"){
            B141.setBackgroundResource(R.drawable.gray);B142.setBackgroundResource(R.drawable.gray);
            B143.setBackgroundResource(R.drawable.gray);B144.setBackgroundResource(R.drawable.gray);B145.setBackgroundResource(R.drawable.gray);
            B146.setBackgroundResource(R.drawable.gray);
            B147.setBackgroundResource(R.drawable.gray);
            B148.setBackgroundResource(R.drawable.gray);
            B149.setBackgroundResource(R.drawable.gray);
            B150.setBackgroundResource(R.drawable.gray);
            B141.text="0";B142.text="0";B143.text="0";B144.text="0";B145.text="0";B146.text="0";B147.text="0";B148.text="0";B149.text="0";B150.text="0";
        }
        Handler().postDelayed({
            if(lines==15){
                if(B111.text==""&&B112.text==""&&B113.text==""&&B114.text==""&&B115.text==""&&B116.text==""&&B117.text==""&&B118.text==""&&B119.text==""&&B120.text==""){
                    B111.text=B101.text;B112.text=B102.text;B113.text=B103.text;B114.text=B104.text;B115.text=B105.text;B116.text=B106.text;B117.text=B107.text;B118.text=B108.text;B119.text=B109.text;B120.text=B110.text;
                    B111.background=B101.background;B112.background=B102.background;B113.background=B103.background;B114.background=B104.background;B115.background=B105.background;B116.background=B106.background;B117.background=B107.background;B118.background=B108.background;B119.background=B109.background;B120.background=B110.background;
                    B101.setBackgroundResource(R.drawable.gray);B102.setBackgroundResource(R.drawable.gray);B103.setBackgroundResource(R.drawable.gray);B104.setBackgroundResource(R.drawable.gray);B105.setBackgroundResource(R.drawable.gray);B106.setBackgroundResource(R.drawable.gray);B107.setBackgroundResource(R.drawable.gray);B108.setBackgroundResource(R.drawable.gray);B109.setBackgroundResource(R.drawable.gray);B110.setBackgroundResource(R.drawable.gray);
                    B101.text="";B102.text="";B103.text="";B104.text="";B105.text="";B106.text="";B107.text="";B108.text="";B109.text="";B110.text="";
                }
                if(B121.text==""&&B122.text==""&&B123.text==""&&B124.text==""&&B125.text==""&&B126.text==""&&B127.text==""&&B128.text==""&&B129.text==""&&B130.text==""){
                    B121.text=B111.text;B122.text=B112.text;B123.text=B113.text;B124.text=B114.text;B125.text=B115.text;B126.text=B116.text;B127.text=B117.text;B128.text=B118.text;B129.text=B119.text;B130.text=B120.text;
                    B121.background=B111.background;B122.background=B112.background;B123.background=B113.background;B124.background=B114.background;B125.background=B115.background;B126.background=B116.background;B127.background=B117.background;B128.background=B118.background;B129.background=B119.background;B130.background=B120.background;
                    B111.setBackgroundResource(R.drawable.gray);B112.setBackgroundResource(R.drawable.gray);B113.setBackgroundResource(R.drawable.gray);B114.setBackgroundResource(R.drawable.gray);B115.setBackgroundResource(R.drawable.gray);B116.setBackgroundResource(R.drawable.gray);B117.setBackgroundResource(R.drawable.gray);B118.setBackgroundResource(R.drawable.gray);B119.setBackgroundResource(R.drawable.gray);B120.setBackgroundResource(R.drawable.gray);
                    B111.text="";B112.text="";B113.text="";B114.text="";B115.text="";B116.text="";B117.text="";B118.text="";B119.text="";B120.text="";


                }
                if(B131.text==""&&B132.text==""&&B133.text==""&&B134.text==""&&B135.text==""&&B136.text==""&&B137.text==""&&B138.text==""&&B139.text==""&&B140.text==""){
                    B131.text=B121.text;B132.text=B122.text;B133.text=B123.text;B134.text=B124.text;B135.text=B125.text;B136.text=B126.text;B137.text=B127.text;B138.text=B128.text;B139.text=B129.text;B140.text=B130.text;
                    B131.background=B121.background;B132.background=B122.background;B133.background=B123.background;B134.background=B124.background;B135.background=B125.background;B136.background=B126.background;B137.background=B127.background;B138.background=B128.background;B139.background=B129.background;B140.background=B130.background;
                    B121.setBackgroundResource(R.drawable.gray);B122.setBackgroundResource(R.drawable.gray);B123.setBackgroundResource(R.drawable.gray);B124.setBackgroundResource(R.drawable.gray);B125.setBackgroundResource(R.drawable.gray);B126.setBackgroundResource(R.drawable.gray);B127.setBackgroundResource(R.drawable.gray);B128.setBackgroundResource(R.drawable.gray);B129.setBackgroundResource(R.drawable.gray);B130.setBackgroundResource(R.drawable.gray);
                    B121.text="";B122.text="";B123.text="";B124.text="";B125.text="";B126.text="";B127.text="";B128.text="";B129.text="";B130.text="";
                }
                if(B141.text==""&&B142.text==""&&B143.text==""&&B144.text==""&&B145.text==""&&B146.text==""&&B147.text==""&&B148.text==""&&B149.text==""&&B150.text==""){
                B141.text=B131.text;B142.text=B132.text;B143.text=B133.text;B144.text=B134.text;B145.text=B135.text;B146.text=B136.text;B147.text=B137.text;B148.text=B138.text;B149.text=B139.text;B150.text=B140.text;
                B141.background=B131.background;B142.background=B132.background;B143.background=B133.background;B144.background=B134.background;B145.background=B135.background;B146.background=B136.background;B147.background=B137.background;B148.background=B138.background;B149.background=B139.background;B150.background=B140.background;
                B131.setBackgroundResource(R.drawable.gray);B132.setBackgroundResource(R.drawable.gray);B133.setBackgroundResource(R.drawable.gray);B134.setBackgroundResource(R.drawable.gray);B135.setBackgroundResource(R.drawable.gray);B136.setBackgroundResource(R.drawable.gray);B137.setBackgroundResource(R.drawable.gray);B138.setBackgroundResource(R.drawable.gray);B139.setBackgroundResource(R.drawable.gray);B140.setBackgroundResource(R.drawable.gray);
                B131.text="";B132.text="";B133.text="";B134.text="";B135.text="";B136.text="";B137.text="";B138.text="";B139.text="";B140.text="";
            };lines=14}
            if(lines==14){
                if(B101.text==""&&B102.text==""&&B103.text==""&&B104.text==""&&B105.text==""&&B106.text==""&&B107.text==""&&B108.text==""&&B109.text==""&&B110.text=="") {
                    B101.text = B91.text;B102.text = B92.text;B103.text = B93.text;B104.text =
                        B94.text;B105.text = B95.text;B106.text = B96.text;B107.text =
                        B97.text;B108.text = B98.text;B109.text = B99.text;B110.text = B100.text;
                    B101.background = B91.background;B102.background =
                        B92.background;B103.background = B93.background;B104.background =
                        B94.background;B105.background = B95.background;B106.background =
                        B96.background;B107.background = B97.background;B108.background =
                        B98.background;B109.background = B99.background;B110.background =
                        B100.background;
                    B91.setBackgroundResource(R.drawable.gray);B92.setBackgroundResource(R.drawable.gray);B93.setBackgroundResource(
                        R.drawable.gray
                    );B94.setBackgroundResource(R.drawable.gray);B95.setBackgroundResource(R.drawable.gray);B96.setBackgroundResource(
                        R.drawable.gray
                    );B97.setBackgroundResource(R.drawable.gray);B98.setBackgroundResource(R.drawable.gray);B99.setBackgroundResource(
                        R.drawable.gray
                    );B100.setBackgroundResource(R.drawable.gray);
                    B91.text = "";B92.text = "";B93.text = "";B94.text = "";B95.text = "";B96.text =
                        "";B97.text = "";B98.text = "";B99.text = "";B100.text = "";
                }
                if(B111.text==""&&B112.text==""&&B113.text==""&&B114.text==""&&B115.text==""&&B116.text==""&&B117.text==""&&B118.text==""&&B119.text==""&&B120.text==""){
                    B111.text=B101.text;B112.text=B102.text;B113.text=B103.text;B114.text=B104.text;B115.text=B105.text;B116.text=B106.text;B117.text=B107.text;B118.text=B108.text;B119.text=B109.text;B120.text=B110.text;
                    B111.background=B101.background;B112.background=B102.background;B113.background=B103.background;B114.background=B104.background;B115.background=B105.background;B116.background=B106.background;B117.background=B107.background;B118.background=B108.background;B119.background=B109.background;B120.background=B110.background;
                    B101.setBackgroundResource(R.drawable.gray);B102.setBackgroundResource(R.drawable.gray);B103.setBackgroundResource(R.drawable.gray);B104.setBackgroundResource(R.drawable.gray);B105.setBackgroundResource(R.drawable.gray);B106.setBackgroundResource(R.drawable.gray);B107.setBackgroundResource(R.drawable.gray);B108.setBackgroundResource(R.drawable.gray);B109.setBackgroundResource(R.drawable.gray);B110.setBackgroundResource(R.drawable.gray);
                    B101.text="";B102.text="";B103.text="";B104.text="";B105.text="";B106.text="";B107.text="";B108.text="";B109.text="";B110.text="";
                }
                if(B121.text==""&&B122.text==""&&B123.text==""&&B124.text==""&&B125.text==""&&B126.text==""&&B127.text==""&&B128.text==""&&B129.text==""&&B130.text==""){
                    B121.text=B111.text;B122.text=B112.text;B123.text=B113.text;B124.text=B114.text;B125.text=B115.text;B126.text=B116.text;B127.text=B117.text;B128.text=B118.text;B129.text=B119.text;B130.text=B120.text;
                    B121.background=B111.background;B122.background=B112.background;B123.background=B113.background;B124.background=B114.background;B125.background=B115.background;B126.background=B116.background;B127.background=B117.background;B128.background=B118.background;B129.background=B119.background;B130.background=B120.background;
                    B111.setBackgroundResource(R.drawable.gray);B112.setBackgroundResource(R.drawable.gray);B113.setBackgroundResource(R.drawable.gray);B114.setBackgroundResource(R.drawable.gray);B115.setBackgroundResource(R.drawable.gray);B116.setBackgroundResource(R.drawable.gray);B117.setBackgroundResource(R.drawable.gray);B118.setBackgroundResource(R.drawable.gray);B119.setBackgroundResource(R.drawable.gray);B120.setBackgroundResource(R.drawable.gray);
                    B111.text="";B112.text="";B113.text="";B114.text="";B115.text="";B116.text="";B117.text="";B118.text="";B119.text="";B120.text="";


                }
                if(B131.text==""&&B132.text==""&&B133.text==""&&B134.text==""&&B135.text==""&&B136.text==""&&B137.text==""&&B138.text==""&&B139.text==""&&B140.text==""){
                    B131.text=B121.text;B132.text=B122.text;B133.text=B123.text;B134.text=B124.text;B135.text=B125.text;B136.text=B126.text;B137.text=B127.text;B138.text=B128.text;B139.text=B129.text;B140.text=B130.text;
                    B131.background=B121.background;B132.background=B122.background;B133.background=B123.background;B134.background=B124.background;B135.background=B125.background;B136.background=B126.background;B137.background=B127.background;B138.background=B128.background;B139.background=B129.background;B140.background=B130.background;
                    B121.setBackgroundResource(R.drawable.gray);B122.setBackgroundResource(R.drawable.gray);B123.setBackgroundResource(R.drawable.gray);B124.setBackgroundResource(R.drawable.gray);B125.setBackgroundResource(R.drawable.gray);B126.setBackgroundResource(R.drawable.gray);B127.setBackgroundResource(R.drawable.gray);B128.setBackgroundResource(R.drawable.gray);B129.setBackgroundResource(R.drawable.gray);B130.setBackgroundResource(R.drawable.gray);
                    B121.text="";B122.text="";B123.text="";B124.text="";B125.text="";B126.text="";B127.text="";B128.text="";B129.text="";B130.text="";
            };lines=13}
            if(lines==13){
                if(B91.text==""&&B92.text==""&&B93.text==""&&B94.text==""&&B95.text==""&&B96.text==""&&B97.text==""&&B98.text==""&&B99.text==""&&B100.text==""){
                    B91.text=B81.text;B92.text=B82.text;B93.text=B83.text;B94.text=B84.text;B95.text=B85.text;B96.text=B86.text;B97.text=B87.text;B98.text=B88.text;B99.text=B89.text;B100.text=B90.text;
                    B91.background=B81.background;B92.background=B82.background;B93.background=B83.background;B94.background=B84.background;B95.background=B85.background;B96.background=B86.background;B97.background=B87.background;B98.background=B88.background;B99.background=B89.background;B100.background=B90.background;
                    B81.setBackgroundResource(R.drawable.gray);B82.setBackgroundResource(R.drawable.gray);B83.setBackgroundResource(R.drawable.gray);B84.setBackgroundResource(R.drawable.gray);B85.setBackgroundResource(R.drawable.gray);B86.setBackgroundResource(R.drawable.gray);B87.setBackgroundResource(R.drawable.gray);B88.setBackgroundResource(R.drawable.gray);B89.setBackgroundResource(R.drawable.gray);B90.setBackgroundResource(R.drawable.gray);
                    B81.text="";B82.text="";B83.text="";B84.text="";B85.text="";B86.text="";B87.text="";B88.text="";B89.text="";B90.text="";
                }
                if(B101.text==""&&B102.text==""&&B103.text==""&&B104.text==""&&B105.text==""&&B106.text==""&&B107.text==""&&B108.text==""&&B109.text==""&&B110.text=="") {
                    B101.text = B91.text;B102.text = B92.text;B103.text = B93.text;B104.text =
                        B94.text;B105.text = B95.text;B106.text = B96.text;B107.text =
                        B97.text;B108.text = B98.text;B109.text = B99.text;B110.text = B100.text;
                    B101.background = B91.background;B102.background =
                        B92.background;B103.background = B93.background;B104.background =
                        B94.background;B105.background = B95.background;B106.background =
                        B96.background;B107.background = B97.background;B108.background =
                        B98.background;B109.background = B99.background;B110.background =
                        B100.background;
                    B91.setBackgroundResource(R.drawable.gray);B92.setBackgroundResource(R.drawable.gray);B93.setBackgroundResource(
                        R.drawable.gray
                    );B94.setBackgroundResource(R.drawable.gray);B95.setBackgroundResource(R.drawable.gray);B96.setBackgroundResource(
                        R.drawable.gray
                    );B97.setBackgroundResource(R.drawable.gray);B98.setBackgroundResource(R.drawable.gray);B99.setBackgroundResource(
                        R.drawable.gray
                    );B100.setBackgroundResource(R.drawable.gray);
                    B91.text = "";B92.text = "";B93.text = "";B94.text = "";B95.text = "";B96.text =
                        "";B97.text = "";B98.text = "";B99.text = "";B100.text = "";
                }
                    if(B111.text==""&&B112.text==""&&B113.text==""&&B114.text==""&&B115.text==""&&B116.text==""&&B117.text==""&&B118.text==""&&B119.text==""&&B120.text==""){
                        B111.text=B101.text;B112.text=B102.text;B113.text=B103.text;B114.text=B104.text;B115.text=B105.text;B116.text=B106.text;B117.text=B107.text;B118.text=B108.text;B119.text=B109.text;B120.text=B110.text;
                        B111.background=B101.background;B112.background=B102.background;B113.background=B103.background;B114.background=B104.background;B115.background=B105.background;B116.background=B106.background;B117.background=B107.background;B118.background=B108.background;B119.background=B109.background;B120.background=B110.background;
                        B101.setBackgroundResource(R.drawable.gray);B102.setBackgroundResource(R.drawable.gray);B103.setBackgroundResource(R.drawable.gray);B104.setBackgroundResource(R.drawable.gray);B105.setBackgroundResource(R.drawable.gray);B106.setBackgroundResource(R.drawable.gray);B107.setBackgroundResource(R.drawable.gray);B108.setBackgroundResource(R.drawable.gray);B109.setBackgroundResource(R.drawable.gray);B110.setBackgroundResource(R.drawable.gray);
                        B101.text="";B102.text="";B103.text="";B104.text="";B105.text="";B106.text="";B107.text="";B108.text="";B109.text="";B110.text="";
                    }
                if(B121.text==""&&B122.text==""&&B123.text==""&&B124.text==""&&B125.text==""&&B126.text==""&&B127.text==""&&B128.text==""&&B129.text==""&&B130.text==""){
                    B121.text=B111.text;B122.text=B112.text;B123.text=B113.text;B124.text=B114.text;B125.text=B115.text;B126.text=B116.text;B127.text=B117.text;B128.text=B118.text;B129.text=B119.text;B130.text=B120.text;
                    B121.background=B111.background;B122.background=B112.background;B123.background=B113.background;B124.background=B114.background;B125.background=B115.background;B126.background=B116.background;B127.background=B117.background;B128.background=B118.background;B129.background=B119.background;B130.background=B120.background;
                    B111.setBackgroundResource(R.drawable.gray);B112.setBackgroundResource(R.drawable.gray);B113.setBackgroundResource(R.drawable.gray);B114.setBackgroundResource(R.drawable.gray);B115.setBackgroundResource(R.drawable.gray);B116.setBackgroundResource(R.drawable.gray);B117.setBackgroundResource(R.drawable.gray);B118.setBackgroundResource(R.drawable.gray);B119.setBackgroundResource(R.drawable.gray);B120.setBackgroundResource(R.drawable.gray);
                    B111.text="";B112.text="";B113.text="";B114.text="";B115.text="";B116.text="";B117.text="";B118.text="";B119.text="";B120.text="";


            } ;lines=12}
            if(lines==12){
                if(B81.text==""&&B82.text==""&&B83.text==""&&B84.text==""&&B85.text==""&&B86.text==""&&B87.text==""&&B88.text==""&&B89.text==""&&B90.text==""){
                    B81.text=B71.text;B82.text=B72.text;B83.text=B73.text;B84.text=B74.text;B85.text=B75.text;B86.text=B76.text;B87.text=B77.text;B88.text=B78.text;B89.text=B79.text;B90.text=B80.text;
                    B81.background=B71.background;B82.background=B72.background;B83.background=B73.background;B84.background=B74.background;B85.background=B75.background;B86.background=B76.background;B87.background=B77.background;B88.background=B78.background;B89.background=B79.background;B90.background=B80.background;
                    B71.setBackgroundResource(R.drawable.gray);B72.setBackgroundResource(R.drawable.gray);B73.setBackgroundResource(R.drawable.gray);B74.setBackgroundResource(R.drawable.gray);B75.setBackgroundResource(R.drawable.gray);B76.setBackgroundResource(R.drawable.gray);B77.setBackgroundResource(R.drawable.gray);B78.setBackgroundResource(R.drawable.gray);B79.setBackgroundResource(R.drawable.gray);B80.setBackgroundResource(R.drawable.gray);
                    B71.text="";B72.text="";B73.text="";B74.text="";B75.text="";B76.text="";B77.text="";B78.text="";B79.text="";B80.text=""
                }
                if(B91.text==""&&B92.text==""&&B93.text==""&&B94.text==""&&B95.text==""&&B96.text==""&&B97.text==""&&B98.text==""&&B99.text==""&&B100.text==""){
                    B91.text=B81.text;B92.text=B82.text;B93.text=B83.text;B94.text=B84.text;B95.text=B85.text;B96.text=B86.text;B97.text=B87.text;B98.text=B88.text;B99.text=B89.text;B100.text=B90.text;
                    B91.background=B81.background;B92.background=B82.background;B93.background=B83.background;B94.background=B84.background;B95.background=B85.background;B96.background=B86.background;B97.background=B87.background;B98.background=B88.background;B99.background=B89.background;B100.background=B90.background;
                    B81.setBackgroundResource(R.drawable.gray);B82.setBackgroundResource(R.drawable.gray);B83.setBackgroundResource(R.drawable.gray);B84.setBackgroundResource(R.drawable.gray);B85.setBackgroundResource(R.drawable.gray);B86.setBackgroundResource(R.drawable.gray);B87.setBackgroundResource(R.drawable.gray);B88.setBackgroundResource(R.drawable.gray);B89.setBackgroundResource(R.drawable.gray);B90.setBackgroundResource(R.drawable.gray);
                    B81.text="";B82.text="";B83.text="";B84.text="";B85.text="";B86.text="";B87.text="";B88.text="";B89.text="";B90.text="";
                }
                if(B101.text==""&&B102.text==""&&B103.text==""&&B104.text==""&&B105.text==""&&B106.text==""&&B107.text==""&&B108.text==""&&B109.text==""&&B110.text=="") {
                    B101.text = B91.text;B102.text = B92.text;B103.text = B93.text;B104.text =
                        B94.text;B105.text = B95.text;B106.text = B96.text;B107.text =
                        B97.text;B108.text = B98.text;B109.text = B99.text;B110.text = B100.text;
                    B101.background = B91.background;B102.background =
                        B92.background;B103.background = B93.background;B104.background =
                        B94.background;B105.background = B95.background;B106.background =
                        B96.background;B107.background = B97.background;B108.background =
                        B98.background;B109.background = B99.background;B110.background =
                        B100.background;
                    B91.setBackgroundResource(R.drawable.gray);B92.setBackgroundResource(R.drawable.gray);B93.setBackgroundResource(
                        R.drawable.gray
                    );B94.setBackgroundResource(R.drawable.gray);B95.setBackgroundResource(R.drawable.gray);B96.setBackgroundResource(
                        R.drawable.gray
                    );B97.setBackgroundResource(R.drawable.gray);B98.setBackgroundResource(R.drawable.gray);B99.setBackgroundResource(
                        R.drawable.gray
                    );B100.setBackgroundResource(R.drawable.gray);
                    B91.text = "";B92.text = "";B93.text = "";B94.text = "";B95.text = "";B96.text =
                        "";B97.text = "";B98.text = "";B99.text = "";B100.text = "";
                }
                    if(B111.text==""&&B112.text==""&&B113.text==""&&B114.text==""&&B115.text==""&&B116.text==""&&B117.text==""&&B118.text==""&&B119.text==""&&B120.text==""){
                B111.text=B101.text;B112.text=B102.text;B113.text=B103.text;B114.text=B104.text;B115.text=B105.text;B116.text=B106.text;B117.text=B107.text;B118.text=B108.text;B119.text=B109.text;B120.text=B110.text;
                B111.background=B101.background;B112.background=B102.background;B113.background=B103.background;B114.background=B104.background;B115.background=B105.background;B116.background=B106.background;B117.background=B107.background;B118.background=B108.background;B119.background=B109.background;B120.background=B110.background;
                B101.setBackgroundResource(R.drawable.gray);B102.setBackgroundResource(R.drawable.gray);B103.setBackgroundResource(R.drawable.gray);B104.setBackgroundResource(R.drawable.gray);B105.setBackgroundResource(R.drawable.gray);B106.setBackgroundResource(R.drawable.gray);B107.setBackgroundResource(R.drawable.gray);B108.setBackgroundResource(R.drawable.gray);B109.setBackgroundResource(R.drawable.gray);B110.setBackgroundResource(R.drawable.gray);
                B101.text="";B102.text="";B103.text="";B104.text="";B105.text="";B106.text="";B107.text="";B108.text="";B109.text="";B110.text="";
            };lines=11}
            if(lines==11){
                if(B71.text==""&&B72.text==""&&B73.text==""&&B74.text==""&&B75.text==""&&B76.text==""&&B77.text==""&&B78.text==""&&B79.text==""&&B80.text==""){
                    B71.text=B61.text;B72.text=B62.text;B73.text=B63.text;B74.text=B64.text;B75.text=B65.text;
                    B76.text=B66.text;B77.text=B67.text;B78.text=B68.text;B79.text=B69.text;B80.text=B70.text;
                    B71.background=B61.background;B72.background=B62.background;B73.background=B63.background;B74.background=B64.background;B75.background=B65.background;
                    B76.background=B66.background;B77.background=B67.background;B78.background=B68.background;B79.background=B69.background;B80.background=B70.background;
                    B61.setBackgroundResource(R.drawable.gray);B62.setBackgroundResource(R.drawable.gray);B63.setBackgroundResource(R.drawable.gray);B64.setBackgroundResource(R.drawable.gray);B65.setBackgroundResource(R.drawable.gray);
                    B66.setBackgroundResource(R.drawable.gray);B67.setBackgroundResource(R.drawable.gray);B68.setBackgroundResource(R.drawable.gray);B69.setBackgroundResource(R.drawable.gray);B70.setBackgroundResource(R.drawable.gray);
                    B61.text="";B62.text="";B63.text="";B64.text="";B65.text="";B66.text="";B67.text="";B68.text="";B69.text="";B70.text="";
                }
                if(B81.text==""&&B82.text==""&&B83.text==""&&B84.text==""&&B85.text==""&&B86.text==""&&B87.text==""&&B88.text==""&&B89.text==""&&B90.text==""){
                    B81.text=B71.text;B82.text=B72.text;B83.text=B73.text;B84.text=B74.text;B85.text=B75.text;B86.text=B76.text;B87.text=B77.text;B88.text=B78.text;B89.text=B79.text;B90.text=B80.text;
                    B81.background=B71.background;B82.background=B72.background;B83.background=B73.background;B84.background=B74.background;B85.background=B75.background;B86.background=B76.background;B87.background=B77.background;B88.background=B78.background;B89.background=B79.background;B90.background=B80.background;
                    B71.setBackgroundResource(R.drawable.gray);B72.setBackgroundResource(R.drawable.gray);B73.setBackgroundResource(R.drawable.gray);B74.setBackgroundResource(R.drawable.gray);B75.setBackgroundResource(R.drawable.gray);B76.setBackgroundResource(R.drawable.gray);B77.setBackgroundResource(R.drawable.gray);B78.setBackgroundResource(R.drawable.gray);B79.setBackgroundResource(R.drawable.gray);B80.setBackgroundResource(R.drawable.gray);
                    B71.text="";B72.text="";B73.text="";B74.text="";B75.text="";B76.text="";B77.text="";B78.text="";B79.text="";B80.text=""
                }
                if(B91.text==""&&B92.text==""&&B93.text==""&&B94.text==""&&B95.text==""&&B96.text==""&&B97.text==""&&B98.text==""&&B99.text==""&&B100.text==""){
                    B91.text=B81.text;B92.text=B82.text;B93.text=B83.text;B94.text=B84.text;B95.text=B85.text;B96.text=B86.text;B97.text=B87.text;B98.text=B88.text;B99.text=B89.text;B100.text=B90.text;
                    B91.background=B81.background;B92.background=B82.background;B93.background=B83.background;B94.background=B84.background;B95.background=B85.background;B96.background=B86.background;B97.background=B87.background;B98.background=B88.background;B99.background=B89.background;B100.background=B90.background;
                    B81.setBackgroundResource(R.drawable.gray);B82.setBackgroundResource(R.drawable.gray);B83.setBackgroundResource(R.drawable.gray);B84.setBackgroundResource(R.drawable.gray);B85.setBackgroundResource(R.drawable.gray);B86.setBackgroundResource(R.drawable.gray);B87.setBackgroundResource(R.drawable.gray);B88.setBackgroundResource(R.drawable.gray);B89.setBackgroundResource(R.drawable.gray);B90.setBackgroundResource(R.drawable.gray);
                    B81.text="";B82.text="";B83.text="";B84.text="";B85.text="";B86.text="";B87.text="";B88.text="";B89.text="";B90.text="";
                }
                if(B101.text==""&&B102.text==""&&B103.text==""&&B104.text==""&&B105.text==""&&B106.text==""&&B107.text==""&&B108.text==""&&B109.text==""&&B110.text==""){
                B101.text=B91.text;B102.text=B92.text;B103.text=B93.text;B104.text=B94.text;B105.text=B95.text;B106.text=B96.text;B107.text=B97.text;B108.text=B98.text;B109.text=B99.text;B110.text=B100.text;
                B101.background=B91.background;B102.background=B92.background;B103.background=B93.background;B104.background=B94.background;B105.background=B95.background;B106.background=B96.background;B107.background=B97.background;B108.background=B98.background;B109.background=B99.background;B110.background=B100.background;
                B91.setBackgroundResource(R.drawable.gray);B92.setBackgroundResource(R.drawable.gray);B93.setBackgroundResource(R.drawable.gray);B94.setBackgroundResource(R.drawable.gray);B95.setBackgroundResource(R.drawable.gray);B96.setBackgroundResource(R.drawable.gray);B97.setBackgroundResource(R.drawable.gray);B98.setBackgroundResource(R.drawable.gray);B99.setBackgroundResource(R.drawable.gray);B100.setBackgroundResource(R.drawable.gray);
                B91.text="";B92.text="";B93.text="";B94.text="";B95.text="";B96.text="";B97.text="";B98.text="";B99.text="";B100.text="";
            };lines=10}
            if(lines==10){
                if(B61.text==""&&B62.text==""&&B63.text==""&&B64.text==""&&B65.text==""&&B66.text==""&&B67.text==""&&B68.text==""&&B69.text==""&&B70.text==""){
                    B61.text=B51.text;B62.text=B52.text;B63.text=B53.text;B64.text=B54.text;B65.text=B55.text;B66.text=B56.text;B67.text=B57.text;B68.text=B58.text;B69.text=B59.text;B70.text=B60.text;
                    B61.background=B51.background;B62.background=B52.background;B63.background=B53.background;B64.background=B54.background;B65.background=B55.background;B66.background=B56.background;B67.background=B57.background;B68.background=B58.background;B69.background=B59.background;B70.background=B60.background;
                    B51.setBackgroundResource(R.drawable.gray);B52.setBackgroundResource(R.drawable.gray);B53.setBackgroundResource(R.drawable.gray);B54.setBackgroundResource(R.drawable.gray);B55.setBackgroundResource(R.drawable.gray);B56.setBackgroundResource(R.drawable.gray);B57.setBackgroundResource(R.drawable.gray);B58.setBackgroundResource(R.drawable.gray);B59.setBackgroundResource(R.drawable.gray);B60.setBackgroundResource(R.drawable.gray);
                    B51.text="";B52.text="";B53.text="";B54.text="";B55.text="";B56.text="";B57.text="";B58.text="";B59.text="";B60.text="";
                }
                if(B71.text==""&&B72.text==""&&B73.text==""&&B74.text==""&&B75.text==""&&B76.text==""&&B77.text==""&&B78.text==""&&B79.text==""&&B80.text==""){
                    B71.text=B61.text;B72.text=B62.text;B73.text=B63.text;B74.text=B64.text;B75.text=B65.text;
                    B76.text=B66.text;B77.text=B67.text;B78.text=B68.text;B79.text=B69.text;B80.text=B70.text;
                    B71.background=B61.background;B72.background=B62.background;B73.background=B63.background;B74.background=B64.background;B75.background=B65.background;
                    B76.background=B66.background;B77.background=B67.background;B78.background=B68.background;B79.background=B69.background;B80.background=B70.background;
                    B61.setBackgroundResource(R.drawable.gray);B62.setBackgroundResource(R.drawable.gray);B63.setBackgroundResource(R.drawable.gray);B64.setBackgroundResource(R.drawable.gray);B65.setBackgroundResource(R.drawable.gray);
                    B66.setBackgroundResource(R.drawable.gray);B67.setBackgroundResource(R.drawable.gray);B68.setBackgroundResource(R.drawable.gray);B69.setBackgroundResource(R.drawable.gray);B70.setBackgroundResource(R.drawable.gray);
                    B61.text="";B62.text="";B63.text="";B64.text="";B65.text="";B66.text="";B67.text="";B68.text="";B69.text="";B70.text="";
                }
                if(B81.text==""&&B82.text==""&&B83.text==""&&B84.text==""&&B85.text==""&&B86.text==""&&B87.text==""&&B88.text==""&&B89.text==""&&B90.text==""){
                    B81.text=B71.text;B82.text=B72.text;B83.text=B73.text;B84.text=B74.text;B85.text=B75.text;B86.text=B76.text;B87.text=B77.text;B88.text=B78.text;B89.text=B79.text;B90.text=B80.text;
                    B81.background=B71.background;B82.background=B72.background;B83.background=B73.background;B84.background=B74.background;B85.background=B75.background;B86.background=B76.background;B87.background=B77.background;B88.background=B78.background;B89.background=B79.background;B90.background=B80.background;
                    B71.setBackgroundResource(R.drawable.gray);B72.setBackgroundResource(R.drawable.gray);B73.setBackgroundResource(R.drawable.gray);B74.setBackgroundResource(R.drawable.gray);B75.setBackgroundResource(R.drawable.gray);B76.setBackgroundResource(R.drawable.gray);B77.setBackgroundResource(R.drawable.gray);B78.setBackgroundResource(R.drawable.gray);B79.setBackgroundResource(R.drawable.gray);B80.setBackgroundResource(R.drawable.gray);
                    B71.text="";B72.text="";B73.text="";B74.text="";B75.text="";B76.text="";B77.text="";B78.text="";B79.text="";B80.text=""
                }
                if(B91.text==""&&B92.text==""&&B93.text==""&&B94.text==""&&B95.text==""&&B96.text==""&&B97.text==""&&B98.text==""&&B99.text==""&&B100.text==""){
                B91.text=B81.text;B92.text=B82.text;B93.text=B83.text;B94.text=B84.text;B95.text=B85.text;B96.text=B86.text;B97.text=B87.text;B98.text=B88.text;B99.text=B89.text;B100.text=B90.text;
                B91.background=B81.background;B92.background=B82.background;B93.background=B83.background;B94.background=B84.background;B95.background=B85.background;B96.background=B86.background;B97.background=B87.background;B98.background=B88.background;B99.background=B89.background;B100.background=B90.background;
                B81.setBackgroundResource(R.drawable.gray);B82.setBackgroundResource(R.drawable.gray);B83.setBackgroundResource(R.drawable.gray);B84.setBackgroundResource(R.drawable.gray);B85.setBackgroundResource(R.drawable.gray);B86.setBackgroundResource(R.drawable.gray);B87.setBackgroundResource(R.drawable.gray);B88.setBackgroundResource(R.drawable.gray);B89.setBackgroundResource(R.drawable.gray);B90.setBackgroundResource(R.drawable.gray);
                B81.text="";B82.text="";B83.text="";B84.text="";B85.text="";B86.text="";B87.text="";B88.text="";B89.text="";B90.text="";
            };lines=9}
            if(lines==9){
                if(B51.text==""&&B52.text==""&&B53.text==""&&B54.text==""&&B55.text==""&&B56.text==""&&B57.text==""&&B58.text==""&&B59.text==""&&B60.text==""){
                    B51.text=B41.text;B52.text=B42.text;B53.text=B43.text;B54.text=B44.text;B55.text=B45.text;B56.text=B46.text;B57.text=B47.text;B58.text=B48.text;B59.text=B49.text;B60.text=B50.text;
                    B51.background=B41.background;B52.background=B42.background;B53.background=B43.background;B54.background=B44.background;B55.background=B45.background;B56.background=B46.background;B57.background=B47.background;B58.background=B48.background;B59.background=B49.background;B60.background=B50.background;
                    B41.setBackgroundResource(R.drawable.gray);B42.setBackgroundResource(R.drawable.gray);B43.setBackgroundResource(R.drawable.gray);B44.setBackgroundResource(R.drawable.gray);B45.setBackgroundResource(R.drawable.gray);B46.setBackgroundResource(R.drawable.gray);B47.setBackgroundResource(R.drawable.gray);B48.setBackgroundResource(R.drawable.gray);B49.setBackgroundResource(R.drawable.gray);B50.setBackgroundResource(R.drawable.gray);
                    B41.text="";B42.text="";B43.text="";B44.text="";B45.text="";B46.text="";B47.text="";B48.text="";B49.text="";B50.text="";
                }
                if(B61.text==""&&B62.text==""&&B63.text==""&&B64.text==""&&B65.text==""&&B66.text==""&&B67.text==""&&B68.text==""&&B69.text==""&&B70.text==""){
                    B61.text=B51.text;B62.text=B52.text;B63.text=B53.text;B64.text=B54.text;B65.text=B55.text;B66.text=B56.text;B67.text=B57.text;B68.text=B58.text;B69.text=B59.text;B70.text=B60.text;
                    B61.background=B51.background;B62.background=B52.background;B63.background=B53.background;B64.background=B54.background;B65.background=B55.background;B66.background=B56.background;B67.background=B57.background;B68.background=B58.background;B69.background=B59.background;B70.background=B60.background;
                    B51.setBackgroundResource(R.drawable.gray);B52.setBackgroundResource(R.drawable.gray);B53.setBackgroundResource(R.drawable.gray);B54.setBackgroundResource(R.drawable.gray);B55.setBackgroundResource(R.drawable.gray);B56.setBackgroundResource(R.drawable.gray);B57.setBackgroundResource(R.drawable.gray);B58.setBackgroundResource(R.drawable.gray);B59.setBackgroundResource(R.drawable.gray);B60.setBackgroundResource(R.drawable.gray);
                    B51.text="";B52.text="";B53.text="";B54.text="";B55.text="";B56.text="";B57.text="";B58.text="";B59.text="";B60.text="";
                }
                if(B71.text==""&&B72.text==""&&B73.text==""&&B74.text==""&&B75.text==""&&B76.text==""&&B77.text==""&&B78.text==""&&B79.text==""&&B80.text==""){
                    B71.text=B61.text;B72.text=B62.text;B73.text=B63.text;B74.text=B64.text;B75.text=B65.text;
                    B76.text=B66.text;B77.text=B67.text;B78.text=B68.text;B79.text=B69.text;B80.text=B70.text;
                    B71.background=B61.background;B72.background=B62.background;B73.background=B63.background;B74.background=B64.background;B75.background=B65.background;
                    B76.background=B66.background;B77.background=B67.background;B78.background=B68.background;B79.background=B69.background;B80.background=B70.background;
                    B61.setBackgroundResource(R.drawable.gray);B62.setBackgroundResource(R.drawable.gray);B63.setBackgroundResource(R.drawable.gray);B64.setBackgroundResource(R.drawable.gray);B65.setBackgroundResource(R.drawable.gray);
                    B66.setBackgroundResource(R.drawable.gray);B67.setBackgroundResource(R.drawable.gray);B68.setBackgroundResource(R.drawable.gray);B69.setBackgroundResource(R.drawable.gray);B70.setBackgroundResource(R.drawable.gray);
                    B61.text="";B62.text="";B63.text="";B64.text="";B65.text="";B66.text="";B67.text="";B68.text="";B69.text="";B70.text="";
                }
                if(B81.text==""&&B82.text==""&&B83.text==""&&B84.text==""&&B85.text==""&&B86.text==""&&B87.text==""&&B88.text==""&&B89.text==""&&B90.text==""){
                B81.text=B71.text;B82.text=B72.text;B83.text=B73.text;B84.text=B74.text;B85.text=B75.text;B86.text=B76.text;B87.text=B77.text;B88.text=B78.text;B89.text=B79.text;B90.text=B80.text;
                B81.background=B71.background;B82.background=B72.background;B83.background=B73.background;B84.background=B74.background;B85.background=B75.background;B86.background=B76.background;B87.background=B77.background;B88.background=B78.background;B89.background=B79.background;B90.background=B80.background;
                B71.setBackgroundResource(R.drawable.gray);B72.setBackgroundResource(R.drawable.gray);B73.setBackgroundResource(R.drawable.gray);B74.setBackgroundResource(R.drawable.gray);B75.setBackgroundResource(R.drawable.gray);B76.setBackgroundResource(R.drawable.gray);B77.setBackgroundResource(R.drawable.gray);B78.setBackgroundResource(R.drawable.gray);B79.setBackgroundResource(R.drawable.gray);B80.setBackgroundResource(R.drawable.gray);
                B71.text="";B72.text="";B73.text="";B74.text="";B75.text="";B76.text="";B77.text="";B78.text="";B79.text="";B80.text=""
            };lines=8}
            if(lines==8){
                if(B41.text==""&&B42.text==""&&B43.text==""&&B44.text==""&&B45.text==""&&B46.text==""&&B47.text==""&&B48.text==""&&B49.text==""&&B50.text==""){
                    B41.text=B31.text;B42.text=B32.text;B43.text=B33.text;B44.text=B34.text;B45.text=B35.text;B46.text=B36.text;B47.text=B37.text;B48.text=B38.text;B49.text=B39.text;B50.text=B40.text;
                    B41.background=B31.background;B42.background=B32.background;B43.background=B33.background;B44.background=B34.background;B45.background=B35.background;B46.background=B36.background;B47.background=B37.background;B48.background=B38.background;B49.background=B39.background;B50.background=B40.background;
                    B31.setBackgroundResource(R.drawable.gray);B32.setBackgroundResource(R.drawable.gray);B33.setBackgroundResource(R.drawable.gray);B34.setBackgroundResource(R.drawable.gray);B35.setBackgroundResource(R.drawable.gray);B36.setBackgroundResource(R.drawable.gray);B37.setBackgroundResource(R.drawable.gray);B38.setBackgroundResource(R.drawable.gray);B39.setBackgroundResource(R.drawable.gray);B40.setBackgroundResource(R.drawable.gray);
                    B31.text="";B32.text="";B33.text="";B34.text="";B35.text="";B36.text="";B37.text="";B38.text="";B39.text="";B40.text="";
                }
                if(B51.text==""&&B52.text==""&&B53.text==""&&B54.text==""&&B55.text==""&&B56.text==""&&B57.text==""&&B58.text==""&&B59.text==""&&B60.text==""){
                    B51.text=B41.text;B52.text=B42.text;B53.text=B43.text;B54.text=B44.text;B55.text=B45.text;B56.text=B46.text;B57.text=B47.text;B58.text=B48.text;B59.text=B49.text;B60.text=B50.text;
                    B51.background=B41.background;B52.background=B42.background;B53.background=B43.background;B54.background=B44.background;B55.background=B45.background;B56.background=B46.background;B57.background=B47.background;B58.background=B48.background;B59.background=B49.background;B60.background=B50.background;
                    B41.setBackgroundResource(R.drawable.gray);B42.setBackgroundResource(R.drawable.gray);B43.setBackgroundResource(R.drawable.gray);B44.setBackgroundResource(R.drawable.gray);B45.setBackgroundResource(R.drawable.gray);B46.setBackgroundResource(R.drawable.gray);B47.setBackgroundResource(R.drawable.gray);B48.setBackgroundResource(R.drawable.gray);B49.setBackgroundResource(R.drawable.gray);B50.setBackgroundResource(R.drawable.gray);
                    B41.text="";B42.text="";B43.text="";B44.text="";B45.text="";B46.text="";B47.text="";B48.text="";B49.text="";B50.text="";
                }
                if(B61.text==""&&B62.text==""&&B63.text==""&&B64.text==""&&B65.text==""&&B66.text==""&&B67.text==""&&B68.text==""&&B69.text==""&&B70.text==""){
                    B61.text=B51.text;B62.text=B52.text;B63.text=B53.text;B64.text=B54.text;B65.text=B55.text;B66.text=B56.text;B67.text=B57.text;B68.text=B58.text;B69.text=B59.text;B70.text=B60.text;
                    B61.background=B51.background;B62.background=B52.background;B63.background=B53.background;B64.background=B54.background;B65.background=B55.background;B66.background=B56.background;B67.background=B57.background;B68.background=B58.background;B69.background=B59.background;B70.background=B60.background;
                    B51.setBackgroundResource(R.drawable.gray);B52.setBackgroundResource(R.drawable.gray);B53.setBackgroundResource(R.drawable.gray);B54.setBackgroundResource(R.drawable.gray);B55.setBackgroundResource(R.drawable.gray);B56.setBackgroundResource(R.drawable.gray);B57.setBackgroundResource(R.drawable.gray);B58.setBackgroundResource(R.drawable.gray);B59.setBackgroundResource(R.drawable.gray);B60.setBackgroundResource(R.drawable.gray);
                    B51.text="";B52.text="";B53.text="";B54.text="";B55.text="";B56.text="";B57.text="";B58.text="";B59.text="";B60.text="";
                }

                if(B71.text==""&&B72.text==""&&B73.text==""&&B74.text==""&&B75.text==""&&B76.text==""&&B77.text==""&&B78.text==""&&B79.text==""&&B80.text==""){
                B71.text=B61.text;B72.text=B62.text;B73.text=B63.text;B74.text=B64.text;B75.text=B65.text;
                B76.text=B66.text;B77.text=B67.text;B78.text=B68.text;B79.text=B69.text;B80.text=B70.text;
                B71.background=B61.background;B72.background=B62.background;B73.background=B63.background;B74.background=B64.background;B75.background=B65.background;
                B76.background=B66.background;B77.background=B67.background;B78.background=B68.background;B79.background=B69.background;B80.background=B70.background;
                B61.setBackgroundResource(R.drawable.gray);B62.setBackgroundResource(R.drawable.gray);B63.setBackgroundResource(R.drawable.gray);B64.setBackgroundResource(R.drawable.gray);B65.setBackgroundResource(R.drawable.gray);
                B66.setBackgroundResource(R.drawable.gray);B67.setBackgroundResource(R.drawable.gray);B68.setBackgroundResource(R.drawable.gray);B69.setBackgroundResource(R.drawable.gray);B70.setBackgroundResource(R.drawable.gray);
                B61.text="";B62.text="";B63.text="";B64.text="";B65.text="";B66.text="";B67.text="";B68.text="";B69.text="";B70.text="";
            };lines=7}
            if(lines==7){
                if(B31.text==""&&B32.text==""&&B33.text==""&&B34.text==""&&B35.text==""&&B36.text==""&&B37.text==""&&B38.text==""&&B39.text==""&&B40.text==""){
                    B31.text=B21.text;B32.text=B22.text;B33.text=B23.text;B34.text=B24.text;B35.text=B25.text;B36.text=B26.text;B37.text=B27.text;B38.text=B28.text;B39.text=B29.text;B40.text=B30.text;
                B31.background=B21.background;B32.background=B22.background;B33.background=B23.background;B34.background=B24.background;B35.background=B25.background;
                    B36.background=B26.background;B37.background=B27.background;B38.background=B28.background;B39.background=B29.background;B40.background=B30.background;
                B21.setBackgroundResource(R.drawable.gray);B22.setBackgroundResource(R.drawable.gray);B23.setBackgroundResource(R.drawable.gray);B24.setBackgroundResource(R.drawable.gray);B25.setBackgroundResource(R.drawable.gray);B26.setBackgroundResource(R.drawable.gray);B27.setBackgroundResource(R.drawable.gray);B28.setBackgroundResource(R.drawable.gray);B29.setBackgroundResource(R.drawable.gray);B30.setBackgroundResource(R.drawable.gray);
                B21.text="";B22.text="";B23.text="";B24.text="";B25.text="";B26.text="";B27.text="";B28.text="";B29.text="";B30.text="";
                }
                if(B41.text==""&&B42.text==""&&B43.text==""&&B44.text==""&&B45.text==""&&B46.text==""&&B47.text==""&&B48.text==""&&B49.text==""&&B50.text==""){
                    B41.text=B31.text;B42.text=B32.text;B43.text=B33.text;B44.text=B34.text;B45.text=B35.text;B46.text=B36.text;B47.text=B37.text;B48.text=B38.text;B49.text=B39.text;B50.text=B40.text;
                    B41.background=B31.background;B42.background=B32.background;B43.background=B33.background;B44.background=B34.background;B45.background=B35.background;
                    B46.background=B36.background;B47.background=B37.background;B48.background=B38.background;B49.background=B39.background;B50.background=B40.background;
                    B31.setBackgroundResource(R.drawable.gray);B32.setBackgroundResource(R.drawable.gray);B33.setBackgroundResource(R.drawable.gray);B34.setBackgroundResource(R.drawable.gray);B35.setBackgroundResource(R.drawable.gray);B36.setBackgroundResource(R.drawable.gray);B37.setBackgroundResource(R.drawable.gray);B38.setBackgroundResource(R.drawable.gray);B39.setBackgroundResource(R.drawable.gray);B40.setBackgroundResource(R.drawable.gray);
                    B31.text="";B32.text="";B33.text="";B34.text="";B35.text="";B36.text="";B37.text="";B38.text="";B39.text="";B40.text="";
                }

                if(B51.text==""&&B52.text==""&&B53.text==""&&B54.text==""&&B55.text==""&&B56.text==""&&B57.text==""&&B58.text==""&&B59.text==""&&B60.text==""){

                    B51.text=B41.text;B52.text=B42.text;B53.text=B43.text;B54.text=B44.text;B55.text=B45.text;
                    B56.text=B46.text;B57.text=B47.text;B58.text=B48.text;B59.text=B49.text;B60.text=B50.text;
                    B51.background=B41.background;B52.background=B42.background;B53.background=B43.background;
                    B54.background=B44.background;B55.background=B45.background;B56.background=B46.background;
                    B57.background=B47.background;B58.background=B48.background;B59.background=B49.background;B60.background=B50.background;
                    B41.setBackgroundResource(R.drawable.gray);B42.setBackgroundResource(R.drawable.gray);B43.setBackgroundResource(R.drawable.gray);B44.setBackgroundResource(R.drawable.gray);B45.setBackgroundResource(R.drawable.gray);
                    B46.setBackgroundResource(R.drawable.gray);B47.setBackgroundResource(R.drawable.gray);B48.setBackgroundResource(R.drawable.gray);B49.setBackgroundResource(R.drawable.gray);B50.setBackgroundResource(R.drawable.gray);
                    B41.text="";B42.text="";B43.text="";B44.text="";B45.text="";B46.text="";B47.text="";B48.text="";B49.text="";B50.text="";

                }
                if(B61.text==""&&B62.text==""&&B63.text==""&&B64.text==""&&B65.text==""&&B66.text==""&&B67.text==""&&B68.text==""&&B69.text==""&&B70.text==""){
                            B61.text=B51.text;B62.text=B52.text;B63.text=B53.text;B64.text=B54.text;B65.text=B55.text;
                            B66.text=B56.text;B67.text=B57.text;B68.text=B58.text;B69.text=B59.text;B70.text=B60.text;
                            B61.background=B51.background;B62.background=B52.background;B63.background=B53.background;B64.background=B54.background;B65.background=B55.background;
                            B66.background=B56.background;B67.background=B57.background;B68.background=B58.background;B69.background=B59.background;B70.background=B60.background;
                            B51.setBackgroundResource(R.drawable.gray);B52.setBackgroundResource(R.drawable.gray);B53.setBackgroundResource(R.drawable.gray);B54.setBackgroundResource(R.drawable.gray);B55.setBackgroundResource(R.drawable.gray);
                            B56.setBackgroundResource(R.drawable.gray);B57.setBackgroundResource(R.drawable.gray);B58.setBackgroundResource(R.drawable.gray);B59.setBackgroundResource(R.drawable.gray);B60.setBackgroundResource(R.drawable.gray);
                            B51.text="";B52.text="";B53.text="";B54.text="";B55.text="";B56.text="";B57.text="";B58.text="";B59.text="";B60.text="";


            };lines=6}
            if(lines==6){
                if(B51.text==""&&B52.text==""&&B53.text==""&&B54.text==""&&B55.text==""&&B56.text==""&&B57.text==""&&B58.text==""&&B59.text==""&&B60.text==""){

                B51.text=B41.text;B52.text=B42.text;B53.text=B43.text;B54.text=B44.text;B55.text=B45.text;
                B56.text=B46.text;B57.text=B47.text;B58.text=B48.text;B59.text=B49.text;B60.text=B50.text;
                B51.background=B41.background;B52.background=B42.background;B53.background=B43.background;
                B54.background=B44.background;B55.background=B45.background;B56.background=B46.background;B57.background=B47.background;B58.background=B48.background;B59.background=B49.background;B60.background=B50.background;
                B41.setBackgroundResource(R.drawable.gray);B42.setBackgroundResource(R.drawable.gray);B43.setBackgroundResource(R.drawable.gray);B44.setBackgroundResource(R.drawable.gray);B45.setBackgroundResource(R.drawable.gray);
                B46.setBackgroundResource(R.drawable.gray);B47.setBackgroundResource(R.drawable.gray);B48.setBackgroundResource(R.drawable.gray);B49.setBackgroundResource(R.drawable.gray);B50.setBackgroundResource(R.drawable.gray);
                B41.text="";B42.text="";B43.text="";B44.text="";B45.text="";B46.text="";B47.text="";B48.text="";B49.text="";B50.text="";

            };lines=5}
            if(lines==5){if(B41.text==""&&B42.text==""&&B43.text==""&&B44.text==""&&B45.text==""&&B46.text==""&&B47.text==""&&B48.text==""&&B49.text==""&&B50.text==""){
                B41.text=B31.text;B42.text=B32.text;B43.text=B33.text;B44.text=B34.text;B45.text=B35.text;B46.text=B36.text;B47.text=B37.text;B48.text=B38.text;B49.text=B39.text;B50.text=B40.text;
                B41.background=B31.background;B42.background=B32.background;B43.background=B33.background;B44.background=B34.background;B45.background=B35.background;B46.background=B36.background;B47.background=B37.background;B48.background=B38.background;B49.background=B39.background;B50.background=B40.background;
                B31.setBackgroundResource(R.drawable.gray);B32.setBackgroundResource(R.drawable.gray);B33.setBackgroundResource(R.drawable.gray);B34.setBackgroundResource(R.drawable.gray);B35.setBackgroundResource(R.drawable.gray);B36.setBackgroundResource(R.drawable.gray);B37.setBackgroundResource(R.drawable.gray);B38.setBackgroundResource(R.drawable.gray);B39.setBackgroundResource(R.drawable.gray);B40.setBackgroundResource(R.drawable.gray);
                B31.text="";B32.text="";B33.text="";B34.text="";B35.text="";B36.text="";B37.text="";B38.text="";B39.text="";B40.text="";
            };lines=4}
            if(lines==4){if(B31.text==""&&B32.text==""&&B33.text==""&&B34.text==""&&B35.text==""&&B36.text==""&&B37.text==""&&B38.text==""&&B39.text==""&&B40.text==""){
                B31.text=B21.text;B32.text=B22.text;B33.text=B23.text;B34.text=B24.text;B35.text=B25.text;
                B36.text=B26.text;B37.text=B27.text;B38.text=B28.text;B39.text=B29.text;B40.text=B30.text;
                B31.background=B21.background;B32.background=B22.background;B33.background=B23.background;
                B34.background=B24.background;B35.background=B25.background;B36.background=B26.background;
                B37.background=B27.background;B38.background=B28.background;B39.background=B29.background;
                B40.background=B30.background;
                B21.setBackgroundResource(R.drawable.gray);B22.setBackgroundResource(R.drawable.gray);
                B23.setBackgroundResource(R.drawable.gray);B24.setBackgroundResource(R.drawable.gray);
                B25.setBackgroundResource(R.drawable.gray);B26.setBackgroundResource(R.drawable.gray);
                B27.setBackgroundResource(R.drawable.gray);B28.setBackgroundResource(R.drawable.gray);
                B29.setBackgroundResource(R.drawable.gray);B30.setBackgroundResource(R.drawable.gray);
                B21.text="";B22.text="";B23.text="";B24.text="";B25.text="";B26.text="";B27.text="";B28.text="";B29.text="";B30.text="";
                B31.setBackgroundResource(R.drawable.gray);B32.setBackgroundResource(R.drawable.gray);B33.setBackgroundResource(R.drawable.gray);B34.setBackgroundResource(R.drawable.gray);B35.setBackgroundResource(R.drawable.gray);
                B36.setBackgroundResource(R.drawable.gray);B37.setBackgroundResource(R.drawable.gray);B38.setBackgroundResource(R.drawable.gray);B39.setBackgroundResource(R.drawable.gray);B40.setBackgroundResource(R.drawable.gray);
                B31.text="";B32.text="";B33.text="";B34.text="";B35.text="";B36.text="";B37.text="";B38.text="";B39.text="";B40.text="";

            }
            lines=3;}
            if(lines==3){lines=2}
            if(lines==2){}
        },500)
        point_tallay.text="Points: $points"
    }
    private fun next_shape(){


        b1.setBackgroundResource(R.drawable.gray);b2.setBackgroundResource(R.drawable.gray);b3.setBackgroundResource(R.drawable.gray);b4.setBackgroundResource(R.drawable.gray)
        b5.setBackgroundResource(R.drawable.gray);b6.setBackgroundResource(R.drawable.gray);b7.setBackgroundResource(R.drawable.gray);b8.setBackgroundResource(R.drawable.gray)
        b9.setBackgroundResource(R.drawable.gray);b10.setBackgroundResource(R.drawable.gray);b11.setBackgroundResource(R.drawable.gray);b12.setBackgroundResource(R.drawable.gray)

        val random = Random.nextInt( 1..7)
        when(random){
            1 -> { b9.setBackgroundResource(R.drawable.red);b10.setBackgroundResource(R.drawable.red);b11.setBackgroundResource(R.drawable.red);b12.setBackgroundResource(R.drawable.red)}
            2 -> { b7.setBackgroundResource(R.drawable.orange);b8.setBackgroundResource(R.drawable.orange);b11.setBackgroundResource(R.drawable.orange);b12.setBackgroundResource(R.drawable.orange)}
            3 -> { b8.setBackgroundResource(R.drawable.yellow);b9.setBackgroundResource(R.drawable.yellow);b11.setBackgroundResource(R.drawable.yellow);b12.setBackgroundResource(R.drawable.yellow)}
            4 -> { b7.setBackgroundResource(R.drawable.green);b10.setBackgroundResource(R.drawable.green);b11.setBackgroundResource(R.drawable.green);b12.setBackgroundResource(R.drawable.green)}
            5 -> { b9.setBackgroundResource(R.drawable.blue);b8.setBackgroundResource(R.drawable.blue);b11.setBackgroundResource(R.drawable.blue);b10.setBackgroundResource(R.drawable.blue)}
            6 -> { b8.setBackgroundResource(R.drawable.purple);b10.setBackgroundResource(R.drawable.purple);b11.setBackgroundResource(R.drawable.purple);b12.setBackgroundResource(R.drawable.purple)}
            7 -> { b2.setBackgroundResource(R.drawable.pink);b5.setBackgroundResource(R.drawable.pink);b8.setBackgroundResource(R.drawable.pink);b11.setBackgroundResource(R.drawable.pink)}
        }
        nextUp = random
        if (once ==0){
            b1.setBackgroundResource(R.drawable.gray);b2.setBackgroundResource(R.drawable.gray);b3.setBackgroundResource(R.drawable.gray);b4.setBackgroundResource(R.drawable.gray)
            b5.setBackgroundResource(R.drawable.gray);b6.setBackgroundResource(R.drawable.gray);b7.setBackgroundResource(R.drawable.gray);b8.setBackgroundResource(R.drawable.gray)
            b9.setBackgroundResource(R.drawable.gray);b10.setBackgroundResource(R.drawable.gray);b11.setBackgroundResource(R.drawable.gray);b12.setBackgroundResource(R.drawable.gray)
            b8.setBackgroundResource(R.drawable.yellow);b9.setBackgroundResource(R.drawable.yellow);b11.setBackgroundResource(R.drawable.yellow);b12.setBackgroundResource(R.drawable.yellow)
            nextUp = 4
            once = 1
        }
        if(starting == 0){
            Handler().postDelayed({shapes()}, 1500)
            starting = 1
        }
    }

    private fun shapes(){
        if(B11.text=="0"||B12.text=="0"||B13.text=="0"||B14.text=="0"||B15.text=="0"||B16.text=="0"||B17.text=="0"||B18.text=="0"||B19.text=="0"||B20.text=="0"){
            b1.setBackgroundResource(R.drawable.gray);b2.setBackgroundResource(R.drawable.gray);b3.setBackgroundResource(R.drawable.gray);b4.setBackgroundResource(R.drawable.gray)
            b5.setBackgroundResource(R.drawable.gray);b6.setBackgroundResource(R.drawable.gray);b7.setBackgroundResource(R.drawable.gray);b8.setBackgroundResource(R.drawable.gray)
            b9.setBackgroundResource(R.drawable.gray);b10.setBackgroundResource(R.drawable.gray);b11.setBackgroundResource(R.drawable.gray);b12.setBackgroundResource(R.drawable.gray)
            B4.setBackgroundResource(R.drawable.pink);B5.setBackgroundResource(R.drawable.pink);B6.setBackgroundResource(R.drawable.pink);B7.setBackgroundResource(R.drawable.pink)
        }
        loseAline()
        if(stop == 0) {
            x=0;
            b=0;
            z=0;
            a=0;



            if (B24.text == "0" || B25.text == "0" || B26.text == "0" || B27.text == "0") {nextUp = 7 }
            array.removeAll(array);arrayCollectPreviousOne.removeAll(arrayCollectPreviousOne)
            shape_is = nextUp
            next_shape()
            when(shape_is){
                1 -> { B6.setBackgroundResource(R.drawable.red);B14.setBackgroundResource(R.drawable.red);B15.setBackgroundResource(R.drawable.red);B16.setBackgroundResource(R.drawable.red)}
                2 -> { B5.setBackgroundResource(R.drawable.orange);B6.setBackgroundResource(R.drawable.orange);B16.setBackgroundResource(R.drawable.orange);B17.setBackgroundResource(R.drawable.orange)}
                3 -> { B5.setBackgroundResource(R.drawable.yellow);B6.setBackgroundResource(R.drawable.yellow);B15.setBackgroundResource(R.drawable.yellow);B16.setBackgroundResource(R.drawable.yellow)}
                4 -> { B5.setBackgroundResource(R.drawable.green);B15.setBackgroundResource(R.drawable.green);B16.setBackgroundResource(R.drawable.green);B17.setBackgroundResource(R.drawable.green)}
                5 -> { B5.setBackgroundResource(R.drawable.blue);B6.setBackgroundResource(R.drawable.blue);B14.setBackgroundResource(R.drawable.blue);B15.setBackgroundResource(R.drawable.blue)}
                6 -> { B6.setBackgroundResource(R.drawable.purple);B15.setBackgroundResource(R.drawable.purple);B16.setBackgroundResource(R.drawable.purple);B17.setBackgroundResource(R.drawable.purple)}
                7 -> { B4.setBackgroundResource(R.drawable.pink);B5.setBackgroundResource(R.drawable.pink);B6.setBackgroundResource(R.drawable.pink);B7.setBackgroundResource(R.drawable.pink)}
            }
            list()
        }else{}
    }



    val arrayCollectPreviousOne = arrayListOf<TextView>()
    val array = arrayListOf<TextView>()
    val downArray: ArrayList<TextView> get() = arrayListOf<TextView>(textView,B1,B2,B3,B4,B5,B6,B7,B8,
        B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,B26,B27,B28,B29,B30,B31,B32,
        B33,B34,B35,B36,B37,B38,B39,B40,B41,B42,B43,B44,B45,B46,B47,B48,B49,B50,B51,B52,B53,B54,B55,B56
        ,B57,B58,B59,B60,B61,B62,B63,B64,B65,B66,B67,B68,B69,B70,B71,B72,B73,B74,B75,B76,B77,B78,B79,B80
        ,B81,B82,B83,B84,B85,B86,B87,B88,B89,B90,B91,B92,B93,B94,B95,B96,B97,B98,B99,B100,B101,B102,B103
        ,B104,B105,B106,B107,B108,B109,B110,B111,B112,B113,B114,B115,B116,B117,B118,B119,B120,B121,B122
        ,B123,B124,B125,B126,B127,B128,B129,B130,B131,B132,B133,B134,B135,B136,B137,B138,B139,B140,B141,
        B142,B143,B144,B145,B146,B147,B148,B149,B150)
    var a = 0
    var b = 0
    var c = 0
    var z = 0
    private fun list(){
        right.setOnClickListener{if(a == 0){
            if(num1 != 10&&num1 != 20&&num1 != 30&&num1 != 40&&num1 != 50&&num1 != 60&&num1 != 70&&num1 != 80&&num1 != 90&&num1 != 100&&num1 != 110&&num1 != 120&&num1 != 130&&num1 != 140&&num1 != 150&&
               num2 != 10&&num2 != 20&&num2 != 30&&num2 != 40&&num2 != 50&&num2 != 60&&num2 != 70&&num2 != 80&&num2 != 90&&num2 != 100&&num2 != 110&&num2 != 120&&num2 != 130&&num2 != 140&&num2 != 150&&
               num3 != 10&&num3 != 20&&num3 != 30&&num3 != 40&&num3 != 50&&num3 != 60&&num3 != 70&&num3 != 80&&num3 != 90&&num3 != 100&&num3 != 110&&num3 != 120&&num3 != 130&&num3 != 140&&num3 != 150&&
               num4 != 10&&num4 != 20&&num4 != 30&&num4 != 40&&num4 != 50&&num4 != 60&&num4 != 70&&num4 != 80&&num4 != 90&&num4 != 100&&num4 != 110&&num4 != 120&&num4 != 130&&num4 != 140&&num4 != 150
                &&downArray[num1+1].text==""&&downArray[num2+1].text==""&&downArray[num3+1].text==""&&downArray[num4+1].text==""){num1+=1;num2+=1;num3+=1;num4+=1}
        }
        }
        left.setOnClickListener{ if(b == 0){
            if(num1 != 1&&num1 != 11&&num1 != 21&&num1 != 31&&num1 != 41&&num1 != 51&&num1 != 61&&num1 != 71&&num1 != 81&&num1 != 91&&num1 != 101&&num1 != 111&&num1 != 121&&num1 != 131&&num1 != 141&&
               num2  != 1&&num2 != 11&&num2 != 21&&num2 != 31&&num2 != 41&&num2 != 51&&num2 != 61&&num2 != 71&&num2 != 81&&num2 != 91&&num2 != 101&&num2 != 111&&num2 != 121&&num2 != 131&&num2 != 141&&
               num3 != 1&&num3 != 11&&num3 != 21&&num3 != 31&&num3 != 41&&num3 != 51&&num3 != 61&&num3 != 71&&num3 != 81&&num3 != 91&&num3 != 101&&num3 != 111&&num3 != 121&&num3 != 131&&num3 != 141&&
               num4 != 1&&num4!= 11&&num4!= 21&&num4!= 31&&num4!= 41&&num4!= 51&&num4!= 61&&num4!= 71&&num4!= 81&&num4!= 91&&num4!= 101&&num4!= 111&&num4!= 121&&num4!= 131&&num4!= 141
                &&downArray[num1-1].text==""&&downArray[num2-1].text==""&&downArray[num3-1].text==""&&downArray[num4-1].text==""){num1-=1;num2-=1;num3-=1;num4-=1}
        } }
        rotate_right.setOnClickListener{if(downArray[num1+1].text==""&&downArray[num2+1].text==""&&downArray[num3+1].text==""&&downArray[num4+1].text==""&&
                                            downArray[num1-1].text==""&&downArray[num2-1].text==""&&downArray[num3-1].text==""&&downArray[num4-1].text==""&&
                                            downArray[num1+10].text==""&&downArray[num2+10].text==""&&downArray[num3+10].text==""&&downArray[num4+10].text==""&&
                                            downArray[num1-10].text==""&&downArray[num2-10].text==""&&downArray[num3-10].text==""&&downArray[num4-10].text==""){
            when(shape_is){
                1 -> {if(z==0){num1-=1;num2+=1;num3+=10;num4+=10;z=1};else if(z==1){num1+=0;num2+=0;num3-=9;num4-=2;z=2};
                else if(z == 2){num1-=10;num2-=10;num3-=1;num4+=1;z=3};else{num1+=2;num2+=9;num3+=0;num4+=9;z=0} }
                2 -> { if(z==0){num1+=1;num2+=9;num3+=0;num4+=8;z=1};else{ num1-=1;num2-=9;num3-=0;num4-=8;z=0}}
                3 -> {}
                4 -> {
                    if (z == 0) {
                        num1 += 0;num2 -= 9;num3 -= 1;num4 += 8;z = 1
                    }; else if (z == 1) {
                        num1 += 10;num2 += 19;num3 += 2;num4 += 2;z = 2
                    }
                    else if(z==2){num1-=8;num2+=1;num3+=9;num4+=0;z=3};else{num1-=2;num2-=2;num3-=10;num4-=10;z=0}
                }
                5 -> { if(z==0){num1+=0;num2+=9;num3+=2;num4+=11;z=1};else{num1-=0;num2-=9;num3-=2;num4-=11;z=0}}
                6 -> {if(z==0){num1+=0;num2+=1;num3+=1;num4+=9;z=1};else if(z == 1){num1+=9;num2+=0;num3+=0;num4+=0;z=2};
                else if(z==2){num1-=9;num2-=1;num3-=1;num4+=0;z=3};else{num1+=0;num2+=0;num3+=0;num4-=9;z=0}}
                7 -> {if(z==0){num1+=1;num2+=10;num3+=19;num4+=28;z=1}else{num1-=1;num2-=10;num3-=19;num4-=28;z=0}}
            }

        } }
        down.setOnClickListener{
            while(x==0){
                arrayCollectPreviousOne.add(downArray[num1]);
                arrayCollectPreviousOne.add(downArray[num2]);
                arrayCollectPreviousOne.add(downArray[num3]);
                arrayCollectPreviousOne.add(downArray[num4]);
                num1+=10;num2+=10;num3+=10;num4+=10;
                if(downArray[num1].text=="1"||downArray[num2].text=="1"||downArray[num3].text=="1"||downArray[num4].text=="1"||
                    num1==141|| num1==142|| num1==143|| num1==144|| num1==145|| num1==146|| num1==147|| num1==148|| num1==149|| num1==150||
                    num2==141|| num2==142|| num2==143|| num2==144|| num2==145|| num2==146|| num2==147|| num2==148|| num2==149|| num2==150||
                    num3==141|| num3==142|| num3==143|| num3==144|| num3==145|| num3==146|| num3==147|| num3==148|| num3==149|| num3==150||
                    num4==141|| num4==142|| num4==143|| num4==144|| num4==145|| num4==146|| num4==147|| num4==148|| num4==149|| num4==150){
                    num1-=10;num2-=10;num3-=10;num4-=10;x=1;points+=5
                }
            }

        }
        if(a==0||b==0){
            num1+=10;num2+=10;num3+=10;num4+=10;
        }
        arrayCollectPreviousOne.add(downArray[num1]);
        arrayCollectPreviousOne.add(downArray[num2]);
        arrayCollectPreviousOne.add(downArray[num3]);
        arrayCollectPreviousOne.add(downArray[num4]);
        array.add(downArray[num1]);
        array.add(downArray[num2]);
        array.add(downArray[num3]);
        array.add(downArray[num4]);
        landing();colors()
    }
    var x = 0
     private fun list2(){
         if(downArray[num1-10].text == ""){downArray[num1-10].text="1" }else if(downArray[num1-10].text == "0"){}
         if(downArray[num2-10].text == ""){downArray[num2-10].text="1" }else if(downArray[num2-10].text == "0"){}
         if(downArray[num3-10].text == ""){downArray[num3-10].text="1" }else if(downArray[num3-10].text == "0"){}
         if(downArray[num4-10].text == ""){downArray[num4-10].text="1" }else if(downArray[num4-10].text == "0"){}
         shapes()
     }
    private fun R_L() {
            if (B1.text != "0") {
                B1.setBackgroundResource(R.drawable.gray);
            if (B2.text != "0") {
                B2.setBackgroundResource(R.drawable.gray)
            };if(B3.text != "0") {
                B3.setBackgroundResource(R.drawable.gray)
            };if(B4.text != "0") {
                B4.setBackgroundResource(R.drawable.gray)
            };if(B5.text != "0") {
                B5.setBackgroundResource(R.drawable.gray)
            };if(B6.text != "0") {
                B6.setBackgroundResource(R.drawable.gray)
            };if(B7.text != "0") {
                B7.setBackgroundResource(R.drawable.gray)
            };if(B8.text != "0") {
                B8.setBackgroundResource(R.drawable.gray)
            };if(B9.text != "0") {
                B9.setBackgroundResource(R.drawable.gray)
            };if(B10.text != "0") {
                B10.setBackgroundResource(R.drawable.gray)
            };
            if (B11.text != "0") {
                B11.setBackgroundResource(R.drawable.gray)
            };if (B12.text != "0") {
                B12.setBackgroundResource(R.drawable.gray)
            };if (B13.text != "0") {
                B13.setBackgroundResource(R.drawable.gray)
            };if (B14.text != "0") {
                B14.setBackgroundResource(R.drawable.gray)
            };if (B15.text != "0") {
                B15.setBackgroundResource(R.drawable.gray)
            };if (B16.text != "0") {
                B16.setBackgroundResource(R.drawable.gray)
            };if (B17.text != "0") {
                B17.setBackgroundResource(R.drawable.gray)
            };if (B18.text != "0") {
                B18.setBackgroundResource(R.drawable.gray)
            };if (B19.text != "0") {
                B19.setBackgroundResource(R.drawable.gray)
            };if (B20.text != "0") {
                B20.setBackgroundResource(R.drawable.gray)
            };
            if (B21.text != "0") {
                B21.setBackgroundResource(R.drawable.gray)
            };if (B22.text != "0") {
                B22.setBackgroundResource(R.drawable.gray)
            };if (B23.text != "0") {
                B23.setBackgroundResource(R.drawable.gray)
            };if (B24.text != "0") {
                B24.setBackgroundResource(R.drawable.gray)
            };if (B25.text != "0") {
                B25.setBackgroundResource(R.drawable.gray)
            };if (B26.text != "0") {
                B26.setBackgroundResource(R.drawable.gray)
            };if (B27.text != "0") {
                B27.setBackgroundResource(R.drawable.gray)
            };if (B28.text != "0") {
                B28.setBackgroundResource(R.drawable.gray)
            };if (B29.text != "0") {
                B29.setBackgroundResource(R.drawable.gray)
            };if (B30.text != "0") {
                B30.setBackgroundResource(R.drawable.gray)
            };
            if (B31.text != "0") {
                B31.setBackgroundResource(R.drawable.gray)
            };if (B32.text != "0") {
                B32.setBackgroundResource(R.drawable.gray)
            };if (B33.text != "0") {
                B33.setBackgroundResource(R.drawable.gray)
            };if (B34.text != "0") {
                B34.setBackgroundResource(R.drawable.gray)
            };if (B35.text != "0") {
                B35.setBackgroundResource(R.drawable.gray)
            };if (B36.text != "0") {
                B36.setBackgroundResource(R.drawable.gray)
            };if (B37.text != "0") {
                B37.setBackgroundResource(R.drawable.gray)
            };if (B38.text != "0") {
                B38.setBackgroundResource(R.drawable.gray)
            };if (B39.text != "0") {
                B39.setBackgroundResource(R.drawable.gray)
            };if (B40.text != "0") {
                B40.setBackgroundResource(R.drawable.gray)
            };
            if (B41.text != "0") {
                B41.setBackgroundResource(R.drawable.gray)
            };if (B42.text != "0") {
                B42.setBackgroundResource(R.drawable.gray)
            };if (B43.text != "0") {
                B43.setBackgroundResource(R.drawable.gray)
            };if (B44.text != "0") {
                B44.setBackgroundResource(R.drawable.gray)
            };if (B45.text != "0") {
                B45.setBackgroundResource(R.drawable.gray)
            };if (B46.text != "0") {
                B46.setBackgroundResource(R.drawable.gray)
            };if (B47.text != "0") {
                B47.setBackgroundResource(R.drawable.gray)
            };if (B48.text != "0") {
                B48.setBackgroundResource(R.drawable.gray)
            };if (B49.text != "0") {
                B49.setBackgroundResource(R.drawable.gray)
            };if (B50.text != "0") {
                B50.setBackgroundResource(R.drawable.gray)
            };
            if (B51.text != "0") {
                B51.setBackgroundResource(R.drawable.gray)
            };if (B52.text != "0") {
                B52.setBackgroundResource(R.drawable.gray)
            };if (B53.text != "0") {
                B53.setBackgroundResource(R.drawable.gray)
            };if (B54.text != "0") {
                B54.setBackgroundResource(R.drawable.gray)
            };if (B55.text != "0") {
                B55.setBackgroundResource(R.drawable.gray)
            };if (B56.text != "0") {
                B56.setBackgroundResource(R.drawable.gray)
            };if (B57.text != "0") {
                B57.setBackgroundResource(R.drawable.gray)
            };if (B58.text != "0") {
                B58.setBackgroundResource(R.drawable.gray)
            };if (B59.text != "0") {
                B59.setBackgroundResource(R.drawable.gray)
            };if (B60.text != "0") {
                B60.setBackgroundResource(R.drawable.gray)
            };
            if (B61.text != "0") {
                B61.setBackgroundResource(R.drawable.gray)
            };if (B62.text != "0") {
                B62.setBackgroundResource(R.drawable.gray)
            };if (B63.text != "0") {
                B63.setBackgroundResource(R.drawable.gray)
            };if (B64.text != "0") {
                B64.setBackgroundResource(R.drawable.gray)
            };if (B65.text != "0") {
                B65.setBackgroundResource(R.drawable.gray)
            };if (B66.text != "0") {
                B66.setBackgroundResource(R.drawable.gray)
            };if (B67.text != "0") {
                B67.setBackgroundResource(R.drawable.gray)
            };if (B68.text != "0") {
                B68.setBackgroundResource(R.drawable.gray)
            };if (B69.text != "0") {
                B69.setBackgroundResource(R.drawable.gray)
            };if (B70.text != "0") {
                B70.setBackgroundResource(R.drawable.gray)
            };
            if (B71.text != "0") {
                B71.setBackgroundResource(R.drawable.gray)
            };if (B72.text != "0") {
                B72.setBackgroundResource(R.drawable.gray)
            };if (B73.text != "0") {
                B73.setBackgroundResource(R.drawable.gray)
            };if (B74.text != "0") {
                B74.setBackgroundResource(R.drawable.gray)
            };if (B75.text != "0") {
                B75.setBackgroundResource(R.drawable.gray)
            };if (B76.text != "0") {
                B76.setBackgroundResource(R.drawable.gray)
            };if (B77.text != "0") {
                B77.setBackgroundResource(R.drawable.gray)
            };if (B78.text != "0") {
                B78.setBackgroundResource(R.drawable.gray)
            };if (B79.text != "0") {
                B79.setBackgroundResource(R.drawable.gray)
            };if (B80.text != "0") {
                B80.setBackgroundResource(R.drawable.gray)
            };
            if (B81.text != "0") {
                B81.setBackgroundResource(R.drawable.gray)
            };if (B82.text != "0") {
                B82.setBackgroundResource(R.drawable.gray)
            };if (B83.text != "0") {
                B83.setBackgroundResource(R.drawable.gray)
            };if (B84.text != "0") {
                B84.setBackgroundResource(R.drawable.gray)
            };if (B85.text != "0") {
                B85.setBackgroundResource(R.drawable.gray)
            };if (B86.text != "0") {
                B86.setBackgroundResource(R.drawable.gray)
            };if (B87.text != "0") {
                B87.setBackgroundResource(R.drawable.gray)
            };if (B88.text != "0") {
                B88.setBackgroundResource(R.drawable.gray)
            };if (B89.text != "0") {
                B89.setBackgroundResource(R.drawable.gray)
            };if (B90.text != "0") {
                B90.setBackgroundResource(R.drawable.gray)
            };
            if (B91.text != "0") {
                B91.setBackgroundResource(R.drawable.gray)
            };if (B92.text != "0") {
                B92.setBackgroundResource(R.drawable.gray)
            };if (B93.text != "0") {
                B93.setBackgroundResource(R.drawable.gray)
            };if (B94.text != "0") {
                B94.setBackgroundResource(R.drawable.gray)
            };if (B95.text != "0") {
                B95.setBackgroundResource(R.drawable.gray)
            };if (B96.text != "0") {
                B96.setBackgroundResource(R.drawable.gray)
            };if (B97.text != "0") {
                B97.setBackgroundResource(R.drawable.gray)
            };if (B98.text != "0") {
                B98.setBackgroundResource(R.drawable.gray)
            };if (B99.text != "0") {
                B99.setBackgroundResource(R.drawable.gray)
            };if (B100.text != "0") {
                B100.setBackgroundResource(R.drawable.gray)
            };
            if (B101.text != "0") {
                B101.setBackgroundResource(R.drawable.gray)
            };if (B102.text != "0") {
                B102.setBackgroundResource(R.drawable.gray)
            };if (B103.text != "0") {
                B103.setBackgroundResource(R.drawable.gray)
            };if (B104.text != "0") {
                B104.setBackgroundResource(R.drawable.gray)
            };if (B105.text != "0") {
                B105.setBackgroundResource(R.drawable.gray)
            };if (B106.text != "0") {
                B106.setBackgroundResource(R.drawable.gray)
            };if (B107.text != "0") {
                B107.setBackgroundResource(R.drawable.gray)
            };if (B108.text != "0") {
                B108.setBackgroundResource(R.drawable.gray)
            };if (B109.text != "0") {
                B109.setBackgroundResource(R.drawable.gray)
            };if (B110.text != "0") {
                B110.setBackgroundResource(R.drawable.gray)
            };
            if (B111.text != "0") {
                B111.setBackgroundResource(R.drawable.gray)
            };if (B112.text != "0") {
                B112.setBackgroundResource(R.drawable.gray)
            };if (B113.text != "0") {
                B113.setBackgroundResource(R.drawable.gray)
            };if (B114.text != "0") {
                B114.setBackgroundResource(R.drawable.gray)
            };if (B115.text != "0") {
                B115.setBackgroundResource(R.drawable.gray)
            };if (B116.text != "0") {
                B116.setBackgroundResource(R.drawable.gray)
            };if (B117.text != "0") {
                B117.setBackgroundResource(R.drawable.gray)
            };if (B118.text != "0") {
                B118.setBackgroundResource(R.drawable.gray)
            };if (B119.text != "0") {
                B119.setBackgroundResource(R.drawable.gray)
            };if (B120.text != "0") {
                B120.setBackgroundResource(R.drawable.gray)
            };
            if (B121.text != "0") {
                B121.setBackgroundResource(R.drawable.gray)
            };if (B122.text != "0") {
                B122.setBackgroundResource(R.drawable.gray)
            };if (B123.text != "0") {
                B123.setBackgroundResource(R.drawable.gray)
            };if (B124.text != "0") {
                B124.setBackgroundResource(R.drawable.gray)
            };if (B125.text != "0") {
                B125.setBackgroundResource(R.drawable.gray)
            };if (B126.text != "0") {
                B126.setBackgroundResource(R.drawable.gray)
            };if (B127.text != "0") {
                B127.setBackgroundResource(R.drawable.gray)
            };if (B128.text != "0") {
                B128.setBackgroundResource(R.drawable.gray)
            };if (B129.text != "0") {
                B129.setBackgroundResource(R.drawable.gray)
            };if (B130.text != "0") {
                B130.setBackgroundResource(R.drawable.gray)
            };
            if (B131.text != "0") {
                B131.setBackgroundResource(R.drawable.gray)
            };if (B132.text != "0") {
                B132.setBackgroundResource(R.drawable.gray)
            };if (B133.text != "0") {
                B133.setBackgroundResource(R.drawable.gray)
            };if (B134.text != "0") {
                B134.setBackgroundResource(R.drawable.gray)
            };if (B135.text != "0") {
                B135.setBackgroundResource(R.drawable.gray)
            };if (B136.text != "0") {
                B136.setBackgroundResource(R.drawable.gray)
            };if (B137.text != "0") {
                B137.setBackgroundResource(R.drawable.gray)
            };if (B138.text != "0") {
                B138.setBackgroundResource(R.drawable.gray)
            };if (B139.text != "0") {
                B139.setBackgroundResource(R.drawable.gray)
            };if (B140.text != "0") {
                B140.setBackgroundResource(R.drawable.gray)
            };
            if (B141.text != "0") {
                B141.setBackgroundResource(R.drawable.gray)
            };if (B142.text != "0") {
                B142.setBackgroundResource(R.drawable.gray)
            };if (B143.text != "0") {
                B143.setBackgroundResource(R.drawable.gray)
            };if (B144.text != "0") {
                B144.setBackgroundResource(R.drawable.gray)
            };if (B145.text != "0") {
                B145.setBackgroundResource(R.drawable.gray)
            };if (B146.text != "0") {
                B146.setBackgroundResource(R.drawable.gray)
            };if (B147.text != "0") {
                B147.setBackgroundResource(R.drawable.gray)
            };if (B148.text != "0") {
                B148.setBackgroundResource(R.drawable.gray)
            };if (B149.text != "0") {
                B149.setBackgroundResource(R.drawable.gray)
            };if (B150.text != "0") {
                B150.setBackgroundResource(R.drawable.gray)
            }

        }
    }
    var points = 0
    private fun landing(){
        if(num1==141|| num1==142|| num1==143|| num1==144|| num1==145|| num1==146|| num1==147|| num1==148|| num1==149|| num1==150||
            num2==141|| num2==142|| num2==143|| num2==144|| num2==145|| num2==146|| num2==147|| num2==148|| num2==149|| num2==150||
            num3==141|| num3==142|| num3==143|| num3==144|| num3==145|| num3==146|| num3==147|| num3==148|| num3==149|| num3==150||
            num4==141|| num4==142|| num4==143|| num4==144|| num4==145|| num4==146|| num4==147|| num4==148|| num4==149|| num4==150){array[0].text="0";array[1].text="0";array[2].text="0";array[3].text="0"}
        if (array[0].text == "1"||array[1].text == "1"||array[2].text == "1"||array[3].text == "1"){
            array[0].text="0";array[1].text="0";array[2].text="0";array[3].text="0"
        }
    }
    private fun colors(){
        R_L()
        a=0;b=0;
        arrayCollectPreviousOne[0].setBackgroundResource(R.drawable.gray);
        arrayCollectPreviousOne[1].setBackgroundResource(R.drawable.gray);
        arrayCollectPreviousOne[2].setBackgroundResource(R.drawable.gray);
        arrayCollectPreviousOne[3].setBackgroundResource(R.drawable.gray);
        when(shape_is){
            1 -> {array[0].setBackgroundResource(R.drawable.red);array[1].setBackgroundResource(R.drawable.red);array[2].setBackgroundResource(R.drawable.red);array[3].setBackgroundResource(R.drawable.red);}
            2 -> {array[0].setBackgroundResource(R.drawable.orange);array[1].setBackgroundResource(R.drawable.orange);array[2].setBackgroundResource(R.drawable.orange);array[3].setBackgroundResource(R.drawable.orange);}
            3 -> {array[0].setBackgroundResource(R.drawable.yellow);array[1].setBackgroundResource(R.drawable.yellow);array[2].setBackgroundResource(R.drawable.yellow);array[3].setBackgroundResource(R.drawable.yellow);}
            4 -> {array[0].setBackgroundResource(R.drawable.green);array[1].setBackgroundResource(R.drawable.green);array[2].setBackgroundResource(R.drawable.green);array[3].setBackgroundResource(R.drawable.green);}
            5 -> {array[0].setBackgroundResource(R.drawable.blue);array[1].setBackgroundResource(R.drawable.blue);array[2].setBackgroundResource(R.drawable.blue);array[3].setBackgroundResource(R.drawable.blue);}
            6 -> {array[0].setBackgroundResource(R.drawable.purple);array[1].setBackgroundResource(R.drawable.purple);array[2].setBackgroundResource(R.drawable.purple);array[3].setBackgroundResource(R.drawable.purple);}
            7 -> {array[0].setBackgroundResource(R.drawable.pink);array[1].setBackgroundResource(R.drawable.pink);array[2].setBackgroundResource(R.drawable.pink);array[3].setBackgroundResource(R.drawable.pink);}
        }
        if(array[0].text=="0"&&array[1].text=="0"&&array[2].text=="0"&&array[3].text=="0"){
            points+=15;list2()
        }
        else{
            array.removeAll(array);
            arrayCollectPreviousOne.removeAll(arrayCollectPreviousOne);
            Handler().postDelayed({list()},600)

        }
    }
}