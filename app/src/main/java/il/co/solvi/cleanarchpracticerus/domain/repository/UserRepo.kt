package il.co.solvi.cleanarchpracticerus.domain.repository

import il.co.solvi.cleanarchpracticerus.domain.model.NickName
import il.co.solvi.cleanarchpracticerus.domain.model.UserName

interface UserRepo {

    fun saveName(name: NickName) : Boolean

    fun getName(): UserName

}