package parth.mfa_fingerprint.room

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by Parth Chandratreya on 13/01/2018.
 */
@Dao
interface AuthenticationNodeLogDAO {

    @Query("select * from AuthenticationNodeLog order by date desc")
    fun getAllLogs(): List<AuthenticationNodeLog>

    @Query("delete from AuthenticationNodeLog")
    fun deleteAllLogs()

    @Insert(onConflict = REPLACE)
    fun insertLog(task: AuthenticationNodeLog)

    @Update(onConflict = REPLACE)
    fun updateLog(task: AuthenticationNodeLog)

    @Delete
    fun deleteLog(task: AuthenticationNodeLog)
}