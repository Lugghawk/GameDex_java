package com.gamedex.persist.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Join object for game and vendor.
 */
@DatabaseTable(tableName = "usergamevendors")
public class GameVendor {
	@DatabaseField(generatedId = true)
	int id;

	@DatabaseField(foreign = true, columnName = "gameId")
	private Game game;
	@DatabaseField(foreign = true, columnName = "vendorId")
	private Vendor vendor;

	public GameVendor(Game game, Vendor vendor) {
		this.game = game;
		this.vendor = vendor;
	}
}
