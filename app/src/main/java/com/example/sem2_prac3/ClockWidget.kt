package com.example.sem2_prac3

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class ClockWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    var calendar = Calendar.getInstance()
    var simpleDateFormat = SimpleDateFormat("E, LLL dd ")

    var dateTime = simpleDateFormat.format(calendar.time).toString()

    val views = RemoteViews(context.packageName, R.layout.clock_widget)
    views.setTextViewText(R.id.txtFormat, dateTime)
// Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
}
