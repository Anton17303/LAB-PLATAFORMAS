package com.uvg.lab5


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.lab5.ui.theme.Lab5Theme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    private val usuariosValidos = mapOf("usuario1" to "contraseña1", "usuario2" to "contraseña2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var usuario by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var isLoggedIn by remember { mutableStateOf(false) }

                    if (isLoggedIn) {
                        // Usuario ya ha iniciado sesión, muestra la pantalla de inicio

                    } else {
                        // Pantalla de inicio de sesión
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Inicio de Sesión",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            OutlinedTextField(
                                value = usuario,
                                onValueChange = { usuario = it },
                                label = { Text("Usuario") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Contraseña") },
                                visualTransformation = PasswordVisualTransformation(),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    if (validarCredenciales(usuario, password)) {
                                        isLoggedIn = true
                                    } else {
                                        // Las credenciales no son válidas, muestra un mensaje de error
                                        // (puedes usar un Snackbar aquí)
                                        // Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Iniciar Sesión")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun validarCredenciales(usuario: String, password: String): Boolean {
        // Verifica si las credenciales son válidas
        return usuariosValidos.containsKey(usuario) && usuariosValidos[usuario] == password
    }

    @Preview(showBackground = true)
    @Composable
    fun LoginPreview() {
        Lab5Theme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                var usuario by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var isLoggedIn by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Inicio de Sesión",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = usuario,
                        onValueChange = { usuario = it },
                        label = { Text("Usuario") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            if (validarCredenciales(usuario, password)) {
                                isLoggedIn = true
                            } else {
                                // Las credenciales no son válidas, muestra un mensaje de error
                                // (puedes usar un Snackbar aquí)
                                // Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Iniciar Sesión")
                    }
                }
            }
        }
    }
}





