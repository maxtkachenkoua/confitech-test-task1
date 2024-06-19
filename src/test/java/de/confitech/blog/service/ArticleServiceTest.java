package de.confitech.blog.service;

import de.confitech.blog.db.model.Article;
import de.confitech.blog.db.repo.ArticleRepository;
import de.confitech.blog.dto.ArticleDto;
import de.confitech.blog.exception.model.ResourceNotFoundException;
import de.confitech.blog.map.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleMapper articleMapper;

    @InjectMocks
    private ArticleService articleService;

    @Test
    public void testGetAllArticles() {
        when(articleRepository.findAll()).thenReturn(Collections.singletonList(new Article()));
        List<ArticleDto> articles = articleService.getAllArticles();
        assertThat(articles).hasSize(1);
        verify(articleRepository, times(1)).findAll();
    }

    @Test
    public void testGetArticleById() {
        Article article = new Article();
        article.setId(1L);
        when(articleRepository.findById(1L)).thenReturn(Optional.of(article));
        when(articleMapper.toDto(any())).thenReturn(new ArticleDto());
        verify(articleRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetArticleByIdNotFound() {
        when(articleRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> articleService.getArticleById(1L));
    }
}
