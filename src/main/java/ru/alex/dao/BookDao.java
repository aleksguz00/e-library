package ru.alex.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alex.model.Book;
import ru.alex.model.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        String sql = "select * from book";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book findById(int id) {
        String sql = "select * from book where id = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    public void save(Book book) {
        String sql = "insert into book(name, author, year) values(?, ?, ?)";

        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book book) {
        String sql = "update book set name = ?, author = ?, year = ? where id = ?";

        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getYear(), id);
    }



    public void delete(int id) {
        String sql = "delete from book where id = ?";

        jdbcTemplate.update(sql, id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("select person.* from book join person on book.person_id = person.id " +
                "where book.id = ?", new BeanPropertyRowMapper<>(Person.class), id).stream().findAny();
    }

    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("update book set person_id = ? where id = ?", selectedPerson.getId(), id);
    }

    public void release(int id) {
        jdbcTemplate.update("update book set person_id = null where id = ?", id);
    }
}
