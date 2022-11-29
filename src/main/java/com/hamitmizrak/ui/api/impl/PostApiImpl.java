package com.hamitmizrak.ui.api.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.business.services.IPostService;
import com.hamitmizrak.error.ApiResult;
import com.hamitmizrak.ui.api.IPostApi;
import lombok.RequiredArgsConstructor;
import okhttp3.MultipartBody;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/posts")
@CrossOrigin("*")
public class PostApiImpl implements IPostApi {

    //Injection
    private final IPostService postService;
    private static final String PATH = "gateway/posts";

    //SAVE
    //http://localhost:1111/gateway/posts  ==> POST
    @Override
    @PostMapping
    public ApiResult createPost(@RequestBody JsonElement jsonElement) {
        postService.createPost(jsonElement);
        return new ApiResult(200, "Post has been created and saved.", PATH);
    }

    //http://localhost:1111/gateway/posts/1/image/upload  ==> POST IMAGE
    @Override
    @PostMapping(
            path = "/{postId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResult uploadPostImage(@PathVariable("postId") long postId,
                                     @RequestParam MultipartBody.Part file){
        postService.uploadPostImage(postId,file);
        return new ApiResult(200, "The image has been saved.", PATH);
    }

    //LIST
    //http://localhost:1111/gateway/posts  ==> GET
    @Override
    @GetMapping
    public ResponseEntity<List<?>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    //FIND
    //http://localhost:1111/gateway/posts/1 ==> GET
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    //FIND
    //http://localhost:1111/gateway/posts/1 ==> GET
    @Override
    @GetMapping("/{authorId}")
    public ResponseEntity<?> getPostByAuthorId(@PathVariable(name = "authorId") Long authorId) {
        return ResponseEntity.ok(postService.getPostByAuthorId(authorId));
    }

    //FIND
    //http://localhost:1111/gateway/posts/published ==> GET
    @Override
    @GetMapping("/published")
    public ResponseEntity<?> getPublishedPosts() {
        return ResponseEntity.ok(postService.getPublishedPosts());
    }

    //FIND
    //http://localhost:1111/gateway/posts/unpublished ==> GET
    @Override
    @GetMapping("/unpublished/{authorId}")
    public ResponseEntity<?> getUnpublishedPostsByAuthorId(@PathVariable(name = "authorId") Long authorId) {
        return ResponseEntity.ok(postService.getUnpublishedPostsByAuthorId(authorId));
    }


    //UPDATE
    //http://localhost:1111/gateway/posts/1 ==> PUT
    @Override
    @PutMapping("/{id}")
    public ApiResult updatePost(@PathVariable(name="id") Long id,@RequestBody JsonElement jsonElement) {
        postService.updatePost(id,jsonElement);
        return new ApiResult(200, "Updated.", PATH);
    }

//    //PUBLISH
//    //http://localhost:1111/gateway/posts/publish/1 ==> PUT
    @Override
    @PutMapping("/publish/{postId}")
    public ApiResult publishPost(@PathVariable(name = "postId") long postId) {
        postService.publishPost(postId);
        return new ApiResult(200, "Published.", PATH);
    }


    //DELETE
    //http://localhost:3333/gateway/posts/1 ==> DELETE
    @Override
    @DeleteMapping("/{id}")
    public ApiResult deletePost(@PathVariable(name="id") Long id) {
        postService.deletePost(id);
        return new ApiResult(200, "Deleted.", PATH);
    }
}
