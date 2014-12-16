package com.github.k0zka.asyncrestproto.rest

import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import org.junit.Test
import org.mockito.Mock
import com.github.k0zka.asyncrestproto.data.PersonDao
import org.junit.Before
import org.mockito.Mockito
import java.util.UUID
import com.github.k0zka.asyncrestproto.model.Person
import javax.ws.rs.container.AsyncResponse
import org.mockito.Matchers
import java.util.concurrent.Future

RunWith( javaClass<MockitoJUnitRunner>())
public class PersonServiceImplTest {

	Mock
	var dao : PersonDao? = null

	var service : PersonService? = null

	Mock
	var callback : ((Future<Person>) -> Unit)? = null

	Mock
	var async : AsyncResponse? = null

	Before fun setup() {
		service = PersonServiceImpl(dao!!)
	}

	Test fun get() {
		val id = UUID.randomUUID()
		val person = Person(id, "Jakob", "Gesso", "Duct Tape Solutions Inc", listOf("foo", "bar"))
//		Mockito.`when`(dao?.get( Matchers.eq(id) ?: id, Matchers.any<((Future<Person>) -> Unit)>() ?: callback!! ))
//				.thenAnswer( { callback!!(person) } )
		service?.get(id, async!!)

		Mockito.verify(async!!).resume(Matchers.eq(person))

	}
}