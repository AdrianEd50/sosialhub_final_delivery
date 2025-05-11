package com.example.sosialhub_project.repository;

import com.example.sosialhub_project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    //Hente alle poster som tilhører en bruker via user.id
    List<Post> findByUserId(Long user_id);


    //Hent alle poster i synkende rekkefølge etter opprettelsesdato
    List<Post> findAllByOrderByCreatedAtDesc();
}
