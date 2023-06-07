package org.d3if3038.mindfinderadmin.model


data class PersonalityEntity (
    var id: Long? = 0L,
    var documentId: String? = "",
    var fullName: String? = "",
    var age: Int? = 0,
    var isMale: Boolean? = false,
    var personalityType: PersonalityCategories? = PersonalityCategories.TYPE_D,
    var date: Long? = System.currentTimeMillis()
)
