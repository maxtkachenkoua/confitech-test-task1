package de.confitech.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ArticleDto {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title can have a maximum of 255 characters")
    private String title;

    @NotBlank(message = "Content is mandatory")
    private String content;

    @NotNull(message = "Published date is mandatory")
    private LocalDate publishedDate;

    @NotBlank(message = "Author username is mandatory")
    private String authorUsername;
}
