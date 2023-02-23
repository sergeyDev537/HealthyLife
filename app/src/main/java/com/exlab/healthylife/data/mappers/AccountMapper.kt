package com.exlab.healthylife.data.mappers

import com.exlab.healthylife.data.network.models.AccountDto
import com.exlab.healthylife.domain.entities.AccountEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountMapper @Inject constructor(){

    fun mapEntityToDto(accountEntity: AccountEntity): AccountDto{
        return AccountDto(accountEntity.email, accountEntity.password)
    }

    fun mapDtoToEntity(accountDto: AccountDto): AccountEntity{
        return AccountEntity(accountDto.email, accountDto.password)
    }

}