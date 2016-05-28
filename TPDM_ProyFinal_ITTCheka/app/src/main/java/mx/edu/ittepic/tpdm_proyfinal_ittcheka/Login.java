package mx.edu.ittepic.tpdm_proyfinal_ittcheka;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login extends ActionBarActivity {
        EditText usu,con;
    ImageButton entrar;
    ConexionBD conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usu=(EditText)findViewById(R.id.editText);
        con=(EditText)findViewById(R.id.editText2);
        entrar=(ImageButton)findViewById(R.id.imageButton);
        conexion=new ConexionBD(this,"BD",null,1);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SQLiteDatabase base = conexion.getReadableDatabase();
                    String SQL ="SELECT * FROM Usuario WHERE Usuario='"+usu.getText().toString()
                            +"' AND Contraseña='"+con.getText().toString()+"'";
                    Cursor resultado = base.rawQuery(SQL,null);
                    if(resultado.moveToFirst()){
                        Intent otraVentana = new Intent(Login.this, Menu.class);
                        startActivity(otraVentana);
                    }
                    else{
                        AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                        alerta.setTitle("Error");
                        alerta.setMessage("Verifique sus datos").show();

                    }

                }catch (SQLiteException sqle){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                    alerta.setTitle("Error");
                    alerta.setMessage(sqle.getMessage()).show();
                }
                }
            });
    }
}
