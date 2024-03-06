package ru.kk.libraryproject.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorCreateDto {
    private String name;
    private String surname;
}
