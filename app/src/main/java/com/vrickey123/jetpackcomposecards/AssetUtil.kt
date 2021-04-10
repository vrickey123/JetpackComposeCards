package com.vrickey123.jetpackcomposecards

import android.content.Context
import java.io.IOException
import java.io.InputStream

object AssetUtil {
    const val FILENAME_CARDS = "cards.json"

    fun getJsonFromAsset(context: Context, filename: String) : String {
        var jsonString: String = ""
        try {
            val inputStream: InputStream = context.resources.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace();
        }
        return jsonString
    }
}