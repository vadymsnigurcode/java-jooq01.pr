package org.example;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Updating {
    public static void main(String[] args) throws SQLException {

        String userName = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, userName, password);

        DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);

        context.update(org.example.jooq.tables.Author.AUTHOR)
                .set(org.example.jooq.tables.Author.AUTHOR.FIRST_NAME, "David")
                .set(org.example.jooq.tables.Author.AUTHOR.LAST_NAME, "Brown")
                .where(org.example.jooq.tables.Author.AUTHOR.ID.eq(1))
                .execute();

        org.example.jooq.tables.records.ArticleRecord article = context
                .fetchOne(org.example.jooq.tables.Article.ARTICLE, org.example.jooq.tables.Article.ARTICLE.ID.eq(1));
        article.setTitle("A New Article Title");
        article.store();
    }
}
