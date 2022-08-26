package com.greemoid.jokesandquotes.core.data

import com.greemoid.jokesandquotes.data.CommonDataModel

interface ChangeCommonItem {
    suspend fun change(changeStatus: ChangeStatus): CommonDataModel

    class Empty : ChangeCommonItem {
        override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
            throw IllegalStateException("empty change joke called")
        }

    }
}