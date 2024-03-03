package com.example.coworks.data.database.appdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coworks.data.database.dao.EmpresaDao;
import com.example.coworks.data.database.dao.OficinaDao;
import com.example.coworks.data.database.dao.ReservaDao;
import com.example.coworks.data.database.dao.RolDao;
import com.example.coworks.data.database.dao.ServicioDao;
import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Empresa;
import com.example.coworks.data.database.model.Oficina;
import com.example.coworks.data.database.model.Reserva;
import com.example.coworks.data.database.model.Rol;
import com.example.coworks.data.database.model.Servicio;
import com.example.coworks.data.database.model.Usuario;

@Database(entities =
        {Rol.class,
        Usuario.class,
        Empresa.class,
        Oficina.class,
        Servicio.class,
        Reserva.class},
        version = 1,
        exportSchema = false
)
public abstract class CoworksDatabase extends RoomDatabase {
    public static CoworksDatabase instance;

    public abstract RolDao rolDao();
    public abstract UsuarioDao usuarioDao();
    public abstract EmpresaDao empresaDao();
    public abstract OficinaDao oficinaDao();
    public abstract ServicioDao servicioDao();
    public abstract ReservaDao reservaDao();

    public static synchronized CoworksDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CoworksDatabase.class, "coworks_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
