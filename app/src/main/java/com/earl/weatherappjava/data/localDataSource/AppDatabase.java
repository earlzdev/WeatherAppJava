package com.earl.weatherappjava.data.localDataSource;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.earl.weatherappjava.data.localDataSource.entities.CurrentWeatherDbEntity;

/**
 * В данном классе присутствуют зависимости из androidx и android, чего быть не должно
 * Как правило, в фиче-модульной архитектуре, экземпляр класса, отвечающий за инстанс БД, создается в отдельном модуле,
 * благодаря чему принципы clean architecture в feature-модуле не нарушаются. В этом приложении строго следовать принципам клина
 * не вижу смысла, однако для понимания зафиксирую это здесь.
 */

@Database(
        entities = {
                CurrentWeatherDbEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

        private static final String DB_NAME = "AppDb";
        private static AppDatabase instance;

        public abstract WeatherDao weatherDao();

        public static AppDatabase getInstance(Application context) {
                if (instance == null) {
                        synchronized (AppDatabase.class) {
                                if (instance == null) {
                                        instance = Room.databaseBuilder(context.getApplicationContext(),
                                                AppDatabase.class, DB_NAME).build();
                                }
                        }
                }
                return instance;
        }
}
