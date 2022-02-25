package community.flock.demo.userapi.user.output;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableUser.class)
public interface User {

    @ApiModelProperty(required = true)
    String getName();

    @ApiModelProperty(required = true)
    String getBirthday();

    @Nullable
    UserMetadata getMetadata();

}
