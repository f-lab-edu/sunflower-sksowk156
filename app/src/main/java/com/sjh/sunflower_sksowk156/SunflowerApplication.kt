package com.sjh.sunflower_sksowk156

import android.app.Application
import android.content.Context
import android.util.Log
import fi.iki.elonen.NanoHTTPD

class SunflowerApplication : Application() {
    var server: TempServer? = null

    override fun onCreate() {
        super.onCreate()
        // 서버 시작
        server = TempServer(this)
        server?.start()
    }

    class TempServer(private val context: Context) : NanoHTTPD(8081) {
        override fun serve(session: IHTTPSession?): Response {
            return try {
                val response =
                    context.assets.open("plants.json").bufferedReader().use { it.readText() }
                newFixedLengthResponse(Response.Status.OK, "application/json", response)
            } catch (e: Exception) {
                Log.e("WEB_SERVER", "Error serving request: ${e.message}")
                newFixedLengthResponse(
                    Response.Status.INTERNAL_ERROR,
                    "text/plain",
                    "Internal Server Error"
                )
            }
        }
    }
}
