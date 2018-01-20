package parth.mfa_fingerprint.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*



/**
 * Created by Parth Chandratreya on 13/01/2018.
 */
    @Entity
    data class AuthenticationNodeLog(@ColumnInfo(name = "label") var label: String = "",
                                     @ColumnInfo(name = "result") var result: Boolean = false,
                                     @ColumnInfo(name = "date") var dateTime: Long = Date().time) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

