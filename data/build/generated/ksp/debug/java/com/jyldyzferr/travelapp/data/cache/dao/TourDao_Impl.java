package com.jyldyzferr.travelapp.data.cache.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.jyldyzferr.travelapp.data.cache.models.TourDetailsCache;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TourDao_Impl implements TourDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TourDetailsCache> __insertionAdapterOfTourDetailsCache;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTourById;

  public TourDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTourDetailsCache = new EntityInsertionAdapter<TourDetailsCache>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tours_table` (`id`,`createdAt`,`description`,`image`,`title`,`updatedAt`,`location`,`price`,`rating`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TourDetailsCache entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getCreatedAt());
        statement.bindString(3, entity.getDescription());
        statement.bindString(4, entity.getImage());
        statement.bindString(5, entity.getTitle());
        statement.bindString(6, entity.getUpdatedAt());
        statement.bindString(7, entity.getLocation());
        statement.bindString(8, entity.getPrice());
        statement.bindLong(9, entity.getRating());
      }
    };
    this.__preparedStmtOfDeleteTourById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tours_table WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object addNewTour(final TourDetailsCache tour,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTourDetailsCache.insert(tour);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public void deleteTourById(final String tourId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTourById.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, tourId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteTourById.release(_stmt);
    }
  }

  @Override
  public Flow<List<TourDetailsCache>> fetchAllSavedTours() {
    final String _sql = "SELECT * FROM tours_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tours_table"}, new Callable<List<TourDetailsCache>>() {
      @Override
      @NonNull
      public List<TourDetailsCache> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final List<TourDetailsCache> _result = new ArrayList<TourDetailsCache>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TourDetailsCache _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            final String _tmpLocation;
            _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            final String _tmpPrice;
            _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            final int _tmpRating;
            _tmpRating = _cursor.getInt(_cursorIndexOfRating);
            _item = new TourDetailsCache(_tmpId,_tmpCreatedAt,_tmpDescription,_tmpImage,_tmpTitle,_tmpUpdatedAt,_tmpLocation,_tmpPrice,_tmpRating);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Boolean> isTourSaved(final String tourId) {
    final String _sql = "SELECT EXISTS (SELECT 1 FROM tours_table WHERE id = ?) ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, tourId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tours_table"}, new Callable<Boolean>() {
      @Override
      @NonNull
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp != 0;
          } else {
            _result = false;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
