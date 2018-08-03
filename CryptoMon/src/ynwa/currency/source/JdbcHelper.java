package ynwa.currency.source;

import java.sql.*;
import java.util.List;

import org.apache.log4j.Logger;

import ynwa.currency.entity.Provider;
import ynwa.currency.test.Runner;

public class JdbcHelper implements IStorageHelper {
	static Logger log = Logger.getLogger(Runner.class.getName());
	
	@Override
	public void InsertProvider(Provider provider) throws ClassNotFoundException, SQLException {
		String query = "insert into Providers (name, url, reload_time, update_date, id) values (?, ?, ?, ?, ?)";
		PreparedStatement stmt = GetStatement(query, provider);
		stmt.executeUpdate(); 
		stmt.close();
		log.info(query);
	}

	@Override
	public void UpdateProvider(Provider provider) throws ClassNotFoundException, SQLException {
		String query = "update Providers set name=?, url=?, reload_time=?, update_date=? where id=?";
		PreparedStatement stmt = GetStatement(query, provider);
		stmt.executeUpdate(); 
		stmt.close();
		log.info(query);
	}

	@Override
	public void DeleteProvider(Provider provider) throws ClassNotFoundException, SQLException {
		String query = "delete from Providers where id=?";
		Connection con = GetConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1, provider.getId());
		stmt.executeUpdate(); 
		stmt.close();
		log.info(query);
	}

	@Override
	public Provider SelectProviderWithName(String name) throws ClassNotFoundException, SQLException {
		String query = "select id,name,url,reload_time,update_date from Providers where name=?";
		Connection con = GetConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1, name);
		ResultSet result = stmt.executeQuery();
		Provider provider = new Provider();
		if (result.next()) {
			provider.setId(result.getString("id"));
			provider.setName(result.getString("name"));
			provider.setUrl(result.getString("url"));
			provider.setReloadTime(result.getInt("reload_time"));
			provider.setUpdateDate(result.getDate("update_date"));
		}
		
		stmt.close();
		log.info(query);
		return provider;
	}

	@Override
	public Provider SelectProvider(String id) throws ClassNotFoundException, SQLException {
		String query = "select id,name,url,reload_time,update_date from Providers where id=?";
		Connection con = GetConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1, id);
		ResultSet result = stmt.executeQuery();
		Provider provider = new Provider();
		if (result.next()) {
			provider.setId(result.getString("id"));
			provider.setName(result.getString("name"));
			provider.setUrl(result.getString("url"));
			provider.setReloadTime(result.getInt("reload_time"));
			provider.setUpdateDate(result.getTimestamp("update_date"));
		}
		
		stmt.close();
		log.info(query);
		return provider;
	}

	@Override
	public List<Provider> SelectProviders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Connection GetConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		//Connection con = DriverManager.getConnection("jdbc:mysql://cryptomon.clx5rfnr0mjc.us-west-2.rds.amazonaws.com:3306/crypto_mon",
				//"sametyazak","Liverpool1892;");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crypto_mon",
				"sametyazak","Liverpool1892;");
		return con;
	}
	
	public PreparedStatement GetStatement(String query, Provider provider) throws ClassNotFoundException, SQLException {
		Connection con = GetConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1, provider.getName());
		stmt.setString(2, provider.getUrl());
		stmt.setInt(3, provider.getReloadTime());
		stmt.setTimestamp(4, new java.sql.Timestamp(provider.getUpdateDate().getTime()));
		stmt.setString(5, provider.getId());
		return stmt;
	}
	
}
