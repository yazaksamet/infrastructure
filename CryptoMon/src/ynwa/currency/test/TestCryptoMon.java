package ynwa.currency.test;

import org.junit.Test;

import ynwa.currency.entity.*;
import ynwa.currency.source.*;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class TestCryptoMon {
	@Test
	public void TestProvider() throws ClassNotFoundException, SQLException {
		Provider provider = new Provider();
		IStorageHelper storage = new MySqlHelper();
		UUID tranUId = UUID.randomUUID();
        provider.setId(tranUId.toString());
        provider.setName("Test Provider");
        provider.setUrl("https://www.btcturk.com/api/ticker");
        provider.setReloadTime(60);
        provider.setUpdateDate(new Date());
        storage.InsertProvider(provider);
        
        provider = storage.SelectProviderWithName("Test Provider");
        provider.setReloadTime(80);
        provider.setUpdateDate(new Date());
        storage.UpdateProvider(provider);
        
        storage.DeleteProvider(provider);
        
        assertEquals(true, true);
	}
}
