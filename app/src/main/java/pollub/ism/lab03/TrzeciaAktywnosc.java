package pollub.ism.lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static pollub.ism.lab03.MainActivity.KLUCZ_WIADOMOSCI;
import static pollub.ism.lab03.MainActivity.KOD_PROSBY;

public class TrzeciaAktywnosc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trzecia_aktywnosc);

        final Button przyciskWWW = findViewById(R.id.przyciskStronaWWW);
        przyciskWWW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                otworzStrone(v);
            }
        });

        final Button przyciskZadzwon = findViewById(R.id.przyciskTelefon);
        przyciskZadzwon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                zadzwon(v);
            }
        });

        final Button przyciskPowrot1 = findViewById(R.id.przyciskPowrot1);
        przyciskPowrot1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                powrot(v);
            }
        });
    }

    public void otworzStrone(View view){

        Intent intencja = new Intent(Intent.ACTION_VIEW);
        intencja.setData(Uri.parse("https://tomasznowicki.gitbook.io/ism/"));

        try{
            startActivity(intencja);

        }catch (ActivityNotFoundException e){
            Toast.makeText(this,"Brak przeglądarki",Toast.LENGTH_LONG).show();
        }
    }

    public void zadzwon(View view){

        Intent intencja = new Intent(Intent.ACTION_DIAL);

        intencja.setData(Uri.parse("tel:" + 226952900));

        try{
            startActivity(intencja);

        }catch (ActivityNotFoundException e){
            Toast.makeText(this,"Brak możliwości dzwonienia",Toast.LENGTH_LONG).show();
        }

    }

    public void powrot(View view){
        finish();
    }
}