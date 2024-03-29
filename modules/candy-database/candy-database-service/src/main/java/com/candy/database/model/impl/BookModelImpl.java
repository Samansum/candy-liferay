/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.candy.database.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.candy.database.model.Book;
import com.candy.database.model.BookModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import java.io.Serializable;
import java.sql.Types;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Book service. Represents a row in the &quot;Candy_Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link BookModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookImpl
 * @see Book
 * @see BookModel
 * @generated
 */
@ProviderType
public class BookModelImpl extends BaseModelImpl<Book> implements BookModel {

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never modify or reference this class directly. All methods that expect a book model instance should use the {@link Book} interface instead.
   */
  public static final String TABLE_NAME = "Candy_Book";
  public static final Object[][] TABLE_COLUMNS = {
      {"uuid_", Types.VARCHAR},
      {"bookId", Types.BIGINT},
      {"bookTitle", Types.VARCHAR},
      {"author", Types.VARCHAR},
      {"publishDate", Types.TIMESTAMP}
  };
  public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

  static {
    TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
    TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
    TABLE_COLUMNS_MAP.put("bookTitle", Types.VARCHAR);
    TABLE_COLUMNS_MAP.put("author", Types.VARCHAR);
    TABLE_COLUMNS_MAP.put("publishDate", Types.TIMESTAMP);
  }

  public static final String TABLE_SQL_CREATE = "create table Candy_Book (uuid_ VARCHAR(75) null,bookId LONG not null primary key,bookTitle VARCHAR(75) null,author VARCHAR(75) null,publishDate DATE null)";
  public static final String TABLE_SQL_DROP = "drop table Candy_Book";
  public static final String ORDER_BY_JPQL = " ORDER BY book.bookId ASC";
  public static final String ORDER_BY_SQL = " ORDER BY Candy_Book.bookId ASC";
  public static final String DATA_SOURCE = "liferayDataSource";
  public static final String SESSION_FACTORY = "liferaySessionFactory";
  public static final String TX_MANAGER = "liferayTransactionManager";
  public static final boolean ENTITY_CACHE_ENABLED = GetterUtil
      .getBoolean(com.candy.database.service.util.ServiceProps.get(
          "value.object.entity.cache.enabled.com.candy.database.model.Book"),
          true);
  public static final boolean FINDER_CACHE_ENABLED = GetterUtil
      .getBoolean(com.candy.database.service.util.ServiceProps.get(
          "value.object.finder.cache.enabled.com.candy.database.model.Book"),
          true);
  public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil
      .getBoolean(com.candy.database.service.util.ServiceProps.get(
          "value.object.column.bitmask.enabled.com.candy.database.model.Book"),
          true);
  public static final long AUTHOR_COLUMN_BITMASK = 1L;
  public static final long PUBLISHDATE_COLUMN_BITMASK = 2L;
  public static final long UUID_COLUMN_BITMASK = 4L;
  public static final long BOOKID_COLUMN_BITMASK = 8L;
  public static final long LOCK_EXPIRATION_TIME = GetterUtil
      .getLong(com.candy.database.service.util.ServiceProps.get(
          "lock.expiration.time.com.candy.database.model.Book"));

  public BookModelImpl () {
  }

  @Override
  public long getPrimaryKey () {
    return _bookId;
  }

  @Override
  public void setPrimaryKey (long primaryKey) {
    setBookId(primaryKey);
  }

  @Override
  public Serializable getPrimaryKeyObj () {
    return _bookId;
  }

  @Override
  public void setPrimaryKeyObj (Serializable primaryKeyObj) {
    setPrimaryKey(((Long) primaryKeyObj).longValue());
  }

  @Override
  public Class<?> getModelClass () {
    return Book.class;
  }

  @Override
  public String getModelClassName () {
    return Book.class.getName();
  }

  @Override
  public Map<String, Object> getModelAttributes () {
    Map<String, Object> attributes = new HashMap<String, Object>();

    Map<String, Function<Book, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

    for (Map.Entry<String, Function<Book, Object>> entry : attributeGetterFunctions.entrySet()) {
      String attributeName = entry.getKey();
      Function<Book, Object> attributeGetterFunction = entry.getValue();

      attributes.put(attributeName,
          attributeGetterFunction.apply((Book) this));
    }

    attributes.put("entityCacheEnabled", isEntityCacheEnabled());
    attributes.put("finderCacheEnabled", isFinderCacheEnabled());

    return attributes;
  }

