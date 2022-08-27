package com.spring.repository;

import com.spring.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
