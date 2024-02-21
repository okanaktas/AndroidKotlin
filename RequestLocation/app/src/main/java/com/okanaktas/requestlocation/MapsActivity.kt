package com.okanaktas.requestlocation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.snackbar.Snackbar
import com.okanaktas.requestlocation.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener

    //izin istemek icin tanımlıyorum
    private lateinit var permissinLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        registerLauncher()
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //locationManager -> konum yoneticimiz, konumla ilgili tum islemleri ele alıyor.
        //locationLisetener -> Konum degisikliklerini dinleyen ve bize haber veren öge, arayuz.

        //casting -> kullanılan servis(LOCATIN_SERVISE) bir LocationManager olduguna eminim.
        locationManager = this.getSystemService(LOCATION_SERVICE) as LocationManager

        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                println("location: " + location.toString())
            }
        }

        //İznin verilip verilmedigini kontrol ettimiz yer
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //İzin isteme kısmı
            //Kullanıcyı bununla ilgili bir mesaj göstermeli miyiz bunu kontrol ediyoruz. Eger bu true donerse kullanıcıya bir mesah gostermemiz gerekiyor ve bununla birlikte izni istememiz gerekiyor. False donerse de izin isteyecegiz ama bunu android kendi belirliyor.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MapsActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Snackbar.make(binding.root, "Permission needed!", Snackbar.LENGTH_INDEFINITE).setAction("Give permission") {
                    //request permission
                    permissinLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }.show()
            } else {
                //request permission
                permissinLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        } else {
            //permissions granted
            //kullanıcının konumunu aldıgımız yer
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
        }


    }

    //
    private fun registerLauncher() {

        //registerLacunher kısmı android tarafından hazır olarak veriliyor ve sonucunda bir boolean donuyor (izin verildi ya da verilmedi)
        permissinLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                //Android izin verildigine emin olunmasını istedigi icin bir kez daha kontrol ediyoruz
                //permission granted
                if (ContextCompat.checkSelfPermission(
                        this@MapsActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
                }
            } else {
                //permission denied
                Toast.makeText(this@MapsActivity, "Permission Needed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}