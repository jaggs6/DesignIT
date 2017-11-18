package xyz.jagdeep.designit.presentation.profile

data class ProfileModel(val fullName: String,
                        val photoUrl: String,
                        val reviewCount: Int,
                        val reviewRating: Float,
                        val bio: String,
                        val followersCount: Int,
                        val followingCount: Int)