package com.example.wherever_i_want.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class DbManagerTestSuite {

    @Test
    public void testConnect() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Assert.assertNotNull(dbManager.getConnection());
    }
}
