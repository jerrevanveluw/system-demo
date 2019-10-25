package community.flock.demo.app.user

import org.openapitools.client.model.UserMetadata as ExternalUserMetadata

data class UserMetadata(
        val favoriteColour: String? = null
) {

    constructor(userMetadata: ExternalUserMetadata) : this(
            favoriteColour = userMetadata.color
    )

}

internal fun ExternalUserMetadata.internalize() = UserMetadata(this)
