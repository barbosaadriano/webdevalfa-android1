package br.com.avantagem.hellopos1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void calcularIMC(View view) {
        EditText ep = (EditText) findViewById(R.id.etPeso);
        EditText ea = (EditText) findViewById(R.id.etAltura);
        double peso = Double.parseDouble(ep.getText().toString());
        double altura = Double.parseDouble(ea.getText().toString());
        double imc = peso / (altura * altura);
        TextView ti = (TextView) findViewById(R.id.tvImc);
        TextView tr = (TextView) findViewById(R.id.tvResultado);
        ti.setText("" + imc);
        if (imc <= 18.5) {
            tr.setText("Abaixo do peso");
        } else if (imc > 18.5 && imc < 25) {
            tr.setText("Saudável");
        } else if (imc >= 25 && imc <30 ) {
            tr.setText("Peso em excesso");
        } else if (imc >=30  && imc <35) {
            tr.setText("Obesidade grau 1 ");
        } else if (imc >=35 && imc < 40){
            tr.setText("Obsidade grau 2");
        } else if (imc >= 40) {
            tr.setText("Obesidade grau 3");
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
