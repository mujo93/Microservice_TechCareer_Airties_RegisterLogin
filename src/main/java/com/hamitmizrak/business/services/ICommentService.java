package com.hamitmizrak.business.services;

import com.google.gson.JsonElement;

public interface ICommentService {

    JsonElement createComment(long postId,JsonElement jsonElement);
}
