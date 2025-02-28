package fr.isen.colombaudgracia.isensmartcompanion.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.colombaudgracia.isensmartcompanion.R
import fr.isen.colombaudgracia.isensmartcompanion.ui.theme.ISENSmartCompanionTheme

@Composable
fun MainScreen(innerPadding : PaddingValues) {

    // Current page
    val context = LocalContext.current

    // Variable to memorize the User Input value
    val userInput = remember { mutableStateOf("") }

    // Variable used to display the AI's response
    val aiResponse = remember { mutableStateOf("") }

    // Column to organize the ordering of the page
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ISEN Logo Image
        Image(painterResource(R.drawable.isen_logo), context.getString(R.string.isen_logo))

        // Text to make a little space between the ISEN Logo and the Application Name
        Text("")

        // Text displaying the application name
        Text(context.getString(R.string.app_name))

        // Text to make another little space between the Application Name and the AI's Response
        Text("")

        // Text that will display the AI's response
        // Is also used as a big space, to set the user input at the bottom of the screen
        Text(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5F),
            text = "AI's Response : \n" + aiResponse.value
        )

        // Row necessary to align the user input section and the submitting button
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .background(Color.LightGray, RoundedCornerShape(50))
        ) {

            // Text Field that will be used by the user to ask questions to the AI
            TextField(
                modifier = Modifier
                    .weight(1F),
                value = userInput.value,
                onValueChange = { newValue ->
                    userInput.value = newValue
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            // Button to submit a question to the AI and to display the AI's response
            OutlinedButton(
                modifier = Modifier.background(Color.Red, RoundedCornerShape(50)),
                onClick = {
                    if(userInput.value != "") {
                        aiResponse.value = "Your question has been submitted."
                    }
                    else {
                        aiResponse.value = "You have not written any question."
                    }
                    Toast.makeText(context, "Question submitted", Toast.LENGTH_LONG).show()
                },
                content = { Image(painterResource(R.drawable.send_logo), context.getString(R.string.send_logo)) }
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ISENSmartCompanionTheme {
        MainScreen(PaddingValues(8.dp))
    }
}