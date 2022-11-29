package com.hamitmizrak.ui.api.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.business.services.ICommentService;
import com.hamitmizrak.error.ApiResult;
import com.hamitmizrak.ui.api.ICommentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/comments")
@CrossOrigin("*")
public class CommentApiImpl implements ICommentApi {


    //Injection
    private final ICommentService commentService;
    private static final String PATH = "gateway/comments";

    //SAVE
    //http://localhost:1111/gateway/comments/1/newcomment  ==> POST
    @Override
    @PostMapping("/{postId}/newcomment")
    public ApiResult createComment(@PathVariable("postId") long postId, @RequestBody JsonElement jsonElement) {
        commentService.createComment(postId,jsonElement);
        return new ApiResult(200, "Post has been created and saved.", PATH);
    }

}
