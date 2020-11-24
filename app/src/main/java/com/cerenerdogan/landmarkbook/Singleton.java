package com.cerenerdogan.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
    //Sadece tek bir obje oluşturmak için.
    //Böylece hangi aktivitede oluşturursam oluşturayım tek bir obje ile çalışıyoruz.

    private Bitmap chosenImage;
    private static Singleton singleton;

    private Singleton(){
        //Bir obje oluşturulduğunda bu sınıftan, çağrılacak ilk metottur.
    }

    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public static Singleton getInstance(){
        //O sınıfın objesini al:getInstance()
        if(singleton == null){
            //singleton boşsa yani ilk defa çağrılıyorsa;
            singleton = new Singleton();//Yeni singleton oluştur.
        }
        return singleton;//Değilse zaten oluşturulmuş singleton'u dondur.
    }
}
