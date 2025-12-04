package com.example.datasiswa.repositori

import android.app.Application
import android.content.Context
import com.example.datasiswa.room.SiswaDatabase

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context): ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa (
            SiswaDatabase.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerDataApp(this)
    }
}

