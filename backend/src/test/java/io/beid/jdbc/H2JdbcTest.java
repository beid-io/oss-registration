package io.beid.jdbc;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@SpringBootTest
class H2JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static boolean setUpIsDone = false;

    @BeforeEach
    public void beforeEach() {
        initialDB();
    }

    @Test
    void testOne() {
        log.info("testOne");
    }

    @Test
    void testTwo() {
        log.info("testTwo");
    }

    private void initialDB() {
        if (setUpIsDone) return;

        log.info("initialDB");

        jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
        jdbcTemplate.execute("CREATE TABLE customers(id INT, first_name VARCHAR(16), last_name VARCHAR(16))");

        // Split up the array of whole names into an array of first/last names
        val splitUpNames = Stream
                .of("1 John Woo", "2 Jeff Dean", "3 Josh Bloch", "4 Josh Long")
                .map(name -> name.split(" "))
                .map(arr -> new Object[] {Integer.valueOf(arr[0].toString()), arr[1], arr[2]})
                .collect(Collectors.<Object[]>toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name ->
                log.info("Inserting customer record for {} {} {}", Integer.valueOf(name[0].toString()), name[1], name[2]));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate(
                "INSERT INTO customers(id, first_name, last_name) VALUES (?, ?, ?)",
                splitUpNames);

        setUpIsDone = true;
    }

}
