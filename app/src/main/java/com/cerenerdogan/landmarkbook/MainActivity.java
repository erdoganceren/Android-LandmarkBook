package com.cerenerdogan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    //static Bitmap selectedImages; //Bu her yerden ulaşılabilir.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        ArrayList<String> landmarkNames = new ArrayList<String>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Colosseo");
        landmarkNames.add("London Bridge");

        ArrayList<String> countryNames = new ArrayList<String>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        //Gorselleri bir obje gibi tanımlamak için bu sınıfı kullanıyoruz
        //Drawable klasöründe bulunan görseller için Bitmap Factory
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        //getResources(): Resources'e ulaşmak için.
        //Resources: Kendi uygulamamızdaki R içerisindeki her seye ulaşmak için oluşturulan bir sınıf.
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colosseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseo);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        ArrayList<Bitmap> landmarkImages = new ArrayList<Bitmap>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colosseo);
        landmarkImages.add(londonbridge);

        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);

        listView.setAdapter(arrayAdapter);
        //Bir row'a tıklandığında ne olacak:
        //Bir aksiyon olduğunda, ne çağrılacak: Listener dinliyor.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("landmark",landmarkNames.get(position));
                intent.putExtra("country",countryNames.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));
                startActivity(intent);
            }
        });
    }
}