package de.confitech.blog.service;


import de.confitech.blog.db.model.Article;
import de.confitech.blog.db.repo.ArticleRepository;
import de.confitech.blog.dto.ArticleDto;
import de.confitech.blog.exception.model.ResourceNotFoundException;
import de.confitech.blog.map.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Transactional(readOnly = true)
    public List<ArticleDto> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(articleMapper::toDto)
                .toList();
    }

    public List<ArticleDto> getAllPublishedDateBefore(LocalDate publishedDate){
        return articleRepository.findByPublishedDateBefore(publishedDate).stream()
                .map(articleMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ArticleDto getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        return articleMapper.toDto(article);
    }

    @Transactional
    public ArticleDto createArticle(ArticleDto articleDto) {
        Article article = articleMapper.toEntity(articleDto);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDto(savedArticle);
    }

    @Transactional
    public ArticleDto updateArticle(Long id, ArticleDto articleDetails) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        article.setTitle(articleDetails.getTitle());
        article.setContent(articleDetails.getContent());
        article.setPublishedDate(articleDetails.getPublishedDate());
        Article updatedArticle = articleRepository.save(article);
        return articleMapper.toDto(updatedArticle);
    }

    @Transactional
    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        articleRepository.delete(article);
    }
}
