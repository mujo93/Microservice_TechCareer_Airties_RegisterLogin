package com.hamitmizrak.ui.api;

import com.google.gson.JsonElement;
import com.hamitmizrak.error.ApiResult;
import okhttp3.MultipartBody;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPostApi {

    // REST             REQUEST
    // ----------       -------
    // @GetMapping      @GET
    // @PostMapping     @POST
    // @DeleteMapping   @DELETE
    // @PutMapping      @PUT

    // @PathVariable    @Path
    // @RequestBody     @Body

    // ResponseEntity   Call
    // DailyDto         JsonElement


    //SAVE
    ApiResult createPost(JsonElement jsonElement);



    //LIST
    ResponseEntity<List<?>> getPosts();

    //FIND
    ResponseEntity<?> getPost(Long id);


    //FIND
    //http://localhost:1111/gateway/posts/1 ==> GET
    @GetMapping("/{authorId}")
    ResponseEntity<?> getPostByAuthorId(@PathVariable(name = "authorId") Long authorId);

    //FIND
    //http://localhost:1111/gateway/posts/published ==> GET
    @GetMapping("/published")
    ResponseEntity<?> getPublishedPosts();

    //FIND
    //http://localhost:1111/gateway/posts/unpublished ==> GET
//    @GetMapping("/unpublished")
//    ResponseEntity<?> getUnpublishedPosts();

    //FIND
    //http://localhost:1111/gateway/posts/unpublished/22 ==> GET
    @GetMapping("/unpublished/{authorId}")
    ResponseEntity<?> getUnpublishedPostsByAuthorId(@PathVariable(name = "authorId") Long authorId);

    //UPDATE
    ApiResult updatePost(Long id,JsonElement jsonElement);


    //PUBLISH
    //http://localhost:1111/gateway/posts/publish/1 ==> PUT
    @PutMapping("/publish/{postId}")
    ApiResult publishPost(@PathVariable(name = "postId") long postId);

    //DELETE
    ApiResult deletePost(Long id);


    //http://localhost:1111/gateway/1/image/upload  ==> POST IMAGE
    @PostMapping(
            path = "/{postId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ApiResult uploadPostImage(@PathVariable("postId") long postId,
                              @RequestParam("file") MultipartBody.Part file);

}
