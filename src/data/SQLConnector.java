package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector
{
    private static SQLConnector instance;
    private Connection dbConn;
    private String URL = "jdbc:sqlserver://localhost:1433;dataBaseName=CURSO";

    private SQLConnector(String user, String password)
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dbConn = DriverManager.getConnection(URL, user, password);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return dbConn;
    }

    public static SQLConnector getInstance(String user, String password)throws SQLException//Debe ser publico paara que nos retorne el Singleton
    {
        if(instance == null)
        {
            instance = new SQLConnector(user, password);
        }
        else
        if (instance.getConnection().isClosed())
        {
            instance = new SQLConnector(user, password);
        }
        return instance;
    }
}
