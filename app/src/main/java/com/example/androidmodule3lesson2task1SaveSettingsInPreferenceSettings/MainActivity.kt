package com.example.androidmodule3lesson2task1SaveSettingsInPreferenceSettings
/*
ДЗ. Задание 1. Среднее
Написать программу для сохранения настроек. Т.е. при новом запуске системы выбранные
настройки не должны меняться. Сами настройки:
1) Язык en/rus (Switch)
2) Gamer nick (EditText)
3) Graphics low/high (Switch)
4) Autosave on/off
 */


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.androidmodule3lesson2task1.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defLang="English"
        val defNick="Nick"
        val defGraphics="Low"
        val defAutosave="Off"

        val preferences=getSharedPreferences("appShPref",Context.MODE_PRIVATE)

        var language:String = preferences.getString("lang",defLang)!!
        sw_lang.text=language
       // tvLang.text=language
        if (language=="English") {
            sw_lang.isChecked=false
        }
        else
        {
            sw_lang.isChecked=true
        }
        var nick:String= preferences.getString("nick",defNick)!!
         et_Nick.setText(nick)
        var graphSettings:String= preferences.getString("graphSettings",defLang)!!
        sw_GraphSettings.text=graphSettings

        if (graphSettings=="High") {
            sw_GraphSettings.isChecked=true
        }
        else
        {
            sw_GraphSettings.isChecked=false
        }

       // tvGrafficSettings.text=graphSettings

        var autoSaveSettings:String= preferences.getString("autoSaveSettings",defLang)!!
        sw_AutoSave.text=autoSaveSettings

        if (autoSaveSettings=="On") {
            sw_AutoSave.isChecked=true
        }
        else
        {
            sw_AutoSave.isChecked=false
        }

        Log.d("mylog","initial settings:")
        Log.d("mylog","language="+language)
        Log.d("mylog","nick="+nick)
        Log.d("mylog","graphSettings="+graphSettings)
        Log.d("mylog","autoSaveSettings="+autoSaveSettings)

            // tvAutosaveSettings.text=autoSaveSettings

        sw_lang.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The switch is enabled/checked
                language = "Russian"

                // Change the app background color
                //root_layout.setBackgroundColor(Color.GREEN)
                          } else {
                // The switch is disabled
                language = "English"

                // Set the app background color to light gray
              //  root_layout.setBackgroundColor(Color.LTGRAY)
            }
            sw_lang.text=language
            preferences.edit().putString("lang",language).apply()

          //  tvLang.text=language

            Log.d("mylog","Lang="+language)
        }

        sw_GraphSettings.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The switch is enabled/checked
                graphSettings= "High"

                // Change the app background color
                //root_layout.setBackgroundColor(Color.GREEN)
            } else {
                // The switch is disabled
                graphSettings = "Low"


            }
            sw_GraphSettings.text=graphSettings
         //   tvGrafficSettings.text=graphSettings

            preferences.edit().putString("graphSettings",graphSettings).apply()
            Log.d("mylog","graphSettings="+graphSettings)
        }

        sw_AutoSave.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The switch is enabled/checked
                autoSaveSettings = "On"

                // Change the app background color
                //root_layout.setBackgroundColor(Color.GREEN)
            } else {
                // The switch is disabled
                autoSaveSettings = "Off"

                // Set the app background color to light gray
                //  root_layout.setBackgroundColor(Color.LTGRAY)
            }
            sw_AutoSave.text=autoSaveSettings
          //  tvAutosaveSettings.text=autoSaveSettings
            preferences.edit().putString("autoSaveSettings",autoSaveSettings).apply()

            Log.d("mylog","autoSaveSettings="+autoSaveSettings)
        }
        et_Nick.setOnClickListener {
            tvApply.setVisibility(View.VISIBLE)
        }
        tvApply.setOnClickListener {
            preferences.edit().putString("nick",et_Nick.text.toString()).apply()
            tvApply.setVisibility(View.INVISIBLE)
        }

    }

}