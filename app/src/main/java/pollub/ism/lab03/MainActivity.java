package pollub.ism.lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String KLUCZ_WIADOMOSCI = "Przekazywana informacja";
    public static int KOD_PROSBY = 123;

    //Uchwyty widoków
    private EditText wiadomoscWychodzaca = null, wiadomoscPrzychodzaca = null;

    public void uruchomDruga(View view){
        String wiadomosc = wiadomoscWychodzaca.getText().toString();

        Intent intencja = new Intent(this, DrugaAktywnosc.class);
        intencja.putExtra(KLUCZ_WIADOMOSCI, wiadomosc);
        this.startActivityForResult(intencja,KOD_PROSBY);
    }

    public void uruchomTrzecia(View view) {

        Intent intencja = new Intent(this, TrzeciaAktywnosc.class);
        startActivity(intencja);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Podłaczenie uchwytów
        wiadomoscWychodzaca = (EditText) findViewById(R.id.wiadomoscWysylanie);
        wiadomoscPrzychodzaca = (EditText) findViewById(R.id.wiadomoscOdbieranie);

        wiadomoscPrzychodzaca.setEnabled(false);

        //Podłączenie przycisków do metod działania

        final Button przyciskDrugi = findViewById(R.id.przyciskDruga);
        przyciskDrugi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                uruchomDruga(v);
            }
        });

        final Button przyciskTrzeci = findViewById(R.id.przyciskTrzecia);
        przyciskTrzeci.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                uruchomTrzecia(v);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == KOD_PROSBY){
            String wiadomosc = data.getStringExtra(KLUCZ_WIADOMOSCI);
            wiadomoscPrzychodzaca.setText(wiadomosc);
        }

    }

}