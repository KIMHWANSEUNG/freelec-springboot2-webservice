package com.khs.book.springboot.service.posts;

import com.khs.book.springboot.web.domain.posts.Posts;
import com.khs.book.springboot.web.domain.posts.PostsRepository;
import com.khs.book.springboot.web.dto.PostsResponseDto;
import com.khs.book.springboot.web.dto.PostsSaveRequestDto;
import com.khs.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDate;

//final이 붙은 모든 필드값에 Bean 주입
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 . id = " + id));

        return new PostsResponseDto(entity);
    }

}
