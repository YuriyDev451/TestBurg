package com.gukunov.testburg.common

interface BaseMapper<Input, Output> {
    fun map(input : Input) : Output
}