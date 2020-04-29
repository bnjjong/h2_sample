package org.example.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class H2Sample {

  public static void main(String[] args) {
    try {
      Class.forName("org.h2.Driver");
      Connection connection = DriverManager
          .getConnection("jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1", "sa", "sa");

      String createSql = "create table sample_table"
          + "( id Integer primary key"
          + ", value varchar(255)"
          + ")";
      Statement statement = connection.createStatement();
      statement.executeUpdate(createSql);
      System.out.println("create table!");

      String insertSql = "insert into sample_table values("
          + "100, 'value sample')";
      statement.executeUpdate(insertSql);
      log.info("success insert!");


    } catch (Exception e) {
      e.getStackTrace();
    }
  }
}
