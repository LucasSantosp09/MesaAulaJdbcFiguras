import java.sql.*;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Figura; CREATE TABLE Figura"
            + "("
            + " Id INT PRIMARY KEY,"
            + " Figura VARCHAR(100) NOT NULL,"
            + " Cor VARCHAR(100) NOT NULL"
            +")";

    private static final  String sqlInsert1 = "INSERT INTO Figura (Id, Figura, Cor) Values (1, 'Circulo', 'Vermelho')";

    private static final  String sqlInsert2 = "INSERT INTO Figura (Id, Figura, Cor) Values (2, 'Circulo', 'Rosa')";

    private static final  String sqlInsert3 = "INSERT INTO Figura (Id, Figura, Cor) Values (3, 'Quadrado', 'Azul')";

    private static final  String sqlInsert4 = "INSERT INTO Figura (Id, Figura, Cor) Values (4, 'Quadrado', 'Vermelho')";

    private static final  String sqlInsert5 = "INSERT INTO Figura (Id, Figura, Cor) Values (5, 'Quadrado', 'Branco')";


    public static void main(String[] args) {
        Connection connection = null;


        try {
            connection = getConexao();
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

            mostrarCicurloVermelho(connection);

        }catch (Exception e){
            throw  new RuntimeException(e);
        }


    }

    private static void mostrarCicurloVermelho (Connection connection) throws SQLException {
        String sqlQuery = "SELECT * FROM Figura where Figura = 'Circulo' and Cor = 'Vermelho' ";
        Statement statement = connection.createStatement();
        statement.executeQuery(sqlQuery);
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) +  " - " + resultSet.getString(3));
        }

    }

    public static Connection getConexao() throws Exception {

        Class.forName("org.h2.Driver").newInstance();


        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");


    }
}