  @Override
  public void setModelAttributes (Map<String, Object> attributes) {
    Map<String, BiConsumer<Book, Object>> attributeSetterBiConsumers = getAttributeSetterBiConsumers();

    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
      String attributeName = entry.getKey();

      BiConsumer<Book, Object> attributeSetterBiConsumer = attributeSetterBiConsumers
          .get(attributeName);

      if (attributeSetterBiConsumer != null) {
        attributeSetterBiConsumer.accept((Book) this, entry.getValue());
      }
    }
  }

  public Map<String, Function<Book, Object>> getAttributeGetterFunctions () {
    return _attributeGetterFunctions;
  }

  public Map<String, BiConsumer<Book, Object>> getAttributeSetterBiConsumers () {
    return _attributeSetterBiConsumers;
  }

  private static final Map<String, Function<Book, Object>> _attributeGetterFunctions;
  private static final Map<String, BiConsumer<Book, Object>> _attributeSetterBiConsumers;

  static {
    Map<String, Function<Book, Object>> attributeGetterFunctions = new LinkedHashMap<String, Function<Book, Object>>();
    Map<String, BiConsumer<Book, ?>> attributeSetterBiConsumers = new LinkedHashMap<String, BiConsumer<Book, ?>>();

    attributeGetterFunctions.put(
        "uuid",
        new Function<Book, Object>() {

          @Override
          public Object apply (Book book) {
            return book.getUuid();
          }

        });
    attributeSetterBiConsumers.put(
        "uuid",
        new BiConsumer<Book, Object>() {

          @Override
          public void accept (Book book, Object uuid) {
            book.setUuid((String) uuid);
          }

        });
    attributeGetterFunctions.put(
        "bookId",
        new Function<Book, Object>() {

          @Override
          public Object apply (Book book) {
            return book.getBookId();
          }

        });
    attributeSetterBiConsumers.put(
        "bookId",
        new BiConsumer<Book, Object>() {

          @Override
          public void accept (Book book, Object bookId) {
            book.setBookId((Long) bookId);
          }

        });
    attributeGetterFunctions.put(
        "bookTitle",
        new Function<Book, Object>() {

          @Override
          public Object apply (Book book) {
            return book.getBookTitle();
          }

        });
    attributeSetterBiConsumers.put(
        "bookTitle",
        new BiConsumer<Book, Object>() {

          @Override
          public void accept (Book book, Object bookTitle) {
            book.setBookTitle((String) bookTitle);
          }

        });
    attributeGetterFunctions.put(
        "author",
        new Function<Book, Object>() {

          @Override
          public Object apply (Book book) {
            return book.getAuthor();
          }

        });
    attributeSetterBiConsumers.put(
        "author",
        new BiConsumer<Book, Object>() {

          @Override
          public void accept (Book book, Object author) {
            book.setAuthor((String) author);
          }

        });
    attributeGetterFunctions.put(
        "publishDate",
        new Function<Book, Object>() {

          @Override
          public Object apply (Book book) {
            return book.getPublishDate();
          }

        });
    attributeSetterBiConsumers.put(
        "publishDate",
        new BiConsumer<Book, Object>() {

          @Override
          public void accept (Book book, Object publishDate) {
            book.setPublishDate((Date) publishDate);
          }

        });

    _attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
    _attributeSetterBiConsumers = Collections.unmodifiableMap((Map) attributeSetterBiConsumers);
  }

  @Override
  public String getUuid () {
    if (_uuid == null) {
      return "";
    } else {
      return _uuid;
    }
  }

  @Override
  public void setUuid (String uuid) {
    _columnBitmask |= UUID_COLUMN_BITMASK;

    if (_originalUuid == null) {
      _originalUuid = _uuid;
    }

    _uuid = uuid;
  }

  public String getOriginalUuid () {
    return GetterUtil.getString(_originalUuid);
  }

  @Override
  public long getBookId () {
    return _bookId;
  }

  @Override
  public void setBookId (long bookId) {
    _bookId = bookId;
  }

  @Override
  public String getBookTitle () {
    if (_bookTitle == null) {
      return "";
    } else {
      return _bookTitle;
    }
  }

  @Override
  public void setBookTitle (String bookTitle) {
    _bookTitle = bookTitle;
  }

  @Override
  public String getAuthor () {
    if (_author == null) {
      return "";
    } else {
      return _author;
    }
  }

  @Override
  public void setAuthor (String author) {
    _columnBitmask |= AUTHOR_COLUMN_BITMASK;

    if (_originalAuthor == null) {
      _originalAuthor = _author;
    }

    _author = author;
  }

  public String getOriginalAuthor () {
    return GetterUtil.getString(_originalAuthor);
  }

  @Override
  public Date getPublishDate () {
    return _publishDate;
  }

  @Override
  public void setPublishDate (Date publishDate) {
    _columnBitmask |= PUBLISHDATE_COLUMN_BITMASK;

    if (_originalPublishDate == null) {
      _originalPublishDate = _publishDate;
    }

    _publishDate = publishDate;
  }

  public Date getOriginalPublishDate () {
    return _originalPublishDate;
  }

  public long getColumnBitmask () {
    return _columnBitmask;
  }

  @Override
  public ExpandoBridge getExpandoBridge () {
    return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
        Book.class.getName(), getPrimaryKey());
  }

  @Override
  public void setExpandoBridgeAttributes (ServiceContext serviceContext) {
    ExpandoBridge expandoBridge = getExpandoBridge();

    expandoBridge.setAttributes(serviceContext);
  }

  @Override
  public Book toEscapedModel () {
    if (_escapedModel == null) {
      _escapedModel = (Book) ProxyUtil.newProxyInstance(_classLoader,
          _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
    }

    return _escapedModel;
  }

  @Override
  public Object clone () {
    BookImpl bookImpl = new BookImpl();

    bookImpl.setUuid(getUuid());
    bookImpl.setBookId(getBookId());
    bookImpl.setBookTitle(getBookTitle());
    bookImpl.setAuthor(getAuthor());
    bookImpl.setPublishDate(getPublishDate());

    bookImpl.resetOriginalValues();

    return bookImpl;
  }

  @Override
  public int compareTo (Book book) {
    long primaryKey = book.getPrimaryKey();

    if (getPrimaryKey() < primaryKey) {
      return -1;
    } else if (getPrimaryKey() > primaryKey) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public boolean equals (Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Book)) {
      return false;
    }

    Book book = (Book) obj;

    long primaryKey = book.getPrimaryKey();

    if (getPrimaryKey() == primaryKey) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode () {
    return (int) getPrimaryKey();
  }

  @Override
  public boolean isEntityCacheEnabled () {
    return ENTITY_CACHE_ENABLED;
  }

  @Override
  public boolean isFinderCacheEnabled () {
    return FINDER_CACHE_ENABLED;
  }

  @Override
  public void resetOriginalValues () {
    BookModelImpl bookModelImpl = this;

    bookModelImpl._originalUuid = bookModelImpl._uuid;

    bookModelImpl._originalAuthor = bookModelImpl._author;

    bookModelImpl._originalPublishDate = bookModelImpl._publishDate;

    bookModelImpl._columnBitmask = 0;
  }

  @Override
  public CacheModel<Book> toCacheModel () {
    BookCacheModel bookCacheModel = new BookCacheModel();

    bookCacheModel.uuid = getUuid();

    String uuid = bookCacheModel.uuid;

    if ((uuid != null) && (uuid.length() == 0)) {
      bookCacheModel.uuid = null;
    }

    bookCacheModel.bookId = getBookId();

    bookCacheModel.bookTitle = getBookTitle();

    String bookTitle = bookCacheModel.bookTitle;

    if ((bookTitle != null) && (bookTitle.length() == 0)) {
      bookCacheModel.bookTitle = null;
    }

    bookCacheModel.author = getAuthor();

    String author = bookCacheModel.author;

    if ((author != null) && (author.length() == 0)) {
      bookCacheModel.author = null;
    }

    Date publishDate = getPublishDate();

    if (publishDate != null) {
      bookCacheModel.publishDate = publishDate.getTime();
    } else {
      bookCacheModel.publishDate = Long.MIN_VALUE;
    }

    return bookCacheModel;
  }

  @Override
  public String toString () {
    Map<String, Function<Book, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

    StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
        2);

    sb.append("{");

    for (Map.Entry<String, Function<Book, Object>> entry : attributeGetterFunctions.entrySet()) {
      String attributeName = entry.getKey();
      Function<Book, Object> attributeGetterFunction = entry.getValue();

      sb.append(attributeName);
      sb.append("=");
      sb.append(attributeGetterFunction.apply((Book) this));
      sb.append(", ");
    }

    if (sb.index() > 1) {
      sb.setIndex(sb.index() - 1);
    }

    sb.append("}");

    return sb.toString();
  }

  @Override
  public String toXmlString () {
    Map<String, Function<Book, Object>> attributeGetterFunctions = getAttributeGetterFunctions();

    StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
        4);

    sb.append("<model><model-name>");
    sb.append(getModelClassName());
    sb.append("</model-name>");

    for (Map.Entry<String, Function<Book, Object>> entry : attributeGetterFunctions.entrySet()) {
      String attributeName = entry.getKey();
      Function<Book, Object> attributeGetterFunction = entry.getValue();

      sb.append("<column><column-name>");
      sb.append(attributeName);
      sb.append("</column-name><column-value><![CDATA[");
      sb.append(attributeGetterFunction.apply((Book) this));
      sb.append("]]></column-value></column>");
    }

    sb.append("</model>");

    return sb.toString();
  }

  private static final ClassLoader _classLoader = Book.class.getClassLoader();
  private static final Class<?>[] _escapedModelInterfaces = new Class[]{
      Book.class, ModelWrapper.class
  };
  private String _uuid;
  private String _originalUuid;
  private long _bookId;
  private String _bookTitle;
  private String _author;
  private String _originalAuthor;
  private Date _publishDate;
  private Date _originalPublishDate;
  private long _columnBitmask;
  private Book _escapedModel;
}