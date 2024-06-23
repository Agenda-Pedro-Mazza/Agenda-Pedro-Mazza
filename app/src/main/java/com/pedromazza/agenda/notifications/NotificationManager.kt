package com.pedromazza.agenda.notifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class NotificationManager : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                TarefaNotificationService.TAREFA_CHANNEL_ID,
                "Tarefas pendentes",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Notificações frequentes em relação às tarefas pendentes"

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}