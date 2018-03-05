package br.com.conductor.siscon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConfigSiscon {

	@Value("${siscon.jdbc.username}")
	private String username;

	@Value("${siscon.jdbc.password}")
	private String password;

	@Value("${siscon.jdbc.url}")
	private String url;

	@Value("${siscon.jdbc.driverClassName}")
	private String driver;

	@Value("${siscon.hibernate.dialect}")
	private String dialect;

	@Value("${siscon.db.connection.init.sql}")
	private String connectionInitSql;

	@Value("${siscon.default_schema}")
	private String defaultSchema;
	
	@Value("${siscon.db.initialSize}")
	private String initialSize;
	
	@Value("${siscon.db.maxActive}")
	private String maxActive;
	
	@Value("${siscon.db.maxIdle}")
	private String maxIdle;
	
	@Value("${siscon.db.minIdle}")
	private String minIdle;
	
	@Value("${siscon.db.maxWait}")
	private String maxWait;
	
	@Value("${siscon.db.timeBetweenEvictionRunsMillis}")
	private String timeBetweenEvictionRunsMillis;
	
	@Value("${siscon.db.removeAbandoned}")
	private String removeAbandoned;
	
	@Value("${siscon.db.removeAbandonedTimeout}")
	private String removeAbandonedTimeout;
	
	@Value("${siscon.db.testOnBorrow}")
	private String testOnBorrow;
	
	@Value("${siscon.db.validateQuery}")
	private String validateQuery;	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwor) {
		this.password = passwor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the dialect
	 */
	public String getDialect() {
		return dialect;
	}

	/**
	 * @param dialect
	 *            the dialect to set
	 */
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	/**
	 * @return the connectionInitSql
	 */
	public String getConnectionInitSql() {
		return connectionInitSql;
	}

	/**
	 * @param connectionInitSql
	 *            the connectionInitSql to set
	 */
	public void setConnectionInitSql(String connectionInitSql) {
		this.connectionInitSql = connectionInitSql;
	}

	public String getDefaultSchema() {
		return defaultSchema;
	}

	public void setDefaultSchema(String defaultSchema) {
		this.defaultSchema = defaultSchema;
	}

	public String getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}

	public String getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}

	public String getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}

	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public String getRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(String removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public String getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(String removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public String getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(String testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public String getValidateQuery() {
		return validateQuery;
	}

	public void setValidateQuery(String validateQuery) {
		this.validateQuery = validateQuery;
	}

}
