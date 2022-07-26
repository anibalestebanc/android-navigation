package com.anibalc.android.navigation

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle

/**
 * Created by Anibal Cortez on 25-07-22.
 */
object DeepLinkHandler {

    fun openDeepLink(context: Context, deepLink: String, bundle: Bundle? = null) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(deepLink)
        }
        val resolveInfo =
            context.packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        bundle?.let {
            intent.putExtras(it)
        }
        resolveInfo?.let {
            context.startActivity(intent)
        }
    }
}