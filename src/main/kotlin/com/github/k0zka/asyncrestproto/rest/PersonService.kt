package com.github.k0zka.asyncrestproto.rest

import com.github.k0zka.asyncrestproto.data.PersonDao
import javax.ws.rs.Path
import javax.ws.rs.GET
import java.util.UUID
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.Consumes
import javax.ws.rs.container.Suspended
import javax.ws.rs.container.AsyncResponse
import javax.ws.rs.POST
import com.github.k0zka.asyncrestproto.model.Person

Path("/person/")
Produces(MediaType.APPLICATION_JSON)
Consumes(MediaType.APPLICATION_JSON)
trait PersonService {
	GET
	Path("/{id}")
	fun get( PathParam("id") id : UUID, Suspended response : AsyncResponse )

	POST
	Path("/{id}")
	fun save( person : Person?, Suspended response : AsyncResponse )

}