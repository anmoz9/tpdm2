package mx.edu.ittepic.tpdm_proyfinal_ittcheka;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Menu extends ActionBarActivity {
    ListView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu=(ListView)findViewById(R.id.listView);
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:Intent otraVentana = new Intent(Menu.this, Mapa.class);
                        startActivity(otraVentana);
                        break;
                    case 1:
                        break;
                    case 2:Intent otraVentana2 = new Intent(Menu.this, Login.class);
                        startActivity(otraVentana2);
                        break;
                }
            }
        });
    }
}
