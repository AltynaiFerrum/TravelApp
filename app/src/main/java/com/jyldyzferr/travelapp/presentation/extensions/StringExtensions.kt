package com.jyldyzferr.travelapp.presentation.extensions

fun String?.firstLetterIsCapitalizedRestSmall(): String =
    if (this == null) String()
    else if (length > 1) substring(0, 1).uppercase() + substring(1).lowercase()
    else if (isNotBlank()) substring(0, 1).uppercase()
    else this