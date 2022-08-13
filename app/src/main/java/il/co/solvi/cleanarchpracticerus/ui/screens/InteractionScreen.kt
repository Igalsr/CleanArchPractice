package il.co.solvi.cleanarchpracticerus.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import il.co.solvi.cleanarchpracticerus.domain.model.NickName
import il.co.solvi.cleanarchpracticerus.domain.usecase.GetUserNameUseCase
import il.co.solvi.cleanarchpracticerus.domain.usecase.SaveUserNameUseCase

@Composable
fun InteractionScreen(
    saveUserNameUseCase: SaveUserNameUseCase? = null, // Nullable for compose preview simple usage
    getUserNameUseCase: GetUserNameUseCase? = null    // Nullable for compose preview simple usage
) {

    val savedData = remember { mutableStateOf("") }
    val onGetDataClick = {
        val userName = getUserNameUseCase?.execute()
        userName?.let {
            savedData.value = "${userName.firstName} ${userName.lastName}"
        }
    }

    val context = LocalContext.current
    val onSaveClick = { nickName: NickName ->
        val saveSuccess = saveUserNameUseCase?.execute(nickName) ?: false
        if(saveSuccess){
            Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Failed!", Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text to display save data
        Text(
            modifier = Modifier
                .padding(top = 40.dp, start = 32.dp, end = 32.dp)
                .fillMaxWidth(),
            text = savedData.value.ifEmpty { "Save Some Data..." }
        )

        // Button to get new data in non reactive way
        Button(
            modifier = Modifier.padding(top = 24.dp),
            onClick = { onGetDataClick() },
        ) {
            Text("Get Data")
        }

        // Edit Text
        var inputText by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.padding(top = 52.dp),
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Data to save") },
            placeholder = { Text("Insert Name") }
        )

        // Save Button
        Button(
            modifier = Modifier.padding(top = 24.dp),
            onClick = { onSaveClick(NickName(inputText)) },
        ) {
            Text("Save Data")
        }
    }
}

@Preview
@Composable
fun InteractionScreenPreview() {
    InteractionScreen()
}