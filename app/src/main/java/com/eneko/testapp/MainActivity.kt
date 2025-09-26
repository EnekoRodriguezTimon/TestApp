package com.eneko.testapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.eneko.testapp.core.navigation.NavigationWrapper
import com.eneko.testapp.ui.theme.TestAppTheme
import com.eneko.testapp.util.BuildTypeChecker
import com.eneko.testapp.util.DeviceChecker
import com.eneko.testapp.util.Event
import com.eneko.testapp.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isRooted = !BuildTypeChecker.isDebug() && DeviceChecker.isDeviceRooted()
        val isEmulator = !BuildTypeChecker.isDebug() && DeviceChecker.isDeviceEmulator()
        if (isRooted || isEmulator) {
            val securityReason = if (isRooted) "Rooted Device" else "Emulator Device"

            Toast.makeText(this, "Security risk detected: $securityReason", Toast.LENGTH_LONG).show()
            finishAffinity()
            return
        }
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle)  {
                    repeatOnLifecycle(state = Lifecycle.State.STARTED){
                        EventBus.events.collect { event ->
                            if (event is Event.Toast){
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                val navController = rememberNavController()
                NavigationWrapper(navController)
            }
        }
    }
}