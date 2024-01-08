package com.example.sample

import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var cameraM:CameraManager
    private lateinit var powerBtn:ImageButton
    var isFlash = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        powerBtn=findViewById(R.id.power)
        cameraM=getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerBtn.setOnClickListener{flashLightOnRoOff(it)}
    }
    private fun flashLightOnRoOff(v:View?){
        if(!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash=true
            powerBtn.setImageResource(R.drawable.ic_power_on)
            textMassge("Flash Light is 0n",this)
        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash=false
            powerBtn.setImageResource(R.drawable.ic_power_off)
            textMassge("Flash Light is 0ff",this)
        }
    }
    private fun textMassge(s:String,c:Context){
        Toast.makeText(c,s,Toast.LENGTH_LONG).show()
    } 
}

