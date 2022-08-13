package il.co.solvi.cleanarchpracticerus.domain.usecase

import il.co.solvi.cleanarchpracticerus.domain.model.UserName
import il.co.solvi.cleanarchpracticerus.domain.repository.UserRepo

class GetUserNameUseCase(private val userRepo: UserRepo) {

    fun execute(): UserName {
        return userRepo.getName()
    }
}