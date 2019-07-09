package community.flock.demo.userapi.user.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nonnull;

@Value.Immutable
@JsonDeserialize(as = ImmutableBirthday.class)
public interface Birthday {

    @Nonnull
    @ApiModelProperty(required = true)
    Integer getYear();

    @Nonnull
    @ApiModelProperty(required = true)
    Integer getMonth();

    @Nonnull
    @ApiModelProperty(required = true)
    Integer getDay();

}
