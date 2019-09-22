/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.candy.database.model;

import aQute.bnd.annotation.ProviderType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class BookSoap implements Serializable {

  public static BookSoap toSoapModel (Book model) {
    BookSoap soapModel = new BookSoap();

    soapModel.setUuid(model.getUuid());
    soapModel.setBookId(model.getBookId());
    soapModel.setBookTitle(model.getBookTitle());
    soapModel.setAuthor(model.getAuthor());
    soapModel.setPublishDate(model.getPublishDate());

    return soapModel;
  }

  public static BookSoap[] toSoapModels (Book[] models) {
    BookSoap[] soapModels = new BookSoap[models.length];

    for (int i = 0; i < models.length; i++) {
      soapModels[i] = toSoapModel(models[i]);
    }

    return soapModels;
  }

  public static BookSoap[][] toSoapModels (Book[][] models) {
    BookSoap[][] soapModels = null;

    if (models.length > 0) {
      soapModels = new BookSoap[models.length][models[0].length];
    } else {
      soapModels = new BookSoap[0][0];
    }

    for (int i = 0; i < models.length; i++) {
      soapModels[i] = toSoapModels(models[i]);
    }

    return soapModels;
  }

  public static BookSoap[] toSoapModels (List<Book> models) {
    List<BookSoap> soapModels = new ArrayList<BookSoap>(models.size());

    for (Book model : models) {
      soapModels.add(toSoapModel(model));
    }

    return soapModels.toArray(new BookSoap[soapModels.size()]);
  }

  public BookSoap () {
  }

  public long getPrimaryKey () {
    return _bookId;
  }

  public void setPrimaryKey (long pk) {
    setBookId(pk);
  }

  public String getUuid () {
    return _uuid;
  }

  public void setUuid (String uuid) {
    _uuid = uuid;
  }

  public long getBookId () {
    return _bookId;
  }

  public void setBookId (long bookId) {
    _bookId = bookId;
  }

  public String getBookTitle () {
    return _bookTitle;
  }

  public void setBookTitle (String bookTitle) {
    _bookTitle = bookTitle;
  }

  public String getAuthor () {
    return _author;
  }

  public void setAuthor (String author) {
    _author = author;
  }

  public Date getPublishDate () {
    return _publishDate;
  }

  public void setPublishDate (Date publishDate) {
    _publishDate = publishDate;
  }

  private String _uuid;
  private long _bookId;
  private String _bookTitle;
  private String _author;
  private Date _publishDate;
}