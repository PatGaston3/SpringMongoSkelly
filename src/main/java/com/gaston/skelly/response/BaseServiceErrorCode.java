package com.gaston.skelly.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BaseServiceErrorCode {
    // AUTH ERRORS
    INVALID_CREDENTIALS_ERROR("AUERR001", "Invalid email/password."),
    SOCIAL_LOGIN_ERROR("AUERR002", "This email is associated with a google account. Please use the Google Single Sign-on Feature."),
    EMAIL_ALREADY_EXISTS("AUERR003", "Account with that email already exists."),


    // CREDENTIAL VALIDATION ERRORS
    EMAIL_VALIDATION_ERROR("CVERR001", "Email failed validation."),
    EMAIL_EXISTS_ERROR("CVERR002", "There is an account already associated with this email."),
    PASSWORD_VALIDATION_ERROR("CVERR003", "Password failed validation."),
    PASSWORD_MATCHING_ERROR("CVERR004", "Passwords must match."),
    PASSWORD_REQUIREMENT_ERROR("CVERR005", "Password does not meet requirements."),

    // INPUT VALIDATION ERRORS
    INVALID_DATE_FORMAT_ERROR("IVERR001", "Invalid Date format. Must be 'MM/DD/YYY' (i.e. 01/01/2018)"),
    INVALID_FORMAT_ERROR("IVERR002", "Invalid Format"),

    // MAIL SEND ERRORS
    MAIL_INVALID_EMAIL_ERROR("MSERR001", "Email not sent. Invalid Email."),
    INVALID_EMAIL_FORMAT_ERROR("MSERR002", "Invalid Email Format. Email Not Sent"),

    // UPDATE ERROR
    UPDATE_USER_INFO_ERROR("UEERR001", "User update failed."),


    // RESET PASSWORD ERROR
    INVALID_KEY_ERROR("RPERR000", "Invalid security key."),

    // PDF ERROR
    PDF_GENERATION_ERROR("PGERR000", "PDF Generation failed."),

    // VERIFICATION ERROR
    NO_VERIFICATION_ERROR("VERR001", "No Verification data found for user."),
    EXPIRED_VERIFICATION_TOKEN("VERR002", "Verification Token Expired"),

    // ADMIN ERROR
    IS_ADMIN_ERROR("AERR001", "Admin account already associated with this email."),

    // S3 ERRORS
    S3_ERROR("S3ERR001", "There was an error uploading your file. Please try again later."),

    // DATABASE SPECIFIC ERRORS
    DATABASE_ERROR("DBERR001", "Database Error");

    private final String code;
    private final String message;
}
