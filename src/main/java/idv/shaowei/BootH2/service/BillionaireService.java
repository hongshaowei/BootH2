package idv.shaowei.BootH2.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import idv.shaowei.BootH2.dao.Dao;
import idv.shaowei.BootH2.entity.Billionaire;

@Component
public class BillionaireService implements Service<Billionaire> {
	private Dao<Billionaire> dao;
	private DataSourceTransactionManager txManager;
	private Logger logger = LoggerFactory.getLogger(com.esuncard.BootH2.service.BillionaireService.class);
	
	@Autowired
	public BillionaireService(Dao<Billionaire> dao, DataSourceTransactionManager txManager) {
		this.dao = dao;
		this.txManager = txManager;
	}

	@Override
	public Optional<Billionaire> fetch(int id) {
		Optional<Billionaire> opt = null;
		try {
			opt = dao.fetch(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return opt;
	}

	@Override
	public List<Billionaire> fetchAll() {
		List<Billionaire> list = null;
		try {
			list = dao.fetchAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public void save(Billionaire b) {
		TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
		try {
			dao.save(b);
			txManager.commit(txStatus);
		} catch (Exception e) {
			if (!txStatus.isCompleted()) {
				txManager.rollback(txStatus);
			}
			logger.error(e.getMessage());
		}
	}

	@Override
	public void update(int id, Map<String, String> params) {
		TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
		try {
			dao.update(id, params);
			txManager.commit(txStatus);
		} catch (Exception e) {
			if (!txStatus.isCompleted()) {
				txManager.rollback(txStatus);
			}
			logger.error(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
		try {
			dao.delete(id);
			txManager.commit(txStatus);
		} catch (Exception e) {
			if (!txStatus.isCompleted()) {
				txManager.rollback(txStatus);
			}
			logger.error(e.getMessage());
		}
	}

}
