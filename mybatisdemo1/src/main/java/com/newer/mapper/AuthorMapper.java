package com.newer.mapper;

import com.newer.domain.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorMapper {
    int addAuthor(Author author);

    int updateAuthor(Author author);

    int deleteAuthor( @Param("id") int id);

    Author finByid(@Param("id") int id);

    List<Author> findAll();
}
