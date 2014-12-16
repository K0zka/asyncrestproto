package com.github.k0zka.asyncrestproto.data

import org.infinispan.AdvancedCache
import java.util.UUID
import com.github.k0zka.asyncrestproto.model.Person
import java.util.concurrent.Future

public class PersonDaoImpl(val cache : AdvancedCache<UUID, Person>) : PersonDao {

	{
		cache.put(UUID.fromString("10215670-8466-11e4-b116-123b93f75cba"),
		          Person(UUID.fromString("10215670-8466-11e4-b116-123b93f75cba"),
		                 "Bob",
		                 "Grabowsky",
		                 "Duct Tape Solutions",
		                 listOf("mouse", "hero")))
	}

	override fun get(id: UUID, callback: (Future<Person>) -> Unit) {
		cache.getAsync(id).attachListener { callback(it) }
	}

	override fun save(person: Person, callback: (Future<Person>) -> Unit) {
		cache.putAsync(person.id, person).attachListener { callback(it) }
	}
}