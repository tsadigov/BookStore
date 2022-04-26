package com.tsadigov.ingress.bootstrap;

public class Constants {

    public static final String DIRECTORY = "./uploads/profile/";
    public static final String DIRECTORY_PRODUCT = "./uploads/product/";
    public static final String PROFILE_PHOTO_END = "-profile-picture.png";
    public static final String PRODUCT_PHOTO_END = "-product-picture.png";

    public static final String BAD_CREDENTIALS = "Bad credentials";
    public static final String TOKEN_CREATED = "Token created";

    public static final String SUCCESS = "Success";
    public static final String CREATED = "Created";
    public static final String CANNOT_BE_CREATED = "Cannot be created";
    public static final String UPDATED = "Updated";
    public static final String CANNOT_BE_UPDATED = "Cannot be updated";
    public static final String DELETED = "Deleted";
    public static final int DELETED_CODE = 204;
    public static final int UPDATED_CODE = 203;
    public static final int CREATED_CODE = 201;
    public static final int SUCCESS_CODE = 200;
    public static final int BAD_REQUEST_CODE = 400;
    public static final int UNAUTHORIZED_CODE = 401;
    public static final int FORBIDDEN_CODE = 403;
    public static final int NOT_FOUND_CODE = 404;
    public static final int RELATED_RECORD_EXISTS_CODE = 409;
    public static final int INTERNAL_SERVER_ERROR_CODE = 500;
    public static final String NOT_FOUND_MESSAGE = "Not found";
    public static final String TOKEN_BEARER = "Bearer ";
    public static final String SECRET_KEY = "secret_key";
    public static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**"
    };
    public static final String[] PERMIT_ALL_STRINGS = {
            "/root/login",
            "/api/security/**",
            "/api/login/**",
            "/api/security/refreshToken",
            "/swagger-ui/**"
    };
    public static final String ROLES = "roles";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String REFRESH_TOKEN_IS_MISSING = "Refresh token is missing";
    public static final int REFRESH_TOKEN_DURATION = 30 * 60 * 60 * 1000;
    public static final int ACCESS_TOKEN_DURATION = 10 * 60 * 60 * 1000;

    /**
     * Error Messages
     */
    public static final String SHOULD_NOT_BE_LESS_THAN_6_CHARACTER = "Should not be less than 6 character!";
    public static final String USER_NOT_FOUND = "User does not exist!";
    public static final String USERNAME_OR_PASSWORD_NOT_FOUND = "Username or password doesn't exist!";
    public static final String ALREADY_EXISTS = "Account already exists!";
    public static final String WRONG_PASSWORD_FORMAT = "Wrong password format!";
    public static final String WRONG_EMAIL_FORMAT = "Wrong email format!";
    public static final String ROLE_NOT_FOUND = "Role not found!";

    /**
     * Role Names
     */
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_PUBLISHER = "ROLE_PUBLISHER";

    /**
     * Regex Patterns
     */
    public static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";

}
