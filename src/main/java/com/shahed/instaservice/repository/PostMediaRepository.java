package com.shahed.instaservice.repository;

import com.shahed.instaservice.schema.PostMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostMediaRepository extends JpaRepository<PostMedia, Long> {
}
