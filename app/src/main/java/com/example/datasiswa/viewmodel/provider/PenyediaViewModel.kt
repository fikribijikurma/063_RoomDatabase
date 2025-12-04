package com.example.datasiswa.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.datasiswa.repositori.AplikasiSiswa
import com.example.datasiswa.viewmodel.DetailViewModel
import com.example.datasiswa.viewmodel.EntryViewModel
import com.example.datasiswa.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            DetailViewModel(this.createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            EditViewModel(this.createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa)
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory
        .APPLICATION_KEY] as AplikasiSiswa)


