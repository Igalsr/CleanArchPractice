package il.co.solvi.cleanarchpracticerus.data.repository

import android.content.Context
import android.content.SharedPreferences
import il.co.solvi.cleanarchpracticerus.domain.model.NickName
import il.co.solvi.cleanarchpracticerus.domain.model.UserName
import il.co.solvi.cleanarchpracticerus.domain.repository.UserRepo

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NICK_NAME = "nickName" // Using just a nick name for this sample
private const val KEY_LAST_NAME = "lastName" // Implement later
private const val DEFAULT_LAST_NAME = ""

class UserRepoImpl(
    context: Context
) : UserRepo {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(name: NickName): Boolean {
        sharedPreferences.edit().putString(KEY_NICK_NAME, name.nickName).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_NICK_NAME,"") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return UserName(firstName, lastName)
    }
}