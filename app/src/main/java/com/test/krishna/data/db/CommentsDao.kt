package com.test.krishna.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.krishna.data.db.entities.Comments

@Dao
interface CommentsDao {


    @Insert
    fun insertComments(commetsList : List<Comments>)

    @Query("select * from Comments")
    fun getComments() : List<Comments>
}