package group.proga.dbthings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    //metod kotorij vozvrawaet tip Connection i THROW isklju4enija esli 4to powlo ne tak:
    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
        String connectionString ="jdbc:mysql://"+dbHost +":"
                + dbPort +"/"+dbName;
        //Class.forName("com.mysql.jdbc.Driver");//this seems to be unnecesary
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
}
