package com.example.datasiswa.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class SiswaDatabase : RoomDatabase() {

    abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var Instance: SiswaDatabase? = null

        fun getDatabase(context: Context): SiswaDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, SiswaDatabase::class.java,
                    "siswa_database")
                    .build().also { Instance = it }
            }
        }
    }
}