package community.flock.demo.userapi.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nonnull;

@Value.Immutable
@JsonDeserialize(as = ImmutableUserInfo.class)
public interface UserInfo {

    @Nonnull
    @ApiModelProperty(required = true)
    String getName();

    @Nonnull
    @ApiModelProperty(required = true)
    String getBirthday();

}
