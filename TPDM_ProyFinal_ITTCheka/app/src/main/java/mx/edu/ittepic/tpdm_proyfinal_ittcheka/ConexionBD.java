package mx.edu.ittepic.tpdm_proyfinal_ittcheka;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anmoz9 on 25/05/16.
 */
public class ConexionBD extends SQLiteOpenHelper {

    public ConexionBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE Materia (" +
                    "idMateria INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nombre VARCHAR(100)" +
                    ")");

            db.execSQL("CREATE TABLE Maestro (" +
                    "idMaestro INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nombre VARCHAR(50)," +
                    "Apellido VARCHAR(50)," +
                    "Departamento VARCHAR(50)," +
                    "Telefono VARCHAR(20)" +
                    ")");


            db.execSQL("CREATE TABLE Edificio (" +
                    "idEdificio INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nombre VARCHAR(100)" +
                    ")");


            db.execSQL("CREATE TABLE Usuario (" +
                    "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nombre VARCHAR(50)," +
                    "Apellido VARCHAR(50)," +
                    "Usuario VARCHAR(50)," +
                    "Contraseña VARCHAR(20)" +
                    ")");


            db.execSQL("CREATE TABLE Aula (" +
                    "idAula INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nombre VARCHAR(100)," +
                    "idEdificio INTEGER," +
                    "FOREIGN KEY(idEdificio) REFERENCES Edificio(idEdificio)" +
                    ")");

            db.execSQL("CREATE TABLE Horario (" +
                    "idHorario INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "idMateria INTEGER," +
                    "idMaestro INTEGER," +
                    "Grupo VARCHAR(50)," +
                    "FOREIGN KEY(idMateria) REFERENCES Materia(idMateria)," +
                    "FOREIGN KEY(idMaestro) REFERENCES Maestro(idMaestro)" +
                    ")");

            db.execSQL("CREATE TABLE Horario_Detalle (" +
                    "idHorarioDetalle INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "DiaSemana VARCHAR(9)," +
                    "idAula INTEGER," +
                    "Hora VARCHAR(5)," +
                    "CantidadHoras INTEGER," +
                    "idHorario INTEGER," +
                    "FOREIGN KEY(idAula) REFERENCES Aula(idAula)," +
                    "FOREIGN KEY(idHorario) REFERENCES Horario(idHorario)" +
                    ")");
            db.execSQL("CREATE TABLE Asistencia (" +
                    "idHorarioDetalle INTEGER," +
                    "Asistio BOOLEAN," +
                    "idAula INTEGER," +
                    "Observaciones VARCHAR(500)," +
                    "Fecha DATE," +
                    "idUsuario INTEGER," +
                    "FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)," +
                    "FOREIGN KEY(idHorarioDetalle) REFERENCES Horario_Detalle(idHorarioDetalle)" +
                    ")");





            db.execSQL("INSERT INTO Usuario(Nombre,Apellido,Usuario,Contraseña) VALUES('Andres','Ortiz','andres','ortiz')");

        }
        catch (SQLiteException sqle){
            System.out.println(sqle.getMessage());
        }
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
