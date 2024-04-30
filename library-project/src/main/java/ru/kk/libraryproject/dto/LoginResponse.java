package ru.kk.libraryproject.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
