package org.example;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Reading {
    public static void main(String[] args) throws SQLException {

        String userName = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, userName, password);

        DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);

        org.example.jooq.tables.records.ArticleRecord article = context.newRecord(org.example.jooq.tables.Article.ARTICLE);

        Result<Record> authors = context.select()
                .from(org.example.jooq.tables.Author.AUTHOR)
                .fetch();

        authors.forEach(author -> {
            Integer id = author.getValue(org.example.jooq.tables.Author.AUTHOR.ID);
            String firstName = author.getValue(org.example.jooq.tables.Author.AUTHOR.FIRST_NAME);
            String lastName = author.getValue(org.example.jooq.tables.Author.AUTHOR.LAST_NAME);
            Integer age = author.getValue(org.example.jooq.tables.Author.AUTHOR.AGE);

            System.out.printf("Author %s %s has id: %d and age: %d%n", firstName, lastName, id, age);
        });

//        Result<Record2<Integer, String>> articles = context
//        .select(org.example.jooq.tables.Article.ARTICLE.ID, org.example.jooq.tables.Article.ARTICLE.TITLE)
//                .from(org.example.jooq.tables.Author.AUTHOR)
//                .fetch();


        org.example.jooq.tables.records.AuthorRecord author = context
                .fetchOne(org.example.jooq.tables.Author.AUTHOR, org.example.jooq.tables.Author.AUTHOR.ID.eq(1));

    }
}
