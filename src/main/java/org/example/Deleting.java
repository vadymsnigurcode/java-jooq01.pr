package org.example;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Deleting {
    public static void main(String[] args) throws SQLException {

        String userName = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, userName, password);

        DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);

        context.delete(org.example.jooq.tables.Article.ARTICLE)
                .where(org.example.jooq.tables.Article.ARTICLE.ID.eq(1))
                .execute();

        // or

//        org.example.jooq.tables.records.ArticleRecord articleRecord = context
//                .fetchOne(org.example.jooq.tables.Article.ARTICLE, org.example.jooq.tables.Article.ARTICLE.ID.eq(1));
//        articleRecord.delete();
    }
}
