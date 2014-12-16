package com.github.k0zka.asyncrestproto.model

import java.util.UUID
import org.hibernate.search.annotations.Field
import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

JsonCreator
public data class Person(JsonProperty("id") val id : UUID,
                         JsonProperty("firstName") Field val firstName : String,
                         JsonProperty("lastName") Field val lastName : String,
                         JsonProperty("company") Field val company : String? = null,
                         JsonProperty("tags") Field val tags : List<String> = listOf())
: Serializable {
}