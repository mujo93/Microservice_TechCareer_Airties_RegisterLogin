package com.hamitmizrak.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ICommentServiceRequest {

    @POST("/api/v1/comments/{postId}/newcomment")
    Call<JsonElement> createComment(@Path("postId") long postId, @Body JsonElement jsonElement);
}
