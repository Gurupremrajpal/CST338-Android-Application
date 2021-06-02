package com.guruprem.project2_cst338.Database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.guruprem.project2_cst338.EcommerceLog;
import com.guruprem.project2_cst338.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EcommerceDAO_Impl implements EcommerceDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EcommerceLog> __insertionAdapterOfEcommerceLog;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<EcommerceLog> __deletionAdapterOfEcommerceLog;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<EcommerceLog> __updateAdapterOfEcommerceLog;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public EcommerceDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEcommerceLog = new EntityInsertionAdapter<EcommerceLog>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ECOMMERCE_TABLE` (`mUserId`,`mExercise`,`mReps`,`mWeight`,`mUsername`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EcommerceLog value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getExercise() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getExercise());
        }
        stmt.bindLong(3, value.getReps());
        stmt.bindDouble(4, value.getWeight());
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
      }
    };
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `USER_TABLE` (`mUserId`,`mUsername`,`mPassword`,`mOldPass`,`mNewPass`,`mConfPass`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getOldPass() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOldPass());
        }
        if (value.getNewPass() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNewPass());
        }
        if (value.getConfPass() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getConfPass());
        }
      }
    };
    this.__deletionAdapterOfEcommerceLog = new EntityDeletionOrUpdateAdapter<EcommerceLog>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ECOMMERCE_TABLE` WHERE `mUserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EcommerceLog value) {
        stmt.bindLong(1, value.getUserId());
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `USER_TABLE` WHERE `mUserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
      }
    };
    this.__updateAdapterOfEcommerceLog = new EntityDeletionOrUpdateAdapter<EcommerceLog>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ECOMMERCE_TABLE` SET `mUserId` = ?,`mExercise` = ?,`mReps` = ?,`mWeight` = ?,`mUsername` = ? WHERE `mUserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EcommerceLog value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getExercise() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getExercise());
        }
        stmt.bindLong(3, value.getReps());
        stmt.bindDouble(4, value.getWeight());
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
        stmt.bindLong(6, value.getUserId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `USER_TABLE` SET `mUserId` = ?,`mUsername` = ?,`mPassword` = ?,`mOldPass` = ?,`mNewPass` = ?,`mConfPass` = ? WHERE `mUserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getOldPass() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOldPass());
        }
        if (value.getNewPass() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNewPass());
        }
        if (value.getConfPass() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getConfPass());
        }
        stmt.bindLong(7, value.getUserId());
      }
    };
  }

  @Override
  public void insert(final EcommerceLog... gymLogs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEcommerceLog.insert(gymLogs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final User... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EcommerceLog gymLog) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEcommerceLog.handle(gymLog);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EcommerceLog... gymLogs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEcommerceLog.handleMultiple(gymLogs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handleMultiple(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EcommerceLog> getAllGymLogs() {
    final String _sql = "SELECT * FROM ECOMMERCE_TABLE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMExercise = CursorUtil.getColumnIndexOrThrow(_cursor, "mExercise");
      final int _cursorIndexOfMReps = CursorUtil.getColumnIndexOrThrow(_cursor, "mReps");
      final int _cursorIndexOfMWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "mWeight");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final List<EcommerceLog> _result = new ArrayList<EcommerceLog>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EcommerceLog _item;
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        final String _tmpMExercise;
        if (_cursor.isNull(_cursorIndexOfMExercise)) {
          _tmpMExercise = null;
        } else {
          _tmpMExercise = _cursor.getString(_cursorIndexOfMExercise);
        }
        final int _tmpMReps;
        _tmpMReps = _cursor.getInt(_cursorIndexOfMReps);
        final double _tmpMWeight;
        _tmpMWeight = _cursor.getDouble(_cursorIndexOfMWeight);
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        _item = new EcommerceLog(_tmpMUserId,_tmpMExercise,_tmpMReps,_tmpMWeight,_tmpMUsername);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EcommerceLog> getGymLogsById(final int userId) {
    final String _sql = "SELECT * FROM ECOMMERCE_TABLE WHERE mUserId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMExercise = CursorUtil.getColumnIndexOrThrow(_cursor, "mExercise");
      final int _cursorIndexOfMReps = CursorUtil.getColumnIndexOrThrow(_cursor, "mReps");
      final int _cursorIndexOfMWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "mWeight");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final List<EcommerceLog> _result = new ArrayList<EcommerceLog>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EcommerceLog _item;
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        final String _tmpMExercise;
        if (_cursor.isNull(_cursorIndexOfMExercise)) {
          _tmpMExercise = null;
        } else {
          _tmpMExercise = _cursor.getString(_cursorIndexOfMExercise);
        }
        final int _tmpMReps;
        _tmpMReps = _cursor.getInt(_cursorIndexOfMReps);
        final double _tmpMWeight;
        _tmpMWeight = _cursor.getDouble(_cursorIndexOfMWeight);
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        _item = new EcommerceLog(_tmpMUserId,_tmpMExercise,_tmpMReps,_tmpMWeight,_tmpMUsername);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EcommerceLog> getGymLogsByUserId(final int userId) {
    final String _sql = "SELECT * FROM ECOMMERCE_TABLE WHERE mUserId = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMExercise = CursorUtil.getColumnIndexOrThrow(_cursor, "mExercise");
      final int _cursorIndexOfMReps = CursorUtil.getColumnIndexOrThrow(_cursor, "mReps");
      final int _cursorIndexOfMWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "mWeight");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final List<EcommerceLog> _result = new ArrayList<EcommerceLog>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EcommerceLog _item;
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        final String _tmpMExercise;
        if (_cursor.isNull(_cursorIndexOfMExercise)) {
          _tmpMExercise = null;
        } else {
          _tmpMExercise = _cursor.getString(_cursorIndexOfMExercise);
        }
        final int _tmpMReps;
        _tmpMReps = _cursor.getInt(_cursorIndexOfMReps);
        final double _tmpMWeight;
        _tmpMWeight = _cursor.getDouble(_cursorIndexOfMWeight);
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        _item = new EcommerceLog(_tmpMUserId,_tmpMExercise,_tmpMReps,_tmpMWeight,_tmpMUsername);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByUsername(final String username) {
    final String _sql = "SELECT * FROM USER_TABLE WHERE mUsername =? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final int _cursorIndexOfMOldPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mOldPass");
      final int _cursorIndexOfMNewPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mNewPass");
      final int _cursorIndexOfMConfPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mConfPass");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        _result = new User(_tmpMUsername,_tmpMPassword);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        _result.setUserId(_tmpMUserId);
        final String _tmpMOldPass;
        if (_cursor.isNull(_cursorIndexOfMOldPass)) {
          _tmpMOldPass = null;
        } else {
          _tmpMOldPass = _cursor.getString(_cursorIndexOfMOldPass);
        }
        _result.setOldPass(_tmpMOldPass);
        final String _tmpMNewPass;
        if (_cursor.isNull(_cursorIndexOfMNewPass)) {
          _tmpMNewPass = null;
        } else {
          _tmpMNewPass = _cursor.getString(_cursorIndexOfMNewPass);
        }
        _result.setNewPass(_tmpMNewPass);
        final String _tmpMConfPass;
        if (_cursor.isNull(_cursorIndexOfMConfPass)) {
          _tmpMConfPass = null;
        } else {
          _tmpMConfPass = _cursor.getString(_cursorIndexOfMConfPass);
        }
        _result.setConfPass(_tmpMConfPass);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getAllUsers() {
    final String _sql = "SELECT * FROM USER_TABLE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final int _cursorIndexOfMOldPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mOldPass");
      final int _cursorIndexOfMNewPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mNewPass");
      final int _cursorIndexOfMConfPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mConfPass");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        _item = new User(_tmpMUsername,_tmpMPassword);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        _item.setUserId(_tmpMUserId);
        final String _tmpMOldPass;
        if (_cursor.isNull(_cursorIndexOfMOldPass)) {
          _tmpMOldPass = null;
        } else {
          _tmpMOldPass = _cursor.getString(_cursorIndexOfMOldPass);
        }
        _item.setOldPass(_tmpMOldPass);
        final String _tmpMNewPass;
        if (_cursor.isNull(_cursorIndexOfMNewPass)) {
          _tmpMNewPass = null;
        } else {
          _tmpMNewPass = _cursor.getString(_cursorIndexOfMNewPass);
        }
        _item.setNewPass(_tmpMNewPass);
        final String _tmpMConfPass;
        if (_cursor.isNull(_cursorIndexOfMConfPass)) {
          _tmpMConfPass = null;
        } else {
          _tmpMConfPass = _cursor.getString(_cursorIndexOfMConfPass);
        }
        _item.setConfPass(_tmpMConfPass);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByUserId(final int userId) {
    final String _sql = "SELECT * FROM USER_TABLE WHERE mUserId =? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "mUsername");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final int _cursorIndexOfMOldPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mOldPass");
      final int _cursorIndexOfMNewPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mNewPass");
      final int _cursorIndexOfMConfPass = CursorUtil.getColumnIndexOrThrow(_cursor, "mConfPass");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMUsername;
        if (_cursor.isNull(_cursorIndexOfMUsername)) {
          _tmpMUsername = null;
        } else {
          _tmpMUsername = _cursor.getString(_cursorIndexOfMUsername);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        _result = new User(_tmpMUsername,_tmpMPassword);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        _result.setUserId(_tmpMUserId);
        final String _tmpMOldPass;
        if (_cursor.isNull(_cursorIndexOfMOldPass)) {
          _tmpMOldPass = null;
        } else {
          _tmpMOldPass = _cursor.getString(_cursorIndexOfMOldPass);
        }
        _result.setOldPass(_tmpMOldPass);
        final String _tmpMNewPass;
        if (_cursor.isNull(_cursorIndexOfMNewPass)) {
          _tmpMNewPass = null;
        } else {
          _tmpMNewPass = _cursor.getString(_cursorIndexOfMNewPass);
        }
        _result.setNewPass(_tmpMNewPass);
        final String _tmpMConfPass;
        if (_cursor.isNull(_cursorIndexOfMConfPass)) {
          _tmpMConfPass = null;
        } else {
          _tmpMConfPass = _cursor.getString(_cursorIndexOfMConfPass);
        }
        _result.setConfPass(_tmpMConfPass);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
