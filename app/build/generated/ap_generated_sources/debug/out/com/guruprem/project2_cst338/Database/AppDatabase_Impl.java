package com.guruprem.project2_cst338.Database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile EcommerceDAO _ecommerceDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ECOMMERCE_TABLE` (`mUserId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mExercise` TEXT, `mReps` INTEGER NOT NULL, `mWeight` REAL NOT NULL, `mUsername` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `USER_TABLE` (`mUserId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mUsername` TEXT, `mPassword` TEXT, `mOldPass` TEXT, `mNewPass` TEXT, `mConfPass` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2abd65171ce411fff156e0b412a94e5f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ECOMMERCE_TABLE`");
        _db.execSQL("DROP TABLE IF EXISTS `USER_TABLE`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsECOMMERCETABLE = new HashMap<String, TableInfo.Column>(5);
        _columnsECOMMERCETABLE.put("mUserId", new TableInfo.Column("mUserId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsECOMMERCETABLE.put("mExercise", new TableInfo.Column("mExercise", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsECOMMERCETABLE.put("mReps", new TableInfo.Column("mReps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsECOMMERCETABLE.put("mWeight", new TableInfo.Column("mWeight", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsECOMMERCETABLE.put("mUsername", new TableInfo.Column("mUsername", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysECOMMERCETABLE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesECOMMERCETABLE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoECOMMERCETABLE = new TableInfo("ECOMMERCE_TABLE", _columnsECOMMERCETABLE, _foreignKeysECOMMERCETABLE, _indicesECOMMERCETABLE);
        final TableInfo _existingECOMMERCETABLE = TableInfo.read(_db, "ECOMMERCE_TABLE");
        if (! _infoECOMMERCETABLE.equals(_existingECOMMERCETABLE)) {
          return new RoomOpenHelper.ValidationResult(false, "ECOMMERCE_TABLE(com.guruprem.project2_cst338.EcommerceLog).\n"
                  + " Expected:\n" + _infoECOMMERCETABLE + "\n"
                  + " Found:\n" + _existingECOMMERCETABLE);
        }
        final HashMap<String, TableInfo.Column> _columnsUSERTABLE = new HashMap<String, TableInfo.Column>(6);
        _columnsUSERTABLE.put("mUserId", new TableInfo.Column("mUserId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERTABLE.put("mUsername", new TableInfo.Column("mUsername", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERTABLE.put("mPassword", new TableInfo.Column("mPassword", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERTABLE.put("mOldPass", new TableInfo.Column("mOldPass", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERTABLE.put("mNewPass", new TableInfo.Column("mNewPass", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUSERTABLE.put("mConfPass", new TableInfo.Column("mConfPass", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUSERTABLE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUSERTABLE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUSERTABLE = new TableInfo("USER_TABLE", _columnsUSERTABLE, _foreignKeysUSERTABLE, _indicesUSERTABLE);
        final TableInfo _existingUSERTABLE = TableInfo.read(_db, "USER_TABLE");
        if (! _infoUSERTABLE.equals(_existingUSERTABLE)) {
          return new RoomOpenHelper.ValidationResult(false, "USER_TABLE(com.guruprem.project2_cst338.User).\n"
                  + " Expected:\n" + _infoUSERTABLE + "\n"
                  + " Found:\n" + _existingUSERTABLE);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "2abd65171ce411fff156e0b412a94e5f", "596e0c47abce70428cd8de4b3a9b302d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ECOMMERCE_TABLE","USER_TABLE");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ECOMMERCE_TABLE`");
      _db.execSQL("DELETE FROM `USER_TABLE`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EcommerceDAO.class, EcommerceDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public EcommerceDAO getEcommerceDAO() {
    if (_ecommerceDAO != null) {
      return _ecommerceDAO;
    } else {
      synchronized(this) {
        if(_ecommerceDAO == null) {
          _ecommerceDAO = new EcommerceDAO_Impl(this);
        }
        return _ecommerceDAO;
      }
    }
  }
}
