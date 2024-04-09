package io.dedyn.mouthaan.springtestcontainer;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

@RequiredArgsConstructor
class SpringTestcontainerApplicationTests extends TestBase {

    @Test
    void contextLoads() {
        final DataSource dataSource = getDataSource();
        assertThat(dataSource).isNotNull();
        try (Connection conn = dataSource.getConnection()) {
            assertThat(conn).isNotNull();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM example");
            rs.next();
            assertThat(rs.getLong("id")).isEqualTo(1L);
            assertThat(rs.getString("name")).isEqualTo("TestData1");
        } catch (SQLException e) {
            fail("Connection to the test database failed", e);
        }
    }
}
