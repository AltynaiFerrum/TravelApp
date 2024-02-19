package com.jyldyzferr.travelapp.data.cache.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.jyldyzferr.travelapp.data.cache.dao.TourDao;
import com.jyldyzferr.travelapp.data.cache.dao.TourDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TourDatabase_Impl extends TourDatabase {
  private volatile TourDao _tourDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `tours_table` (`id` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `description` TEXT NOT NULL, `image` TEXT NOT NULL, `title` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, `location` TEXT NOT NULL, `price` TEXT NOT NULL, `rating` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ea194584cfe126a17038c55fef9c94f2')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `tours_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsToursTable = new HashMap<String, TableInfo.Column>(9);
        _columnsToursTable.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("image", new TableInfo.Column("image", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("price", new TableInfo.Column("price", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsToursTable.put("rating", new TableInfo.Column("rating", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysToursTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesToursTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoToursTable = new TableInfo("tours_table", _columnsToursTable, _foreignKeysToursTable, _indicesToursTable);
        final TableInfo _existingToursTable = TableInfo.read(db, "tours_table");
        if (!_infoToursTable.equals(_existingToursTable)) {
          return new RoomOpenHelper.ValidationResult(false, "tours_table(com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache).\n"
                  + " Expected:\n" + _infoToursTable + "\n"
                  + " Found:\n" + _existingToursTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ea194584cfe126a17038c55fef9c94f2", "425341a57198cc86acafd51d01cf9710");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tours_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tours_table`");
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
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TourDao.class, TourDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public TourDao tourDao() {
    if (_tourDao != null) {
      return _tourDao;
    } else {
      synchronized(this) {
        if(_tourDao == null) {
          _tourDao = new TourDao_Impl(this);
        }
        return _tourDao;
      }
    }
  }
}
