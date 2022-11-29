package com.hamitmizrak.ui.api;

import com.google.gson.JsonElement;
import com.hamitmizrak.error.ApiResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICommentApi {


    //SAVE
    //http://localhost:1111/gateway/comments/1/newcomment  ==> POST
    @PostMapping("/{postId}/newcomment")
    ApiResult createComment(@PathVariable("postId") long postId, @RequestBody JsonElement jsonElement);
}
