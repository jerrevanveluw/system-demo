package community.flock.demo.userapi.user.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nonnull;

@Value.Immutable
@JsonDeserialize(as = ImmutableUser.class)
@ApiModel("UserBody")
public interface User {

    @Nonnull
    @ApiModelProperty(required = true)
    String getName();

    @Nonnull
    @ApiModelProperty(required = true)
    String getBirthday();

}
