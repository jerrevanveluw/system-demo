package community.flock.demo.userapi.user;

import community.flock.demo.userapi.user.output.User;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Api("User")
@Path(value = "/api")
@Produces(MediaType.APPLICATION_JSON)
public interface UserApi {

    @ApiOperation("Get users")
    @GET
    List<User> getUsers();

    @ApiOperation("Get user by name")
    @GET
    @Path("{name}")
    User getUserByName(@PathParam("name") String name);

    @ApiOperation("Post a new user with name, and age in years")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "user", dataTypeClass = community.flock.demo.userapi.user.input.User.class, required = true),
    })
    User postUser( community.flock.demo.userapi.user.input.User user);

}
