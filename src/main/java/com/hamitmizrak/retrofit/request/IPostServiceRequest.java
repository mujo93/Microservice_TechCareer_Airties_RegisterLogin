package com.hamitmizrak.retrofit.request;

import com.google.gson.JsonElement;
import okhttp3.MultipartBody;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IPostServiceRequest {

    //CREATE
    //daily project api bilgilerini yazıyoruz
    @POST("/api/v1/posts/newpost")
    Call<JsonElement> createPost(@Body JsonElement jsonElement);

    //PUBLISH POST
    //BLOG project api bilgilerini yazıyoruz

    @PUT("/api/v1/posts/publish/{postId}")
    Call<JsonElement> publishPost(@Path("postId") long postId);

    //SAVE POST IMAGE
    @Multipart
    @POST("/api/v1/posts/{postId}/image/upload")
    Call<JsonElement> uploadPostImage(@Path("postId")long postId,  @Part MultipartBody.Part file);

    //READ ALL
    //BLOG project api bilgilerini yazıyoruz
    @GET("/api/v1/posts/")
    Call<List<JsonElement>> getPosts();

    //READ
    @GET("/api/v1/posts/{id}")
    Call<JsonElement> getPost(@Path("id") Long id);

    //READ BY AUTHOR ID
    @GET("/api/v1/posts/{authorId}")
    Call<List<JsonElement>> getPostsByAuthorId(@Path("authorId") Long authorId);

    //READ PUBLISHED POSTS
    @GET("/api/v1/posts/published")
    Call<List<JsonElement>>  getPublishedPosts();

    @GET("/api/v1/posts/unpublished/{authorId}")
    Call<List<JsonElement>>  getUnpublishedPostsByAuthorId(@Path("authorId") Long authorId);

    //UPDATE
    @PUT("/api/v1/posts/{id}")
    Call<JsonElement> updatePost(@Path("id") Long id,@Body JsonElement jsonElement);

    //DELETE
    @DELETE("/api/v1/posts/{id}")
    Call<JsonElement> deletePost(@Path("id") Long id);



}
