package com.hamitmizrak.business.services.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.business.services.IPostService;
import com.hamitmizrak.retrofit.RetrofitCommonGenerics;
import com.hamitmizrak.retrofit.request.IPostServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import okhttp3.MultipartBody;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Log4j2

@Service
public class PostService implements IPostService {
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

    //injection
    private final IPostServiceRequest iPostServiceRequest;

    //SAVE
    @Override
    public JsonElement createPost(JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.createPost(jsonElement));
    }

    //PUBLISH POST
    @Override
    public JsonElement publishPost(long postId) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.publishPost(postId));
    }

    //LIST
    @Override
    public List<JsonElement> getPosts() {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.getPosts());
    }

    //LIST BY AUTHOR ID
    @Override
    public List<JsonElement> getPostByAuthorId(Long authorId) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.getPostsByAuthorId(authorId));
    }

    //LIST PUBLISHED POSTS
    @Override
    public List<JsonElement> getPublishedPosts() {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.getPublishedPosts());
    }

    //LIST UNPUBLISHED POSTS BY AUTHOR ID
    @Override
    public List<JsonElement> getUnpublishedPostsByAuthorId(Long authorId) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.getUnpublishedPostsByAuthorId(authorId));
    }

    //FIND
    @Override
    public JsonElement getPost(Long id) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.getPost(id));
    }

    //UPDATE
    @Override
    public JsonElement updatePost(Long id, JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.updatePost(id,jsonElement));
    }

    //DELETE
    @Override
    public void deletePost(Long id) {
        RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.deletePost(id));
    }

    @Override
    public JsonElement uploadPostImage(long postId, MultipartBody.Part file) {
        return RetrofitCommonGenerics.retrofitGenerics(iPostServiceRequest.uploadPostImage(postId,file));
    }

}
