package mx.edu.utng.fmoj.databasae4.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import mx.edu.utng.fmoj.basedatos4.data.local.entity.PostEntity


@Dao
interface PostDao {
    @Query("SELECT * FROM posts ORDER BY id DESC")
    suspend fun getAll(): List<PostEntity>

    @Insert
    suspend fun insert(post: PostEntity)

    @Delete
    suspend fun delete(post: PostEntity)
}