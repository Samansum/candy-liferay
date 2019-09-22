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

package com.candy.database.model;

import aQute.bnd.annotation.ProviderType;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookWrapper implements Book, ModelWrapper<Book> {

  public BookWrapper (Book book) {
    _book = book;
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

    attributes.put("uuid", getUuid());
    attributes.put("bookId", getBookId());
    attributes.put("bookTitle", getBookTitle());
    attributes.put("author", getAuthor());
    attributes.put("publishDate", getPublishDate());

    return attributes;
  }

  @Override
  public void setModelAttributes (Map<String, Object> attributes) {
    String uuid = (String) attributes.get("uuid");

    if (uuid != null) {
      setUuid(uuid);
    }

    Long bookId = (Long) attributes.get("bookId");

    if (bookId != null) {
      setBookId(bookId);
    }

    String bookTitle = (String) attributes.get("bookTitle");

    if (bookTitle != null) {
      setBookTitle(bookTitle);
    }

    String author = (String) attributes.get("author");

    if (author != null) {
      setAuthor(author);
    }

    Date publishDate = (Date) attributes.get("publishDate");

    if (publishDate != null) {
      setPublishDate(publishDate);
    }
  }

  @Override
  public Object clone () {
    return new BookWrapper((Book) _book.clone());
  }

  @Override
  public int compareTo (Book book) {
    return _book.compareTo(book);
  }

  /**
   * Returns the author of this book.
   *
   * @return the author of this book
   */
  @Override
  public String getAuthor () {
    return _book.getAuthor();
  }

  /**
   * Returns the book ID of this book.
   *
   * @return the book ID of this book
   */
  @Override
  public long getBookId () {
    return _book.getBookId();
  }

  /**
   * Returns the book title of this book.
   *
   * @return the book title of this book
   */
  @Override
  public String getBookTitle () {
    return _book.getBookTitle();
  }

  @Override
  public ExpandoBridge getExpandoBridge () {
    return _book.getExpandoBridge();
  }

  /**
   * Returns the primary key of this book.
   *
   * @return the primary key of this book
   */
  @Override
  public long getPrimaryKey () {
    return _book.getPrimaryKey();
  }

  @Override
  public Serializable getPrimaryKeyObj () {
    return _book.getPrimaryKeyObj();
  }

  /**
   * Returns the publish date of this book.
   *
   * @return the publish date of this book
   */
  @Override
  public Date getPublishDate () {
    return _book.getPublishDate();
  }

  /**
   * Returns the uuid of this book.
   *
   * @return the uuid of this book
   */
  @Override
  public String getUuid () {
    return _book.getUuid();
  }

  @Override
  public int hashCode () {
    return _book.hashCode();
  }

  @Override
  public boolean isCachedModel () {
    return _book.isCachedModel();
  }

  @Override
  public boolean isEscapedModel () {
    return _book.isEscapedModel();
  }

  @Override
  public boolean isNew () {
    return _book.isNew();
  }

  @Override
  public void persist () {
    _book.persist();
  }

  /**
   * Sets the author of this book.
   *
   * @param author the author of this book
   */
  @Override
  public void setAuthor (String author) {
    _book.setAuthor(author);
  }

  /**
   * Sets the book ID of this book.
   *
   * @param bookId the book ID of this book
   */
  @Override
  public void setBookId (long bookId) {
    _book.setBookId(bookId);
  }

  /**
   * Sets the book title of this book.
   *
   * @param bookTitle the book title of this book
   */
  @Override
  public void setBookTitle (String bookTitle) {
    _book.setBookTitle(bookTitle);
  }

  @Override
  public void setCachedModel (boolean cachedModel) {
    _book.setCachedModel(cachedModel);
  }

  @Override
  public void setExpandoBridgeAttributes (
      com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
    _book.setExpandoBridgeAttributes(baseModel);
  }

  @Override
  public void setExpandoBridgeAttributes (ExpandoBridge expandoBridge) {
    _book.setExpandoBridgeAttributes(expandoBridge);
  }

  @Override
  public void setExpandoBridgeAttributes (ServiceContext serviceContext) {
    _book.setExpandoBridgeAttributes(serviceContext);
  }

  @Override
  public void setNew (boolean n) {
    _book.setNew(n);
  }

  /**
   * Sets the primary key of this book.
   *
   * @param primaryKey the primary key of this book
   */
  @Override
  public void setPrimaryKey (long primaryKey) {
    _book.setPrimaryKey(primaryKey);
  }

  @Override
  public void setPrimaryKeyObj (Serializable primaryKeyObj) {
    _book.setPrimaryKeyObj(primaryKeyObj);
  }

  /**
   * Sets the publish date of this book.
   *
   * @param publishDate the publish date of this book
   */
  @Override
  public void setPublishDate (Date publishDate) {
    _book.setPublishDate(publishDate);
  }

  /**
   * Sets the uuid of this book.
   *
   * @param uuid the uuid of this book
   */
  @Override
  public void setUuid (String uuid) {
    _book.setUuid(uuid);
  }

  @Override
  public com.liferay.portal.kernel.model.CacheModel<Book> toCacheModel () {
    return _book.toCacheModel();
  }

  @Override
  public Book toEscapedModel () {
    return new BookWrapper(_book.toEscapedModel());
  }

  @Override
  public String toString () {
    return _book.toString();
  }

  @Override
  public Book toUnescapedModel () {
    return new BookWrapper(_book.toUnescapedModel());
  }

  @Override
  public String toXmlString () {
    return _book.toXmlString();
  }

  @Override
  public boolean equals (Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof BookWrapper)) {
      return false;
    }

    BookWrapper bookWrapper = (BookWrapper) obj;

    if (Objects.equals(_book, bookWrapper._book)) {
      return true;
    }

    return false;
  }

  @Override
  public Book getWrappedModel () {
    return _book;
  }

  @Override
  public boolean isEntityCacheEnabled () {
    return _book.isEntityCacheEnabled();
  }

  @Override
  public boolean isFinderCacheEnabled () {
    return _book.isFinderCacheEnabled();
  }

  @Override
  public void resetOriginalValues () {
    _book.resetOriginalValues();
  }

  private final Book _book;
}