package com.example.mobilprogramlamaodev2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ToneGenerator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Enes Talha Çelik
    //1 KIRMIZI 2 SARI 3 MAVİ 4 YEŞİL
    //Oyunun başında [1 , 4] arasında rastgele bir sayı belirlenecek
    //belirlenen sayı listenin sonuna eklenecek ve melodi sırayla çalınacak
    //kullanıcı her butona bastığında listedeki o sıradaki sayı ile kullanıcının buton seçimi
    //karşılaştırılacak
    //doğru ise listeye yeni bir sayı eklenecek yanlış ise oyun sona erecek.


    List<Integer> RenkSira = new ArrayList<Integer>();
    Random rastgeleSayi = new Random();
    int mevcutSira=0;
    int kulaniciSkor = 0;
    int yuksekSkor= 0;
    private ToneGenerator toneGenerator;



    public static void changeImageButtonDrawable(ImageButton imageButton, int drawableResId) {
        imageButton.setImageResource(drawableResId);
    }

    private void listeyeRastgeleSayiEkle(){
        int rastInt = rastgeleSayi.nextInt(3)+1;//rastgele fonk. 0'dan itibaren rastegele sayı ürettiği
        //için +1 ekliyoruz
        RenkSira.add(rastInt);//add metodu listenin sonuna ekliyor
    }


    private void kullaniciKarsilastir(int renk){
        //her butona basıldığında mevcut sıradaki numara karşılaştırılacak ve bakılacak sıra numarası arttırılacak
        if(RenkSira.get(mevcutSira) == renk){
            mevcutSira++;
        }
        else{
            mevcutSira = 0;
            RenkSira.clear();
        }
        if(mevcutSira>RenkSira.size()){
            //listeye yeni item ekleyeceksin. skoru arttıracaksın kazanma fonk
            listeyeRastgeleSayiEkle();
            kulaniciSkor +=1;
            mevcutSira = 0;
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnSari =   findViewById(R.id.sariButton);

    }





}