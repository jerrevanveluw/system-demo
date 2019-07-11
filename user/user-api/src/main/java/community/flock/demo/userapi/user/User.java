package community.flock.demo.userapi.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nonnull;

@Value.Immutable
@JsonSerialize(as = ImmutableUser.class)
public interface User {

    @Nonnull
    @ApiModelProperty(required = true)
    String getName();

    @Nonnull
    @ApiModelProperty(required = true)
    String getBirthday();

}
