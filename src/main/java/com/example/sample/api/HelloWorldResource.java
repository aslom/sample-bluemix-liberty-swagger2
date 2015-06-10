package com.example.sample.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@SwaggerDefinition(
		// NOTE: bug in Swagger as BeanConfig seem to replace the values so set in SwaggerBootstrap
//        info = @Info(
//                title = "Hello API",
//                version = "V1.0.0",
//                description = "Hello Service",
//                license = @License(
//                   name = "Apache 2.0", 
//                   url = "http://www.apache.org/licenses/LICENSE-2.0"
//                )
//        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        tags = {
                @Tag(name = "Private", description = "Tag used to denote operations as private")
        }
)
@Path("/hello")
@Api(value = "hello")
@Produces({"application/json"})
public class HelloWorldResource {
 
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Say hello to provided parameter", notes = "Here is notes about this method")
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Invalid parameter supplied"),
	})
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "{ \"hello_output\" : \"" + msg+"\" }";
 
		return Response.status(200).entity(output).build();
 
	}
 
//	public static void main(String[] args) {
//		System.out.println("Hello");
//	}

}
