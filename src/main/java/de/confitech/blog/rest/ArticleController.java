package de.confitech.blog.rest;

import de.confitech.blog.dto.ArticleDto;
import de.confitech.blog.service.ArticleService;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
@Api(value = "Article Management System", tags = "Articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    @ApiOperation(value = "View a list of available articles", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<ArticleDto> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get an article by Id", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved article"),
            @ApiResponse(code = 404, message = "Article not found")
    })
    public ArticleDto getArticleById(
            @ApiParam(value = "ID of the article to retrieve", required = true) @PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/find")
    @ApiOperation(value = "Get an article before publish date", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved articles"),
            @ApiResponse(code = 404, message = "Articles not found")
    })
    public List<ArticleDto> getAllPublishedDateBefore(@RequestParam LocalDate publishDate) {
        return articleService.getAllPublishedDateBefore(publishDate);
    }

    @PostMapping
    @ApiOperation(value = "Create a new article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article successfully created")
    })
    public ResponseEntity<?> createArticle(
            @ApiParam(value = "Article object to create", required = true) @Valid @RequestBody ArticleDto articleDto) {
        return ResponseEntity.ok(articleService.createArticle(articleDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article successfully updated"),
            @ApiResponse(code = 404, message = "Article not found")
    })
    public ResponseEntity<?> updateArticle(
            @ApiParam(value = "ID of the article to update", required = true) @PathVariable Long id,
            @ApiParam(value = "Updated article object", required = true) @Valid @RequestBody ArticleDto articleDetails) {
        return ResponseEntity.ok(articleService.updateArticle(id, articleDetails));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article successfully deleted"),
            @ApiResponse(code = 404, message = "Article not found")
    })
    public ResponseEntity<?> deleteArticle(
            @ApiParam(value = "ID of the article to delete", required = true) @PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }

}
