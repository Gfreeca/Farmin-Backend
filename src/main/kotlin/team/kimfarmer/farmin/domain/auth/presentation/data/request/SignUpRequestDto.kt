package team.kimfarmer.farmin.domain.auth.presentation.data.request

import io.swagger.annotations.ApiModelProperty

data class SignUpRequestDto(
        @ApiModelProperty(
                name = "name"
                , example = "유저이름"
        )
        val name: String,

        @ApiModelProperty(
                name = "phoneNumber"
                , example = "01012345678"
        )
        val phoneNumber: String,

        @ApiModelProperty(
                name = "id"
                , example = "유저아이디"
        )
        val id: String,

        @ApiModelProperty(
                name = "password"
                , example = "유저 비밀번호"
        )
        val password: String,

        @ApiModelProperty(
                name = "location"
                , example = "주소"
        )
        val location: String,

        @ApiModelProperty(
                name = "profileImg"
                , example = "프로필 사진"
        )
        val profileImg: String,

        @ApiModelProperty(
                name = "description"
                , example = "자기 소개"
        )
        val description: String
)
