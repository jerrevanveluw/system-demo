package community.flock.demo.userapi.user;

import community.flock.demo.userapi.user.input.Birthday;
import community.flock.demo.userapi.user.output.User;
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
    ResponseEntity<List<User>> getUsers();

    @ApiOperation("Post a new user with name, and age in years")
    @PostMapping("{userName}")
    ResponseEntity<User> postUser(@PathVariable String userName, @RequestBody Birthday birthday);

}
