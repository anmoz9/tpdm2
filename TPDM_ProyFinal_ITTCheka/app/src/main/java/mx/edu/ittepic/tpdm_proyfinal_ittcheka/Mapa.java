package mx.edu.ittepic.tpdm_proyfinal_ittcheka;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mapa extends ActionBarActivity {
    Button uvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        uvp=(Button)findViewById(R.id.button);
        uvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(Mapa.this, Edificio.class);
                startActivity(otraVentana);
            }
        });
    }
}
