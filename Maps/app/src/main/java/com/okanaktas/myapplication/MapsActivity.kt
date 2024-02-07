package com.okanaktas.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.okanaktas.myapplication.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    //konumla ilgili her şeyi yapan şey
    private lateinit var locationManager: LocationManager

    //
    private lateinit var locationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // locationManager konum yöneticimiz, konum ile ilgili tüm işlemleri ele alıyor
        // locationListener, bu konuda bir değişiklik olduğu zaman bize haber veren arayüz


        //locationManager'ı tanımlıyorum yani içerisine cihazın location servisini atıyorum.
        //casting
        locationManager = this.getSystemService(LOCATION_SERVICE) as LocationManager

        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                //her konum değiştiğinde locationu verecek

            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }else{
            //Permission Granted

            //konum güncellemelerini aldığımızı yer. provider->konumu kimin sağlayacığı.
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
        }

        // latitude->Enlem, longitude->Boylam

        var eiffel = LatLng(48.858483011104504, 2.294652958913891)
        mMap.addMarker(MarkerOptions().position(eiffel).title("Eiffel"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eiffel, 14f))

        /*
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
         */
    }
}