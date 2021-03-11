package community.flock.demo.userapi.user.output;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nonnull;

@Value.Immutable
@JsonSerialize(as = ImmutableUserMetadata.class)
public interface UserMetadata {

    @ApiModelProperty(required = true)
    String getColor();

}
