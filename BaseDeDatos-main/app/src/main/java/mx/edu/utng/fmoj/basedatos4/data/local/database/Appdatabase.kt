package mx.edu.utng.fmoj.basedatos4.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.edu.utng.fmoj.basedatos4.data.local.entity.PostEntity
import mx.edu.utng.fmoj.databasae4.data.local.dao.PostDao


@Database(entities = [PostEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    // Puedes agregar más DAOs según tus necesidades

    //Singleton para la base de datos
    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
            }
            return instance!!
        }
    }
}