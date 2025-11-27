package com.example.datasiswa.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.sqlite.db.SupportSQLiteOpenHelper

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
    }
}