package br.com.sergio.teste.d3.teamlunchroulette.security;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_SECRET = "jf9i4jgu83nfl0";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
}
