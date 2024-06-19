package de.confitech.blog.map;

import de.confitech.blog.db.model.Article;
import de.confitech.blog.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleMapper {
    private final ModelMapper modelMapper;

    public ArticleDto toDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

    public Article toEntity(ArticleDto dto) {
        return modelMapper.map(dto, Article.class);
    }
}