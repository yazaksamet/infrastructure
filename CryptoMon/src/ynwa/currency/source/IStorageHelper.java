package ynwa.currency.source;

import java.sql.SQLException;
import java.util.List;

import ynwa.currency.entity.*;

public interface IStorageHelper {
	public void InsertProvider(Provider provider) throws ClassNotFoundException, SQLException;
	public void UpdateProvider(Provider provider) throws ClassNotFoundException, SQLException;
	public void DeleteProvider(Provider provider) throws ClassNotFoundException, SQLException;
	public Provider SelectProviderWithName(String name) throws ClassNotFoundException, SQLException;
	public Provider SelectProvider(String id) throws ClassNotFoundException, SQLException;
	public List<Provider> SelectProviders();
	public User SelectUser(String loginName, String password);
}
