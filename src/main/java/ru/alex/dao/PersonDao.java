package ru.alex.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alex.model.Book;
import ru.alex.model.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        String sql = "select * from person";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        String sql = "select * from person where id = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Person.class), id);
    }

    public Optional<Person> findByEmail(String email) {
        String sql = "select * from person where email = ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class), email).stream().findAny();
    }

    public boolean checkEditEmail(Person person) {
        Person savedPerson = findById(person.getId());

        return savedPerson.getEmail().equals(person.getEmail());
    }

    public void save(Person person) {
        String sql = "insert into person (name, age, email) values (?, ?, ?)";

        jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person person) {
        String sql = "update person set name = ?, age = ?, email = ? where id = ?";

        jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getEmail(), person.getId());
    }

    public void delete(int id) {
        String sql = "delete from person where id = ?";

        jdbcTemplate.update(sql, id);
    }

    public List<Book> getAllBooks(int id) {
        String sql = "select * from book where person_id = ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
}
