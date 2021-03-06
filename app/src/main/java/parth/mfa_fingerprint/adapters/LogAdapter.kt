package parth.mfa_fingerprint.adapters

import android.content.Context
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_log.view.*
import parth.mfa_fingerprint.R
import parth.mfa_fingerprint.helpers.FontManager
import parth.mfa_fingerprint.room.AuthenticationNodeLog
import java.util.*


/**
 * Created by Parth Chandratreya on 13/01/2018.
 */
class LogAdapter(var context: Context, private var logs: List<AuthenticationNodeLog>) : RecyclerView.Adapter<LogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val logsView = inflater.inflate(R.layout.item_log, parent, false)
        // Return a new holder instance
        return ViewHolder(logsView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        // Get the data model based on position
        val log = logs[position]

        val label = holder?.labelView
        label?.text = "${log.label}, ${log.label2}, ${log.label3}"

        val time = holder?.timeView
        val date = Date(log.dateTime)
        val sdf = SimpleDateFormat("dd-MM-yyyy | hh:mm:s")
        time?.text = sdf.format(date).toString()

        val cardIcon = holder?.cardIcon

        if(log.result && log.result2 && log.result3){
            cardIcon?.setTextColor(Color.parseColor("#4caf50"))
            cardIcon?.text = context.resources.getString(R.string.fa_check_circle)
        }

        val iconFont = FontManager().getTypeface(context, FontManager().fa)
        cardIcon?.typeface = iconFont
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        var labelView: TextView? = null
        var timeView: TextView? = null
        var cardIcon: TextView? = null

        init {
            labelView = itemView.labelTextView
            timeView = itemView.timeTextView
            cardIcon = itemView.cardIcon
        }
    }


}