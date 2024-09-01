package com.test.krishna.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.krishna.data.db.entities.Comments


@Database (entities = [Comments::class],
    version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract  fun getCommentsDao() : CommentsDao

    companion object {

     private var instance : AppDataBase ? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: buildDatabase(context).also {
                instance = it;
            }
        }

        private fun buildDatabase(context: Context) =

            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "krishna.db"
            ).build()
    }

}