package de.confitech.blog.db.repo;

import de.confitech.blog.db.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByPublishedDateBefore(LocalDate date);
}
