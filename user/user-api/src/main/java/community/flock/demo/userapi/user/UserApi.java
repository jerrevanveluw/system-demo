package community.flock.demo.userapi.user;

import community.flock.demo.userapi.user.input.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api("User")
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public interface UserApi {

    @ApiOperation("Get users")
    @GetMapping
    ResponseEntity<List<community.flock.demo.userapi.user.output.User>> getUsers();

    @ApiOperation("Get user by name")
    @GetMapping("{name}")
    ResponseEntity<community.flock.demo.userapi.user.output.User> getUserByName(@PathVariable String name);

    @ApiOperation("Post a new user with name, and age in years")
    @PostMapping
    ResponseEntity<community.flock.demo.userapi.user.output.User> postUser(@RequestBody User userInfo);

}
