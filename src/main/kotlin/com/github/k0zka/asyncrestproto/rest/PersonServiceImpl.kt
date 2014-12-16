package com.github.k0zka.asyncrestproto.rest

import com.github.k0zka.asyncrestproto.data.PersonDao
import java.util.UUID
import javax.ws.rs.container.AsyncResponse
import com.github.k0zka.asyncrestproto.model.Person
import javax.ws.rs.core.Response
import javax.ws.rs.core.Response.ResponseBuilder
import javax.ws.rs.core.Response.Status
import org.slf4j.LoggerFactory

public class PersonServiceImpl(val dao: PersonDao) : PersonService {
	class object {
		val logger = LoggerFactory.getLogger(javaClass<PersonServiceImpl>())!!
	}
	override fun get(id: UUID, response: AsyncResponse) {
		dao.get(id, {
			if (it.isDone()) {
				val result = it.get()
				if(result == null) {
					response.resume(Response.status(Status.NOT_FOUND).build())
				} else {
					response.resume(result)
				}
			} else {
				logger.info("Request for object {} timed out", id)
				response.resume(Response.status(Status.REQUEST_TIMEOUT).build())
			}
		})
	}

	override fun save(person: Person?, response: AsyncResponse) {
		dao.save(person!!, { response.resume(it.get()) })
	}
}