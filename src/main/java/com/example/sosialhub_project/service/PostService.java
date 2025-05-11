package com.example.sosialhub_project.service;


import com.example.sosialhub_project.model.Post;
import org.springframework.stereotype.Service;
import com.example.sosialhub_project.repository.PostRepository;


import java.util.List;


@Service
public class PostService {


    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    //Lag en ny post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }


    //Hent alle poster
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }


    //Hent alle poster til en bestemt bruker
    public List<Post> getPostsByUser(Long userId) {
        return postRepository.findByUserId(userId);
    }


    //Slett en post
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


    //Oppdater en post
    public Post updatePost(Long postId, Post updatedPost) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));




        post.setContent(updatedPost.getContent());
        return postRepository.save(post);
    }
}
