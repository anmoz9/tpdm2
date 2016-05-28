package mx.edu.ittepic.tpdm_proyfinal_ittcheka;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Edificio extends ActionBarActivity {
    ListView edificio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edificio);
        edificio=(ListView)findViewById(R.id.listView2);
        edificio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:Intent otraVentana = new Intent(Edificio.this, Aula.class);
                        startActivity(otraVentana);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }
}
