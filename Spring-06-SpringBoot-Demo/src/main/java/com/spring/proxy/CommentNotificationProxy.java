package com.spring.proxy;
import com.spring.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
