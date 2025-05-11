package com.example.sosialhub_project.controller;

import com.example.sosialhub_project.DTO.PostDTO;
import com.example.sosialhub_project.model.Post;
import com.example.sosialhub_project.model.User;
import com.example.sosialhub_project.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Opprett ny post med DTO
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setContent(postDTO.getContent());

        // Sett bruker med kun ID (for å koble uten å hente hele brukeren fra DB)
        User user = new User();
        user.setId(postDTO.getUserId());
        post.setUser(user);

        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    // Hent alle poster
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // Hent poster for en bestemt bruker
    @GetMapping("user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.getPostsByUser(userId));
    }

    // Slett en post
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok("Deleted post");
    }

    // Oppdater en post
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost) {
        return ResponseEntity.ok(postService.updatePost(postId, updatedPost));
    }
}