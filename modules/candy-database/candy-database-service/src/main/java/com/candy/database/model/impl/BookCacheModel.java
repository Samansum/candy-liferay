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

package com.candy.database.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.candy.database.model.Book;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookCacheModel implements CacheModel<Book>, Externalizable {

  @Override
  public boolean equals (Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof BookCacheModel)) {
      return false;
    }

    BookCacheModel bookCacheModel = (BookCacheModel) obj;

    if (bookId == bookCacheModel.bookId) {
      return true;
    }

    return false;
  }

  @Override
  public int hashCode () {
    return HashUtil.hash(0, bookId);
  }

  @Override
  public String toString () {
    StringBundler sb = new StringBundler(11);

    sb.append("{uuid=");
    sb.append(uuid);
    sb.append(", bookId=");
    sb.append(bookId);
    sb.append(", bookTitle=");
    sb.append(bookTitle);
    sb.append(", author=");
    sb.append(author);
    sb.append(", publishDate=");
    sb.append(publishDate);
    sb.append("}");

    return sb.toString();
  }

  @Override
  public Book toEntityModel () {
    BookImpl bookImpl = new BookImpl();

    if (uuid == null) {
      bookImpl.setUuid("");
    } else {
      bookImpl.setUuid(uuid);
    }

    bookImpl.setBookId(bookId);

    if (bookTitle == null) {
      bookImpl.setBookTitle("");
    } else {
      bookImpl.setBookTitle(bookTitle);
    }

    if (author == null) {
      bookImpl.setAuthor("");
    } else {
      bookImpl.setAuthor(author);
    }

    if (publishDate == Long.MIN_VALUE) {
      bookImpl.setPublishDate(null);
    } else {
      bookImpl.setPublishDate(new Date(publishDate));
    }

    bookImpl.resetOriginalValues();

    return bookImpl;
  }

  @Override
  public void readExternal (ObjectInput objectInput) throws IOException {
    uuid = objectInput.readUTF();

    bookId = objectInput.readLong();
    bookTitle = objectInput.readUTF();
    author = objectInput.readUTF();
    publishDate = objectInput.readLong();
  }

  @Override
  public void writeExternal (ObjectOutput objectOutput)
      throws IOException {
    if (uuid == null) {
      objectOutput.writeUTF("");
    } else {
      objectOutput.writeUTF(uuid);
    }

    objectOutput.writeLong(bookId);

    if (bookTitle == null) {
      objectOutput.writeUTF("");
    } else {
      objectOutput.writeUTF(bookTitle);
    }

    if (author == null) {
      objectOutput.writeUTF("");
    } else {
      objectOutput.writeUTF(author);
    }

    objectOutput.writeLong(publishDate);
  }

  public String uuid;
  public long bookId;
  public String bookTitle;
  public String author;
  public long publishDate;
}