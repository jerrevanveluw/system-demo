package community.flock.demo.userapi.user.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Value.Immutable
@JsonDeserialize(as = ImmutableUser.class)
@ApiModel("UserBody")
public interface User {

    @ApiModelProperty(required = true)
    String getName();

    @ApiModelProperty(required = true)
    String getBirthday();

    @Nullable
    String getColor();

}
