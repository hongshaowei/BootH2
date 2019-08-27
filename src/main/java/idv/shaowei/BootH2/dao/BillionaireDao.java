package idv.shaowei.BootH2.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import idv.shaowei.BootH2.entity.Billionaire;

@Repository
public class BillionaireDao implements Dao<Billionaire> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BillionaireDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Optional<Billionaire> fetch(int id) throws Exception {
		List<Billionaire> tmp = jdbcTemplate.query("SELECT * FROM billionaire WHERE ID = ? ", new Object[] { id }, new BeanPropertyRowMapper<Billionaire>(Billionaire.class));
		return Optional.ofNullable(tmp.size() > 0 ? tmp.get(0) : null);
	}

	@Override
	public List<Billionaire> fetchAll() throws Exception {
		return jdbcTemplate.query("SELECT * FROM billionaire ", new BeanPropertyRowMapper<Billionaire>(Billionaire.class));
	}

	@Override
	public void save(Billionaire b) throws Exception {
		String sql = "INSERT INTO billionaire(FIRSTNAME, LASTNAME, CAREER, VALUE) VALUES (?, ?, ?, ?) ";
		jdbcTemplate.update(sql, new Object[] { b.getFirstName(), b.getLastName(), b.getCareer(), b.getValue() });
	}

	@Override
	public void update(int id, Map<String, String> params) throws Exception {
		String updStr = "UPDATE billionaire SET ";
		updStr += params.entrySet().stream().filter(entry -> entry.getValue() != null).map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining(","));
		jdbcTemplate.update(updStr);
	}

	@Override
	public void delete(int id) throws Exception {
		jdbcTemplate.update("DELETE FROM　billionaire WHERE ID = " + id);
	}

}
