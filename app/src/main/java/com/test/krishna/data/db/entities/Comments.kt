package com.test.krishna.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comments( val postId : Int, val name : String, val email : String) {

    @PrimaryKey ( autoGenerate = false)
    var id : Int ? = null

}
