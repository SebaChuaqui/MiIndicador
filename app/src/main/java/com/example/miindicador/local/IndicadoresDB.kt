package com.example.miindicador.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [IndicadoresEntity::class], version = 1)
@TypeConverters(HeightTypeConverter::class)
abstract class IndicadoresDBClient : RoomDatabase() {
    abstract fun indicadoresDao(): IndicadoresDao

    companion object {
        @Volatile
        private var INSTANCE: IndicadoresDBClient? = null
        fun getDatabase(context: Context): IndicadoresDBClient {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, IndicadoresDBClient::class.java,
                        "indicadoresBd")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}