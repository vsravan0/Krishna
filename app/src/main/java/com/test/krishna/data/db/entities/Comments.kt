package com.test.krishna.data.db.entities

import androidx.room.Entity

@Entity
data class Comments( val postId : Int, val name : String, val email : String)
