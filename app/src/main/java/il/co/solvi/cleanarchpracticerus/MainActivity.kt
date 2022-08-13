package il.co.solvi.cleanarchpracticerus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import il.co.solvi.cleanarchpracticerus.data.repository.UserRepoImpl
import il.co.solvi.cleanarchpracticerus.domain.usecase.GetUserNameUseCase
import il.co.solvi.cleanarchpracticerus.domain.usecase.SaveUserNameUseCase
import il.co.solvi.cleanarchpracticerus.ui.screens.InteractionScreen
import il.co.solvi.cleanarchpracticerus.ui.theme.CleanArchPracticeRUSTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The better way would be to use DI & VM
        val userRepo = UserRepoImpl(applicationContext)
        val saveUserNameUseCase = SaveUserNameUseCase(userRepo)
        val getUserNameUseCase = GetUserNameUseCase(userRepo)

        setContent {
            CleanArchPracticeRUSTheme {
                InteractionScreen(
                    saveUserNameUseCase,
                    getUserNameUseCase,
                )
            }
        }
    }
}

