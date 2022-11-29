package com.hamitmizrak.business.services.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.business.services.ICommentService;
import com.hamitmizrak.retrofit.RetrofitCommonGenerics;
import com.hamitmizrak.retrofit.request.ICommentServiceRequest;
import com.hamitmizrak.retrofit.request.IPostServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequiredArgsConstructor
@Log4j2

@Service
public class CommentService implements ICommentService {

    private final ICommentServiceRequest iCommentServiceRequest;

    @Override
    public JsonElement createComment(long postId,JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iCommentServiceRequest.createComment(postId,jsonElement));
    }
}
