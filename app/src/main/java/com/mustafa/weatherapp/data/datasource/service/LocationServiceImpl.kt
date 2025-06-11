package com.mustafa.weatherapp.data.datasource.service

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.mustafa.weatherapp.data.datasource.remote.mapper.toAppLocation
import com.mustafa.weatherapp.domain.entity.AppLocation
import com.mustafa.weatherapp.domain.provider.LocationProvider
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationServiceImpl(
    private val context: Context,
    private val fusedLocationClient: FusedLocationProviderClient
) : LocationProvider {

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): AppLocation? = suspendCoroutine { continuation ->
        if (!isHasPermissionLocation()) {
            continuation.resume(null)
            return@suspendCoroutine
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener {
                continuation.resume(it.toAppLocation())
            }
            .addOnFailureListener {
                continuation.resume(null)
            }
    }

    private fun isHasPermissionLocation(): Boolean {
        return ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

}
