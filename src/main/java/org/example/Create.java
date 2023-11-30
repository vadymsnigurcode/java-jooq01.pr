package org.example;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create {
    public static void main(String[] args) throws SQLException {

        String userName = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, userName, password);

        DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);

        org.example.jooq.tables.records.ArticleRecord article = context.newRecord(org.example.jooq.tables.Article.ARTICLE);

        article.setId(0);
        article.setTitle("jOOQ examples");
        article.setDescription("A few examples of jOOQ CRUD operations");
        article.setAuthorId(1);

        article.store();
    }
}
