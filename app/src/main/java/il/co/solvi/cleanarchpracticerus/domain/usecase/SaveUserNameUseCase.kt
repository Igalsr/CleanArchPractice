package il.co.solvi.cleanarchpracticerus.domain.usecase

import il.co.solvi.cleanarchpracticerus.domain.model.NickName
import il.co.solvi.cleanarchpracticerus.domain.repository.UserRepo

class SaveUserNameUseCase(private val userRepo: UserRepo) {

    fun execute(name: NickName): Boolean {

        var isSuccess = false
        if (userRepo.getName().firstName != name.nickName){
            isSuccess = userRepo.saveName(name)
        }
        return isSuccess
    }
}