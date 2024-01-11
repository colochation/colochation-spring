package cat.omnes.colochation.colochationback.infrastructure.mysql;

import cat.omnes.colochation.colochationback.domain.Chore;
import cat.omnes.colochation.colochationback.domain.ChoresRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MySQLChoresRepository implements ChoresRepository {

    private final MySQL mySQL;

    public MySQLChoresRepository(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    @Override
    public List<Chore> findAll() {
        List<Chore> chores = new ArrayList<>();
        String sql = "SELECT * FROM chores";

        try (Connection conn = mySQL.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Chore chore = new Chore(
                        UUID.fromString(rs.getString("id")),
                        rs.getString("title"),
                        rs.getString("status"),
                        rs.getString("assigned")
                );
                chores.add(chore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chores;
    }

    @Override
    public Chore add(Chore chore) {
        String sql = "INSERT INTO chores (id, title, status, assigned) VALUES (?, ?, ?, ?)";

        try (Connection conn = mySQL.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, chore.id.toString());
            stmt.setString(2, chore.title);
            stmt.setString(3, chore.status);
            stmt.setString(4, chore.assigned);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return chore;
    }

    @Override
    public Optional<Chore> update(Chore chore) {
        String sql = "UPDATE chores SET title = ?, status = ?, assigned = ? WHERE id = ?";

        try (Connection conn = mySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chore.title);
            stmt.setString(2, chore.status);
            stmt.setString(3, chore.assigned);
            stmt.setString(4, chore.id.toString());

            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0) {
                return Optional.of(chore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Chore> find(UUID id) {
        String sql = "SELECT * FROM chores WHERE id = ?";

        try (Connection conn = mySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Chore chore = new Chore(
                            UUID.fromString(rs.getString("id")),
                            rs.getString("title"),
                            rs.getString("status"),
                            rs.getString("assigned")
                    );
                    return Optional.of(chore);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
