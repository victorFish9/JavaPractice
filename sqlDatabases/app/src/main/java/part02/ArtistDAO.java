package databases.part02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for the Artist table in the Chinook database.
 */
public class ArtistDAO {

    /**
     * The connection string used to connect to the database. You MUST use this
     * string when connecting to the database using JDBC. In the unit tests, this
     * field will be set to a different value.
     */
    private final String connectionString;

    /**
     * Creates a new ArtistDAO that uses the specified connection string to connect
     * to the database. For example: "jdbc:sqlite:data/Chinook_Sqlite.sqlite"
     *
     * @param connectionString, see https://www.baeldung.com/java-jdbc-url-format
     */

    public ArtistDAO(String connectionString) {
        this.connectionString = connectionString;
    }

    /**
     * Returns a list of all artists in the database. The list is ordered by artist
     * name. If there are no artists in the database, an empty list is returned.
     *
     * @return a list of all artists in the database.
     */
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();

        /*
         * hint: see the class from part 1 for an example of how to connect to the
         * database and retrieve data from it. This time create new Artist objects
         * instead of printing the results to the console.
         *
         * Note that you must use the `connectionString` field in this class to connect
         * to the database. You can't "hard code" the connection string, as that would
         * make tests run against your actual database, which may have unexpected data.
         */

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "SELECT * FROM Artist ORDER BY Name";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    long id = resultSet.getLong("ArtistId");
                    String name = resultSet.getString("Name");
                    Artist artist = new Artist(id, name);
                    artists.add(artist);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
        }

        return artists;

    }

    /**
     * Returns the artist with the specified id, or null if no artist exists with
     * that id.
     *
     * @param id the id of the artist to retrieve.
     * @return the artist with the specified id, or null if no artist exists with
     *         that id.
     */
    public Artist getArtistById(long id) {
        /*
         * hint: use similar code to the getArtists() method above, but add a WHERE
         * clause to the SQL query to only retrieve the artist with the specified id.
         *
         * The id can be added to the SQL query using PreparedStatement's setLong()
         * method. For example: preparedStatement.setLong(1, id);
         *
         * You could also just call the getArtists() method above and iterate through
         * the results until you find the artist with the specified id. This is less
         * efficient, but it gets the job done and is easy to implement.
         *
         * Note that you must use the `connectionString` field in this class to connect
         * to the database. You can't "hard code" the connection string, as that would
         * make tests run against your actual database, which may have unexpected data.
         */

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "SELECT * FROM Artist WHERE ArtistId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("Name");
                        return new Artist(id, name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
        }
        return null;
    }
}
