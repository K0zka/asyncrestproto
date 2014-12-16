package com.github.k0zka.asyncrestproto.data

import java.util.UUID
import com.github.k0zka.asyncrestproto.model.Person
import java.util.concurrent.Future

public trait PersonDao {
	fun get(id : UUID, callback : (Future<Person>)->Unit)
	fun save(person : Person, callback : (Future<Person>) -> Unit)
}