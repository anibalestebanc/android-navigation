package com.anibalc.android.navigation

import android.net.Uri

/**
 * Created by Anibal Cortez on 25-07-22.
 */
object DeppLinkUtils {

    fun createDeepLink(schema: String, host: String): String {
        return "${schema}${host}"
    }

    fun addParams(deppLink: String, params: Map<String, String>): String {
        val uri = Uri.parse(deppLink).buildUpon()
        params.forEach { param ->
            uri.appendQueryParameter(param.key, param.value)
        }
        return uri.build().toString()
    }
}