package com.hamitmizrak.business.services;

import com.google.gson.JsonElement;
import okhttp3.MultipartBody;

import java.util.List;

public interface IPostService {


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
    JsonElement createPost(JsonElement jsonElement);

    //SAVE IMAGE
    JsonElement uploadPostImage(long postId, MultipartBody.Part file);

    JsonElement publishPost(long postId);

    //LIST
    List<JsonElement> getPosts();

    //LIST BY AUTHOR ID
    List<JsonElement> getPostByAuthorId(Long authorId);

    //LIST PUBLISHED POSTS
    List<JsonElement> getPublishedPosts();

    //LIST UNPUBLISHED POSTS By AUTHOR ID
    List<JsonElement> getUnpublishedPostsByAuthorId(Long authorId);

    //FIND
    JsonElement getPost(Long id);

    //UPDATE
    JsonElement updatePost(Long id,JsonElement jsonElement);

    //DELETE
    void deletePost(Long id);



}
