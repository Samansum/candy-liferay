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

package com.candy.database.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;
import com.candy.database.exception.NoSuchBookException;
import com.candy.database.model.Book;
import com.candy.database.model.impl.BookImpl;
import com.candy.database.model.impl.BookModelImpl;
import com.candy.database.service.persistence.BookPersistence;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see com.candy.database.service.persistence.BookUtil
 * @generated
 */
@ProviderType
public class BookPersistenceImpl extends BasePersistenceImpl<Book>
    implements BookPersistence {

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never modify or reference this class directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
   */
  public static final String FINDER_CLASS_NAME_ENTITY = BookImpl.class.getName();
  public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
      ".List1";
  public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
      ".List2";
  private FinderPath _finderPathWithPaginationFindAll;
  private FinderPath _finderPathWithoutPaginationFindAll;
  private FinderPath _finderPathCountAll;
  private FinderPath _finderPathWithPaginationFindByUuid;
  private FinderPath _finderPathWithoutPaginationFindByUuid;
  private FinderPath _finderPathCountByUuid;

  /**
   * Returns all the books where uuid = &#63;.
   *
   * @param uuid the uuid
   * @return the matching books
   */
  @Override
  public List<Book> findByUuid (String uuid) {
    return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
  }

  /**
   * Returns a range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param uuid the uuid
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  @Override
  public List<Book> findByUuid (String uuid, int start, int end) {
    return findByUuid(uuid, start, end, null);
  }

  /**
   * Returns an ordered range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param uuid the uuid
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findByUuid (String uuid, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return findByUuid(uuid, start, end, orderByComparator, true);
  }

  /**
   * Returns an ordered range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param uuid the uuid
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findByUuid (String uuid, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    uuid = Objects.toString(uuid, "");

    boolean pagination = true;
    FinderPath finderPath = null;
    Object[] finderArgs = null;

    if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
        (orderByComparator == null)) {
      pagination = false;
      finderPath = _finderPathWithoutPaginationFindByUuid;
      finderArgs = new Object[]{uuid};
    } else {
      finderPath = _finderPathWithPaginationFindByUuid;
      finderArgs = new Object[]{uuid, start, end, orderByComparator};
    }

    List<Book> list = null;

    if (retrieveFromCache) {
      list = (List<Book>) finderCache.getResult(finderPath, finderArgs,
          this);

      if ((list != null) && !list.isEmpty()) {
        for (Book book : list) {
          if (!uuid.equals(book.getUuid())) {
            list = null;

            break;
          }
        }
      }
    }

    if (list == null) {
      StringBundler query = null;

      if (orderByComparator != null) {
        query = new StringBundler(3 +
            (orderByComparator.getOrderByFields().length * 2));
      } else {
        query = new StringBundler(3);
      }

      query.append(_SQL_SELECT_BOOK_WHERE);

      boolean bindUuid = false;

      if (uuid.isEmpty()) {
        query.append(_FINDER_COLUMN_UUID_UUID_3);
      } else {
        bindUuid = true;

        query.append(_FINDER_COLUMN_UUID_UUID_2);
      }

      if (orderByComparator != null) {
        appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
            orderByComparator);
      } else if (pagination) {
        query.append(BookModelImpl.ORDER_BY_JPQL);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
          qPos.add(uuid);
        }

        if (!pagination) {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end, false);

          Collections.sort(list);

          list = Collections.unmodifiableList(list);
        } else {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end);
        }

        cacheResult(list);

        finderCache.putResult(finderPath, finderArgs, list);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return list;
  }

  /**
   * Returns the first book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findByUuid_First (String uuid,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = fetchByUuid_First(uuid, orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(4);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("uuid=");
    msg.append(uuid);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the first book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchByUuid_First (String uuid,
      OrderByComparator<Book> orderByComparator) {
    List<Book> list = findByUuid(uuid, 0, 1, orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the last book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findByUuid_Last (String uuid,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = fetchByUuid_Last(uuid, orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(4);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("uuid=");
    msg.append(uuid);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the last book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchByUuid_Last (String uuid,
      OrderByComparator<Book> orderByComparator) {
    int count = countByUuid(uuid);

    if (count == 0) {
      return null;
    }

    List<Book> list = findByUuid(uuid, count - 1, count, orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the books before and after the current book in the ordered set where uuid = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book[] findByUuid_PrevAndNext (long bookId, String uuid,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    uuid = Objects.toString(uuid, "");

    Book book = findByPrimaryKey(bookId);

    Session session = null;

    try {
      session = openSession();

      Book[] array = new BookImpl[3];

      array[0] = getByUuid_PrevAndNext(session, book, uuid,
          orderByComparator, true);

      array[1] = book;

      array[2] = getByUuid_PrevAndNext(session, book, uuid,
          orderByComparator, false);

      return array;
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }
  }

  protected Book getByUuid_PrevAndNext (Session session, Book book,
      String uuid, OrderByComparator<Book> orderByComparator, boolean previous) {
    StringBundler query = null;

    if (orderByComparator != null) {
      query = new StringBundler(4 +
          (orderByComparator.getOrderByConditionFields().length * 3) +
          (orderByComparator.getOrderByFields().length * 3));
    } else {
      query = new StringBundler(3);
    }

    query.append(_SQL_SELECT_BOOK_WHERE);

    boolean bindUuid = false;

    if (uuid.isEmpty()) {
      query.append(_FINDER_COLUMN_UUID_UUID_3);
    } else {
      bindUuid = true;

      query.append(_FINDER_COLUMN_UUID_UUID_2);
    }

    if (orderByComparator != null) {
      String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

      if (orderByConditionFields.length > 0) {
        query.append(WHERE_AND);
      }

      for (int i = 0; i < orderByConditionFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByConditionFields[i]);

        if ((i + 1) < orderByConditionFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN_HAS_NEXT);
          } else {
            query.append(WHERE_LESSER_THAN_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN);
          } else {
            query.append(WHERE_LESSER_THAN);
          }
        }
      }

      query.append(ORDER_BY_CLAUSE);

      String[] orderByFields = orderByComparator.getOrderByFields();

      for (int i = 0; i < orderByFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByFields[i]);

        if ((i + 1) < orderByFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC_HAS_NEXT);
          } else {
            query.append(ORDER_BY_DESC_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC);
          } else {
            query.append(ORDER_BY_DESC);
          }
        }
      }
    } else {
      query.append(BookModelImpl.ORDER_BY_JPQL);
    }

    String sql = query.toString();

    Query q = session.createQuery(sql);

    q.setFirstResult(0);
    q.setMaxResults(2);

    QueryPos qPos = QueryPos.getInstance(q);

    if (bindUuid) {
      qPos.add(uuid);
    }

    if (orderByComparator != null) {
      for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
          book)) {
        qPos.add(orderByConditionValue);
      }
    }

    List<Book> list = q.list();

    if (list.size() == 2) {
      return list.get(1);
    } else {
      return null;
    }
  }

  /**
   * Removes all the books where uuid = &#63; from the database.
   *
   * @param uuid the uuid
   */
  @Override
  public void removeByUuid (String uuid) {
    for (Book book : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
        null)) {
      remove(book);
    }
  }

  /**
   * Returns the number of books where uuid = &#63;.
   *
   * @param uuid the uuid
   * @return the number of matching books
   */
  @Override
  public int countByUuid (String uuid) {
    uuid = Objects.toString(uuid, "");

    FinderPath finderPath = _finderPathCountByUuid;

    Object[] finderArgs = new Object[]{uuid};

    Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

    if (count == null) {
      StringBundler query = new StringBundler(2);

      query.append(_SQL_COUNT_BOOK_WHERE);

      boolean bindUuid = false;

      if (uuid.isEmpty()) {
        query.append(_FINDER_COLUMN_UUID_UUID_3);
      } else {
        bindUuid = true;

        query.append(_FINDER_COLUMN_UUID_UUID_2);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
          qPos.add(uuid);
        }

        count = (Long) q.uniqueResult();

        finderCache.putResult(finderPath, finderArgs, count);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return count.intValue();
  }

  private static final String _FINDER_COLUMN_UUID_UUID_2 = "book.uuid = ?";
  private static final String _FINDER_COLUMN_UUID_UUID_3 = "(book.uuid IS NULL OR book.uuid = '')";
  private FinderPath _finderPathWithPaginationFindBypublishDate;
  private FinderPath _finderPathWithoutPaginationFindBypublishDate;
  private FinderPath _finderPathCountBypublishDate;

  /**
   * Returns all the books where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @return the matching books
   */
  @Override
  public List<Book> findBypublishDate (Date publishDate) {
    return findBypublishDate(publishDate, QueryUtil.ALL_POS,
        QueryUtil.ALL_POS, null);
  }

  /**
   * Returns a range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  @Override
  public List<Book> findBypublishDate (Date publishDate, int start, int end) {
    return findBypublishDate(publishDate, start, end, null);
  }

  /**
   * Returns an ordered range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findBypublishDate (Date publishDate, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return findBypublishDate(publishDate, start, end, orderByComparator,
        true);
  }

  /**
   * Returns an ordered range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findBypublishDate (Date publishDate, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    boolean pagination = true;
    FinderPath finderPath = null;
    Object[] finderArgs = null;

    if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
        (orderByComparator == null)) {
      pagination = false;
      finderPath = _finderPathWithoutPaginationFindBypublishDate;
      finderArgs = new Object[]{_getTime(publishDate)};
    } else {
      finderPath = _finderPathWithPaginationFindBypublishDate;
      finderArgs = new Object[]{
          _getTime(publishDate),

          start, end, orderByComparator
      };
    }

    List<Book> list = null;

    if (retrieveFromCache) {
      list = (List<Book>) finderCache.getResult(finderPath, finderArgs,
          this);

      if ((list != null) && !list.isEmpty()) {
        for (Book book : list) {
          if (!Objects.equals(publishDate, book.getPublishDate())) {
            list = null;

            break;
          }
        }
      }
    }

    if (list == null) {
      StringBundler query = null;

      if (orderByComparator != null) {
        query = new StringBundler(3 +
            (orderByComparator.getOrderByFields().length * 2));
      } else {
        query = new StringBundler(3);
      }

      query.append(_SQL_SELECT_BOOK_WHERE);

      boolean bindPublishDate = false;

      if (publishDate == null) {
        query.append(_FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_1);
      } else {
        bindPublishDate = true;

        query.append(_FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_2);
      }

      if (orderByComparator != null) {
        appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
            orderByComparator);
      } else if (pagination) {
        query.append(BookModelImpl.ORDER_BY_JPQL);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindPublishDate) {
          qPos.add(new Timestamp(publishDate.getTime()));
        }

        if (!pagination) {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end, false);

          Collections.sort(list);

          list = Collections.unmodifiableList(list);
        } else {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end);
        }

        cacheResult(list);

        finderCache.putResult(finderPath, finderArgs, list);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return list;
  }

  /**
   * Returns the first book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findBypublishDate_First (Date publishDate,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = fetchBypublishDate_First(publishDate, orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(4);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("publishDate=");
    msg.append(publishDate);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the first book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchBypublishDate_First (Date publishDate,
      OrderByComparator<Book> orderByComparator) {
    List<Book> list = findBypublishDate(publishDate, 0, 1, orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the last book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findBypublishDate_Last (Date publishDate,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = fetchBypublishDate_Last(publishDate, orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(4);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("publishDate=");
    msg.append(publishDate);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the last book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchBypublishDate_Last (Date publishDate,
      OrderByComparator<Book> orderByComparator) {
    int count = countBypublishDate(publishDate);

    if (count == 0) {
      return null;
    }

    List<Book> list = findBypublishDate(publishDate, count - 1, count,
        orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the books before and after the current book in the ordered set where publishDate = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book[] findBypublishDate_PrevAndNext (long bookId, Date publishDate,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = findByPrimaryKey(bookId);

    Session session = null;

    try {
      session = openSession();

      Book[] array = new BookImpl[3];

      array[0] = getBypublishDate_PrevAndNext(session, book, publishDate,
          orderByComparator, true);

      array[1] = book;

      array[2] = getBypublishDate_PrevAndNext(session, book, publishDate,
          orderByComparator, false);

      return array;
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }
  }

  protected Book getBypublishDate_PrevAndNext (Session session, Book book,
      Date publishDate, OrderByComparator<Book> orderByComparator,
      boolean previous) {
    StringBundler query = null;

    if (orderByComparator != null) {
      query = new StringBundler(4 +
          (orderByComparator.getOrderByConditionFields().length * 3) +
          (orderByComparator.getOrderByFields().length * 3));
    } else {
      query = new StringBundler(3);
    }

    query.append(_SQL_SELECT_BOOK_WHERE);

    boolean bindPublishDate = false;

    if (publishDate == null) {
      query.append(_FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_1);
    } else {
      bindPublishDate = true;

      query.append(_FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_2);
    }

    if (orderByComparator != null) {
      String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

      if (orderByConditionFields.length > 0) {
        query.append(WHERE_AND);
      }

      for (int i = 0; i < orderByConditionFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByConditionFields[i]);

        if ((i + 1) < orderByConditionFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN_HAS_NEXT);
          } else {
            query.append(WHERE_LESSER_THAN_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN);
          } else {
            query.append(WHERE_LESSER_THAN);
          }
        }
      }

      query.append(ORDER_BY_CLAUSE);

      String[] orderByFields = orderByComparator.getOrderByFields();

      for (int i = 0; i < orderByFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByFields[i]);

        if ((i + 1) < orderByFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC_HAS_NEXT);
          } else {
            query.append(ORDER_BY_DESC_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC);
          } else {
            query.append(ORDER_BY_DESC);
          }
        }
      }
    } else {
      query.append(BookModelImpl.ORDER_BY_JPQL);
    }

    String sql = query.toString();

    Query q = session.createQuery(sql);

    q.setFirstResult(0);
    q.setMaxResults(2);

    QueryPos qPos = QueryPos.getInstance(q);

    if (bindPublishDate) {
      qPos.add(new Timestamp(publishDate.getTime()));
    }

    if (orderByComparator != null) {
      for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
          book)) {
        qPos.add(orderByConditionValue);
      }
    }

    List<Book> list = q.list();

    if (list.size() == 2) {
      return list.get(1);
    } else {
      return null;
    }
  }

  /**
   * Removes all the books where publishDate = &#63; from the database.
   *
   * @param publishDate the publish date
   */
  @Override
  public void removeBypublishDate (Date publishDate) {
    for (Book book : findBypublishDate(publishDate, QueryUtil.ALL_POS,
        QueryUtil.ALL_POS, null)) {
      remove(book);
    }
  }

  /**
   * Returns the number of books where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @return the number of matching books
   */
  @Override
  public int countBypublishDate (Date publishDate) {
    FinderPath finderPath = _finderPathCountBypublishDate;

    Object[] finderArgs = new Object[]{_getTime(publishDate)};

    Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

    if (count == null) {
      StringBundler query = new StringBundler(2);

      query.append(_SQL_COUNT_BOOK_WHERE);

      boolean bindPublishDate = false;

      if (publishDate == null) {
        query.append(_FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_1);
      } else {
        bindPublishDate = true;

        query.append(_FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_2);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindPublishDate) {
          qPos.add(new Timestamp(publishDate.getTime()));
        }

        count = (Long) q.uniqueResult();

        finderCache.putResult(finderPath, finderArgs, count);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return count.intValue();
  }

  private static final String _FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_1 = "book.publishDate IS NULL";
  private static final String _FINDER_COLUMN_PUBLISHDATE_PUBLISHDATE_2 = "book.publishDate = ?";
  private FinderPath _finderPathWithPaginationFindByauthor;
  private FinderPath _finderPathWithoutPaginationFindByauthor;
  private FinderPath _finderPathCountByauthor;

  /**
   * Returns all the books where author = &#63;.
   *
   * @param author the author
   * @return the matching books
   */
  @Override
  public List<Book> findByauthor (String author) {
    return findByauthor(author, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
  }

  /**
   * Returns a range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  @Override
  public List<Book> findByauthor (String author, int start, int end) {
    return findByauthor(author, start, end, null);
  }

  /**
   * Returns an ordered range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findByauthor (String author, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return findByauthor(author, start, end, orderByComparator, true);
  }

  /**
   * Returns an ordered range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findByauthor (String author, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    author = Objects.toString(author, "");

    boolean pagination = true;
    FinderPath finderPath = null;
    Object[] finderArgs = null;

    if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
        (orderByComparator == null)) {
      pagination = false;
      finderPath = _finderPathWithoutPaginationFindByauthor;
      finderArgs = new Object[]{author};
    } else {
      finderPath = _finderPathWithPaginationFindByauthor;
      finderArgs = new Object[]{author, start, end, orderByComparator};
    }

    List<Book> list = null;

    if (retrieveFromCache) {
      list = (List<Book>) finderCache.getResult(finderPath, finderArgs,
          this);

      if ((list != null) && !list.isEmpty()) {
        for (Book book : list) {
          if (!author.equals(book.getAuthor())) {
            list = null;

            break;
          }
        }
      }
    }

    if (list == null) {
      StringBundler query = null;

      if (orderByComparator != null) {
        query = new StringBundler(3 +
            (orderByComparator.getOrderByFields().length * 2));
      } else {
        query = new StringBundler(3);
      }

      query.append(_SQL_SELECT_BOOK_WHERE);

      boolean bindAuthor = false;

      if (author.isEmpty()) {
        query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
      } else {
        bindAuthor = true;

        query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
      }

      if (orderByComparator != null) {
        appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
            orderByComparator);
      } else if (pagination) {
        query.append(BookModelImpl.ORDER_BY_JPQL);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAuthor) {
          qPos.add(author);
        }

        if (!pagination) {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end, false);

          Collections.sort(list);

          list = Collections.unmodifiableList(list);
        } else {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end);
        }

        cacheResult(list);

        finderCache.putResult(finderPath, finderArgs, list);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return list;
  }

  /**
   * Returns the first book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findByauthor_First (String author,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = fetchByauthor_First(author, orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(4);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("author=");
    msg.append(author);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the first book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchByauthor_First (String author,
      OrderByComparator<Book> orderByComparator) {
    List<Book> list = findByauthor(author, 0, 1, orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the last book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findByauthor_Last (String author,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    Book book = fetchByauthor_Last(author, orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(4);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("author=");
    msg.append(author);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the last book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchByauthor_Last (String author,
      OrderByComparator<Book> orderByComparator) {
    int count = countByauthor(author);

    if (count == 0) {
      return null;
    }

    List<Book> list = findByauthor(author, count - 1, count,
        orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the books before and after the current book in the ordered set where author = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book[] findByauthor_PrevAndNext (long bookId, String author,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    author = Objects.toString(author, "");

    Book book = findByPrimaryKey(bookId);

    Session session = null;

    try {
      session = openSession();

      Book[] array = new BookImpl[3];

      array[0] = getByauthor_PrevAndNext(session, book, author,
          orderByComparator, true);

      array[1] = book;

      array[2] = getByauthor_PrevAndNext(session, book, author,
          orderByComparator, false);

      return array;
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }
  }

  protected Book getByauthor_PrevAndNext (Session session, Book book,
      String author, OrderByComparator<Book> orderByComparator,
      boolean previous) {
    StringBundler query = null;

    if (orderByComparator != null) {
      query = new StringBundler(4 +
          (orderByComparator.getOrderByConditionFields().length * 3) +
          (orderByComparator.getOrderByFields().length * 3));
    } else {
      query = new StringBundler(3);
    }

    query.append(_SQL_SELECT_BOOK_WHERE);

    boolean bindAuthor = false;

    if (author.isEmpty()) {
      query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
    } else {
      bindAuthor = true;

      query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
    }

    if (orderByComparator != null) {
      String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

      if (orderByConditionFields.length > 0) {
        query.append(WHERE_AND);
      }

      for (int i = 0; i < orderByConditionFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByConditionFields[i]);

        if ((i + 1) < orderByConditionFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN_HAS_NEXT);
          } else {
            query.append(WHERE_LESSER_THAN_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN);
          } else {
            query.append(WHERE_LESSER_THAN);
          }
        }
      }

      query.append(ORDER_BY_CLAUSE);

      String[] orderByFields = orderByComparator.getOrderByFields();

      for (int i = 0; i < orderByFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByFields[i]);

        if ((i + 1) < orderByFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC_HAS_NEXT);
          } else {
            query.append(ORDER_BY_DESC_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC);
          } else {
            query.append(ORDER_BY_DESC);
          }
        }
      }
    } else {
      query.append(BookModelImpl.ORDER_BY_JPQL);
    }

    String sql = query.toString();

    Query q = session.createQuery(sql);

    q.setFirstResult(0);
    q.setMaxResults(2);

    QueryPos qPos = QueryPos.getInstance(q);

    if (bindAuthor) {
      qPos.add(author);
    }

    if (orderByComparator != null) {
      for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
          book)) {
        qPos.add(orderByConditionValue);
      }
    }

    List<Book> list = q.list();

    if (list.size() == 2) {
      return list.get(1);
    } else {
      return null;
    }
  }

  /**
   * Removes all the books where author = &#63; from the database.
   *
   * @param author the author
   */
  @Override
  public void removeByauthor (String author) {
    for (Book book : findByauthor(author, QueryUtil.ALL_POS,
        QueryUtil.ALL_POS, null)) {
      remove(book);
    }
  }

  /**
   * Returns the number of books where author = &#63;.
   *
   * @param author the author
   * @return the number of matching books
   */
  @Override
  public int countByauthor (String author) {
    author = Objects.toString(author, "");

    FinderPath finderPath = _finderPathCountByauthor;

    Object[] finderArgs = new Object[]{author};

    Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

    if (count == null) {
      StringBundler query = new StringBundler(2);

      query.append(_SQL_COUNT_BOOK_WHERE);

      boolean bindAuthor = false;

      if (author.isEmpty()) {
        query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
      } else {
        bindAuthor = true;

        query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAuthor) {
          qPos.add(author);
        }

        count = (Long) q.uniqueResult();

        finderCache.putResult(finderPath, finderArgs, count);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return count.intValue();
  }

  private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_2 = "book.author = ?";
  private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_3 = "(book.author IS NULL OR book.author = '')";
  private FinderPath _finderPathWithPaginationFindByauthorPublishedOnDate;
  private FinderPath _finderPathWithoutPaginationFindByauthorPublishedOnDate;
  private FinderPath _finderPathCountByauthorPublishedOnDate;

  /**
   * Returns all the books where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @return the matching books
   */
  @Override
  public List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate) {
    return findByauthorPublishedOnDate(author, publishDate,
        QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
  }

  /**
   * Returns a range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  @Override
  public List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end) {
    return findByauthorPublishedOnDate(author, publishDate, start, end, null);
  }

  /**
   * Returns an ordered range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return findByauthorPublishedOnDate(author, publishDate, start, end,
        orderByComparator, true);
  }

  /**
   * Returns an ordered range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  @Override
  public List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    author = Objects.toString(author, "");

    boolean pagination = true;
    FinderPath finderPath = null;
    Object[] finderArgs = null;

    if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
        (orderByComparator == null)) {
      pagination = false;
      finderPath = _finderPathWithoutPaginationFindByauthorPublishedOnDate;
      finderArgs = new Object[]{author, _getTime(publishDate)};
    } else {
      finderPath = _finderPathWithPaginationFindByauthorPublishedOnDate;
      finderArgs = new Object[]{
          author, _getTime(publishDate),

          start, end, orderByComparator
      };
    }

    List<Book> list = null;

    if (retrieveFromCache) {
      list = (List<Book>) finderCache.getResult(finderPath, finderArgs,
          this);

      if ((list != null) && !list.isEmpty()) {
        for (Book book : list) {
          if (!author.equals(book.getAuthor()) ||
              !Objects.equals(publishDate, book.getPublishDate())) {
            list = null;

            break;
          }
        }
      }
    }

    if (list == null) {
      StringBundler query = null;

      if (orderByComparator != null) {
        query = new StringBundler(4 +
            (orderByComparator.getOrderByFields().length * 2));
      } else {
        query = new StringBundler(4);
      }

      query.append(_SQL_SELECT_BOOK_WHERE);

      boolean bindAuthor = false;

      if (author.isEmpty()) {
        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_3);
      } else {
        bindAuthor = true;

        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_2);
      }

      boolean bindPublishDate = false;

      if (publishDate == null) {
        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_1);
      } else {
        bindPublishDate = true;

        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_2);
      }

      if (orderByComparator != null) {
        appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
            orderByComparator);
      } else if (pagination) {
        query.append(BookModelImpl.ORDER_BY_JPQL);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAuthor) {
          qPos.add(author);
        }

        if (bindPublishDate) {
          qPos.add(new Timestamp(publishDate.getTime()));
        }

        if (!pagination) {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end, false);

          Collections.sort(list);

          list = Collections.unmodifiableList(list);
        } else {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end);
        }

        cacheResult(list);

        finderCache.putResult(finderPath, finderArgs, list);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return list;
  }

  /**
   * Returns the first book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findByauthorPublishedOnDate_First (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException {
    Book book = fetchByauthorPublishedOnDate_First(author, publishDate,
        orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(6);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("author=");
    msg.append(author);

    msg.append(", publishDate=");
    msg.append(publishDate);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the first book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchByauthorPublishedOnDate_First (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator) {
    List<Book> list = findByauthorPublishedOnDate(author, publishDate, 0,
        1, orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the last book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  @Override
  public Book findByauthorPublishedOnDate_Last (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException {
    Book book = fetchByauthorPublishedOnDate_Last(author, publishDate,
        orderByComparator);

    if (book != null) {
      return book;
    }

    StringBundler msg = new StringBundler(6);

    msg.append(_NO_SUCH_ENTITY_WITH_KEY);

    msg.append("author=");
    msg.append(author);

    msg.append(", publishDate=");
    msg.append(publishDate);

    msg.append("}");

    throw new NoSuchBookException(msg.toString());
  }

  /**
   * Returns the last book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  @Override
  public Book fetchByauthorPublishedOnDate_Last (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator) {
    int count = countByauthorPublishedOnDate(author, publishDate);

    if (count == 0) {
      return null;
    }

    List<Book> list = findByauthorPublishedOnDate(author, publishDate,
        count - 1, count, orderByComparator);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }

  /**
   * Returns the books before and after the current book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book[] findByauthorPublishedOnDate_PrevAndNext (long bookId,
      String author, Date publishDate,
      OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
    author = Objects.toString(author, "");

    Book book = findByPrimaryKey(bookId);

    Session session = null;

    try {
      session = openSession();

      Book[] array = new BookImpl[3];

      array[0] = getByauthorPublishedOnDate_PrevAndNext(session, book,
          author, publishDate, orderByComparator, true);

      array[1] = book;

      array[2] = getByauthorPublishedOnDate_PrevAndNext(session, book,
          author, publishDate, orderByComparator, false);

      return array;
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }
  }

  protected Book getByauthorPublishedOnDate_PrevAndNext (Session session,
      Book book, String author, Date publishDate,
      OrderByComparator<Book> orderByComparator, boolean previous) {
    StringBundler query = null;

    if (orderByComparator != null) {
      query = new StringBundler(5 +
          (orderByComparator.getOrderByConditionFields().length * 3) +
          (orderByComparator.getOrderByFields().length * 3));
    } else {
      query = new StringBundler(4);
    }

    query.append(_SQL_SELECT_BOOK_WHERE);

    boolean bindAuthor = false;

    if (author.isEmpty()) {
      query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_3);
    } else {
      bindAuthor = true;

      query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_2);
    }

    boolean bindPublishDate = false;

    if (publishDate == null) {
      query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_1);
    } else {
      bindPublishDate = true;

      query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_2);
    }

    if (orderByComparator != null) {
      String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

      if (orderByConditionFields.length > 0) {
        query.append(WHERE_AND);
      }

      for (int i = 0; i < orderByConditionFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByConditionFields[i]);

        if ((i + 1) < orderByConditionFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN_HAS_NEXT);
          } else {
            query.append(WHERE_LESSER_THAN_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(WHERE_GREATER_THAN);
          } else {
            query.append(WHERE_LESSER_THAN);
          }
        }
      }

      query.append(ORDER_BY_CLAUSE);

      String[] orderByFields = orderByComparator.getOrderByFields();

      for (int i = 0; i < orderByFields.length; i++) {
        query.append(_ORDER_BY_ENTITY_ALIAS);
        query.append(orderByFields[i]);

        if ((i + 1) < orderByFields.length) {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC_HAS_NEXT);
          } else {
            query.append(ORDER_BY_DESC_HAS_NEXT);
          }
        } else {
          if (orderByComparator.isAscending() ^ previous) {
            query.append(ORDER_BY_ASC);
          } else {
            query.append(ORDER_BY_DESC);
          }
        }
      }
    } else {
      query.append(BookModelImpl.ORDER_BY_JPQL);
    }

    String sql = query.toString();

    Query q = session.createQuery(sql);

    q.setFirstResult(0);
    q.setMaxResults(2);

    QueryPos qPos = QueryPos.getInstance(q);

    if (bindAuthor) {
      qPos.add(author);
    }

    if (bindPublishDate) {
      qPos.add(new Timestamp(publishDate.getTime()));
    }

    if (orderByComparator != null) {
      for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(
          book)) {
        qPos.add(orderByConditionValue);
      }
    }

    List<Book> list = q.list();

    if (list.size() == 2) {
      return list.get(1);
    } else {
      return null;
    }
  }

  /**
   * Removes all the books where author = &#63; and publishDate = &#63; from the database.
   *
   * @param author the author
   * @param publishDate the publish date
   */
  @Override
  public void removeByauthorPublishedOnDate (String author, Date publishDate) {
    for (Book book : findByauthorPublishedOnDate(author, publishDate,
        QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
      remove(book);
    }
  }

  /**
   * Returns the number of books where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @return the number of matching books
   */
  @Override
  public int countByauthorPublishedOnDate (String author, Date publishDate) {
    author = Objects.toString(author, "");

    FinderPath finderPath = _finderPathCountByauthorPublishedOnDate;

    Object[] finderArgs = new Object[]{author, _getTime(publishDate)};

    Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

    if (count == null) {
      StringBundler query = new StringBundler(3);

      query.append(_SQL_COUNT_BOOK_WHERE);

      boolean bindAuthor = false;

      if (author.isEmpty()) {
        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_3);
      } else {
        bindAuthor = true;

        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_2);
      }

      boolean bindPublishDate = false;

      if (publishDate == null) {
        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_1);
      } else {
        bindPublishDate = true;

        query.append(_FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_2);
      }

      String sql = query.toString();

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAuthor) {
          qPos.add(author);
        }

        if (bindPublishDate) {
          qPos.add(new Timestamp(publishDate.getTime()));
        }

        count = (Long) q.uniqueResult();

        finderCache.putResult(finderPath, finderArgs, count);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return count.intValue();
  }

  private static final String _FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_2 = "book.author = ? AND ";
  private static final String _FINDER_COLUMN_AUTHORPUBLISHEDONDATE_AUTHOR_3 = "(book.author IS NULL OR book.author = '') AND ";
  private static final String _FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_1 =
      "book.publishDate IS NULL";
  private static final String _FINDER_COLUMN_AUTHORPUBLISHEDONDATE_PUBLISHDATE_2 =
      "book.publishDate = ?";

  public BookPersistenceImpl () {
    setModelClass(Book.class);

    try {
      Field field = BasePersistenceImpl.class.getDeclaredField(
          "_dbColumnNames");

      field.setAccessible(true);

      Map<String, String> dbColumnNames = new HashMap<String, String>();

      dbColumnNames.put("uuid", "uuid_");

      field.set(this, dbColumnNames);
    } catch (Exception e) {
      if (_log.isDebugEnabled()) {
        _log.debug(e, e);
      }
    }
  }

  /**
   * Caches the book in the entity cache if it is enabled.
   *
   * @param book the book
   */
  @Override
  public void cacheResult (Book book) {
    entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookImpl.class, book.getPrimaryKey(), book);

    book.resetOriginalValues();
  }

  /**
   * Caches the books in the entity cache if it is enabled.
   *
   * @param books the books
   */
  @Override
  public void cacheResult (List<Book> books) {
    for (Book book : books) {
      if (entityCache.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
          BookImpl.class, book.getPrimaryKey()) == null) {
        cacheResult(book);
      } else {
        book.resetOriginalValues();
      }
    }
  }

  /**
   * Clears the cache for all books.
   *
   * <p>
   * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
   * </p>
   */
  @Override
  public void clearCache () {
    entityCache.clearCache(BookImpl.class);

    finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
  }

  /**
   * Clears the cache for the book.
   *
   * <p>
   * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
   * </p>
   */
  @Override
  public void clearCache (Book book) {
    entityCache.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookImpl.class, book.getPrimaryKey());

    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
  }

  @Override
  public void clearCache (List<Book> books) {
    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

    for (Book book : books) {
      entityCache.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
          BookImpl.class, book.getPrimaryKey());
    }
  }

  /**
   * Creates a new book with the primary key. Does not add the book to the database.
   *
   * @param bookId the primary key for the new book
   * @return the new book
   */
  @Override
  public Book create (long bookId) {
    Book book = new BookImpl();

    book.setNew(true);
    book.setPrimaryKey(bookId);

    String uuid = PortalUUIDUtil.generate();

    book.setUuid(uuid);

    return book;
  }

  /**
   * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
   *
   * @param bookId the primary key of the book
   * @return the book that was removed
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book remove (long bookId) throws NoSuchBookException {
    return remove((Serializable) bookId);
  }

  /**
   * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
   *
   * @param primaryKey the primary key of the book
   * @return the book that was removed
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book remove (Serializable primaryKey) throws NoSuchBookException {
    Session session = null;

    try {
      session = openSession();

      Book book = (Book) session.get(BookImpl.class, primaryKey);

      if (book == null) {
        if (_log.isDebugEnabled()) {
          _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
        }

        throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
            primaryKey);
      }

      return remove(book);
    } catch (NoSuchBookException nsee) {
      throw nsee;
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }
  }

  @Override
  protected Book removeImpl (Book book) {
    Session session = null;

    try {
      session = openSession();

      if (!session.contains(book)) {
        book = (Book) session.get(BookImpl.class, book.getPrimaryKeyObj());
      }

      if (book != null) {
        session.delete(book);
      }
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }

    if (book != null) {
      clearCache(book);
    }

    return book;
  }

  @Override
  public Book updateImpl (Book book) {
    boolean isNew = book.isNew();

    if (!(book instanceof BookModelImpl)) {
      InvocationHandler invocationHandler = null;

      if (ProxyUtil.isProxyClass(book.getClass())) {
        invocationHandler = ProxyUtil.getInvocationHandler(book);

        throw new IllegalArgumentException(
            "Implement ModelWrapper in book proxy " +
                invocationHandler.getClass());
      }

      throw new IllegalArgumentException(
          "Implement ModelWrapper in custom Book implementation " +
              book.getClass());
    }

    BookModelImpl bookModelImpl = (BookModelImpl) book;

    if (Validator.isNull(book.getUuid())) {
      String uuid = PortalUUIDUtil.generate();

      book.setUuid(uuid);
    }

    Session session = null;

    try {
      session = openSession();

      if (book.isNew()) {
        session.save(book);

        book.setNew(false);
      } else {
        book = (Book) session.merge(book);
      }
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }

    finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

    if (!BookModelImpl.COLUMN_BITMASK_ENABLED) {
      finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    } else if (isNew) {
      Object[] args = new Object[]{bookModelImpl.getUuid()};

      finderCache.removeResult(_finderPathCountByUuid, args);
      finderCache.removeResult(_finderPathWithoutPaginationFindByUuid,
          args);

      args = new Object[]{bookModelImpl.getPublishDate()};

      finderCache.removeResult(_finderPathCountBypublishDate, args);
      finderCache.removeResult(_finderPathWithoutPaginationFindBypublishDate,
          args);

      args = new Object[]{bookModelImpl.getAuthor()};

      finderCache.removeResult(_finderPathCountByauthor, args);
      finderCache.removeResult(_finderPathWithoutPaginationFindByauthor,
          args);

      args = new Object[]{
          bookModelImpl.getAuthor(), bookModelImpl.getPublishDate()
      };

      finderCache.removeResult(_finderPathCountByauthorPublishedOnDate,
          args);
      finderCache.removeResult(_finderPathWithoutPaginationFindByauthorPublishedOnDate,
          args);

      finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
      finderCache.removeResult(_finderPathWithoutPaginationFindAll,
          FINDER_ARGS_EMPTY);
    } else {
      if ((bookModelImpl.getColumnBitmask() &
          _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) != 0) {
        Object[] args = new Object[]{bookModelImpl.getOriginalUuid()};

        finderCache.removeResult(_finderPathCountByUuid, args);
        finderCache.removeResult(_finderPathWithoutPaginationFindByUuid,
            args);

        args = new Object[]{bookModelImpl.getUuid()};

        finderCache.removeResult(_finderPathCountByUuid, args);
        finderCache.removeResult(_finderPathWithoutPaginationFindByUuid,
            args);
      }

      if ((bookModelImpl.getColumnBitmask() &
          _finderPathWithoutPaginationFindBypublishDate.getColumnBitmask()) != 0) {
        Object[] args = new Object[]{
            bookModelImpl.getOriginalPublishDate()
        };

        finderCache.removeResult(_finderPathCountBypublishDate, args);
        finderCache.removeResult(_finderPathWithoutPaginationFindBypublishDate,
            args);

        args = new Object[]{bookModelImpl.getPublishDate()};

        finderCache.removeResult(_finderPathCountBypublishDate, args);
        finderCache.removeResult(_finderPathWithoutPaginationFindBypublishDate,
            args);
      }

      if ((bookModelImpl.getColumnBitmask() &
          _finderPathWithoutPaginationFindByauthor.getColumnBitmask()) != 0) {
        Object[] args = new Object[]{bookModelImpl.getOriginalAuthor()};

        finderCache.removeResult(_finderPathCountByauthor, args);
        finderCache.removeResult(_finderPathWithoutPaginationFindByauthor,
            args);

        args = new Object[]{bookModelImpl.getAuthor()};

        finderCache.removeResult(_finderPathCountByauthor, args);
        finderCache.removeResult(_finderPathWithoutPaginationFindByauthor,
            args);
      }

      if ((bookModelImpl.getColumnBitmask() &
          _finderPathWithoutPaginationFindByauthorPublishedOnDate.getColumnBitmask()) != 0) {
        Object[] args = new Object[]{
            bookModelImpl.getOriginalAuthor(),
            bookModelImpl.getOriginalPublishDate()
        };

        finderCache.removeResult(_finderPathCountByauthorPublishedOnDate,
            args);
        finderCache.removeResult(_finderPathWithoutPaginationFindByauthorPublishedOnDate,
            args);

        args = new Object[]{
            bookModelImpl.getAuthor(),
            bookModelImpl.getPublishDate()
        };

        finderCache.removeResult(_finderPathCountByauthorPublishedOnDate,
            args);
        finderCache.removeResult(_finderPathWithoutPaginationFindByauthorPublishedOnDate,
            args);
      }
    }

    entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookImpl.class, book.getPrimaryKey(), book, false);

    book.resetOriginalValues();

    return book;
  }

  /**
   * Returns the book with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
   *
   * @param primaryKey the primary key of the book
   * @return the book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book findByPrimaryKey (Serializable primaryKey)
      throws NoSuchBookException {
    Book book = fetchByPrimaryKey(primaryKey);

    if (book == null) {
      if (_log.isDebugEnabled()) {
        _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
      }

      throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
          primaryKey);
    }

    return book;
  }

  /**
   * Returns the book with the primary key or throws a {@link NoSuchBookException} if it could not be found.
   *
   * @param bookId the primary key of the book
   * @return the book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  @Override
  public Book findByPrimaryKey (long bookId) throws NoSuchBookException {
    return findByPrimaryKey((Serializable) bookId);
  }

  /**
   * Returns the book with the primary key or returns <code>null</code> if it could not be found.
   *
   * @param primaryKey the primary key of the book
   * @return the book, or <code>null</code> if a book with the primary key could not be found
   */
  @Override
  public Book fetchByPrimaryKey (Serializable primaryKey) {
    Serializable serializable = entityCache.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookImpl.class, primaryKey);

    if (serializable == nullModel) {
      return null;
    }

    Book book = (Book) serializable;

    if (book == null) {
      Session session = null;

      try {
        session = openSession();

        book = (Book) session.get(BookImpl.class, primaryKey);

        if (book != null) {
          cacheResult(book);
        } else {
          entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
              BookImpl.class, primaryKey, nullModel);
        }
      } catch (Exception e) {
        entityCache.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookImpl.class, primaryKey);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return book;
  }

  /**
   * Returns the book with the primary key or returns <code>null</code> if it could not be found.
   *
   * @param bookId the primary key of the book
   * @return the book, or <code>null</code> if a book with the primary key could not be found
   */
  @Override
  public Book fetchByPrimaryKey (long bookId) {
    return fetchByPrimaryKey((Serializable) bookId);
  }

  @Override
  public Map<Serializable, Book> fetchByPrimaryKeys (
      Set<Serializable> primaryKeys) {
    if (primaryKeys.isEmpty()) {
      return Collections.emptyMap();
    }

    Map<Serializable, Book> map = new HashMap<Serializable, Book>();

    if (primaryKeys.size() == 1) {
      Iterator<Serializable> iterator = primaryKeys.iterator();

      Serializable primaryKey = iterator.next();

      Book book = fetchByPrimaryKey(primaryKey);

      if (book != null) {
        map.put(primaryKey, book);
      }

      return map;
    }

    Set<Serializable> uncachedPrimaryKeys = null;

    for (Serializable primaryKey : primaryKeys) {
      Serializable serializable = entityCache.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
          BookImpl.class, primaryKey);

      if (serializable != nullModel) {
        if (serializable == null) {
          if (uncachedPrimaryKeys == null) {
            uncachedPrimaryKeys = new HashSet<Serializable>();
          }

          uncachedPrimaryKeys.add(primaryKey);
        } else {
          map.put(primaryKey, (Book) serializable);
        }
      }
    }

    if (uncachedPrimaryKeys == null) {
      return map;
    }

    StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
        1);

    query.append(_SQL_SELECT_BOOK_WHERE_PKS_IN);

    for (Serializable primaryKey : uncachedPrimaryKeys) {
      query.append((long) primaryKey);

      query.append(",");
    }

    query.setIndex(query.index() - 1);

    query.append(")");

    String sql = query.toString();

    Session session = null;

    try {
      session = openSession();

      Query q = session.createQuery(sql);

      for (Book book : (List<Book>) q.list()) {
        map.put(book.getPrimaryKeyObj(), book);

        cacheResult(book);

        uncachedPrimaryKeys.remove(book.getPrimaryKeyObj());
      }

      for (Serializable primaryKey : uncachedPrimaryKeys) {
        entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookImpl.class, primaryKey, nullModel);
      }
    } catch (Exception e) {
      throw processException(e);
    } finally {
      closeSession(session);
    }

    return map;
  }

  /**
   * Returns all the books.
   *
   * @return the books
   */
  @Override
  public List<Book> findAll () {
    return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
  }

  /**
   * Returns a range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of books
   */
  @Override
  public List<Book> findAll (int start, int end) {
    return findAll(start, end, null);
  }

  /**
   * Returns an ordered range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of books
   */
  @Override
  public List<Book> findAll (int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return findAll(start, end, orderByComparator, true);
  }

  /**
   * Returns an ordered range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of books
   */
  @Override
  public List<Book> findAll (int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    boolean pagination = true;
    FinderPath finderPath = null;
    Object[] finderArgs = null;

    if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
        (orderByComparator == null)) {
      pagination = false;
      finderPath = _finderPathWithoutPaginationFindAll;
      finderArgs = FINDER_ARGS_EMPTY;
    } else {
      finderPath = _finderPathWithPaginationFindAll;
      finderArgs = new Object[]{start, end, orderByComparator};
    }

    List<Book> list = null;

    if (retrieveFromCache) {
      list = (List<Book>) finderCache.getResult(finderPath, finderArgs,
          this);
    }

    if (list == null) {
      StringBundler query = null;
      String sql = null;

      if (orderByComparator != null) {
        query = new StringBundler(2 +
            (orderByComparator.getOrderByFields().length * 2));

        query.append(_SQL_SELECT_BOOK);

        appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
            orderByComparator);

        sql = query.toString();
      } else {
        sql = _SQL_SELECT_BOOK;

        if (pagination) {
          sql = sql.concat(BookModelImpl.ORDER_BY_JPQL);
        }
      }

      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(sql);

        if (!pagination) {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end, false);

          Collections.sort(list);

          list = Collections.unmodifiableList(list);
        } else {
          list = (List<Book>) QueryUtil.list(q, getDialect(), start,
              end);
        }

        cacheResult(list);

        finderCache.putResult(finderPath, finderArgs, list);
      } catch (Exception e) {
        finderCache.removeResult(finderPath, finderArgs);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return list;
  }

  /**
   * Removes all the books from the database.
   *
   */
  @Override
  public void removeAll () {
    for (Book book : findAll()) {
      remove(book);
    }
  }

  /**
   * Returns the number of books.
   *
   * @return the number of books
   */
  @Override
  public int countAll () {
    Long count = (Long) finderCache.getResult(_finderPathCountAll,
        FINDER_ARGS_EMPTY, this);

    if (count == null) {
      Session session = null;

      try {
        session = openSession();

        Query q = session.createQuery(_SQL_COUNT_BOOK);

        count = (Long) q.uniqueResult();

        finderCache.putResult(_finderPathCountAll, FINDER_ARGS_EMPTY,
            count);
      } catch (Exception e) {
        finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);

        throw processException(e);
      } finally {
        closeSession(session);
      }
    }

    return count.intValue();
  }

  @Override
  public Set<String> getBadColumnNames () {
    return _badColumnNames;
  }

  @Override
  protected Map<String, Integer> getTableColumnsMap () {
    return BookModelImpl.TABLE_COLUMNS_MAP;
  }

  /**
   * Initializes the book persistence.
   */
  public void afterPropertiesSet () {
    _finderPathWithPaginationFindAll = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

    _finderPathWithoutPaginationFindAll = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
        new String[0]);

    _finderPathCountAll = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
        new String[0]);

    _finderPathWithPaginationFindByUuid = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
        new String[]{
            String.class.getName(),

            Integer.class.getName(), Integer.class.getName(),
            OrderByComparator.class.getName()
        });

    _finderPathWithoutPaginationFindByUuid = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
        new String[]{String.class.getName()},
        BookModelImpl.UUID_COLUMN_BITMASK);

    _finderPathCountByUuid = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
        new String[]{String.class.getName()});

    _finderPathWithPaginationFindBypublishDate = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypublishDate",
        new String[]{
            Date.class.getName(),

            Integer.class.getName(), Integer.class.getName(),
            OrderByComparator.class.getName()
        });

    _finderPathWithoutPaginationFindBypublishDate = new FinderPath(
        BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypublishDate",
        new String[]{Date.class.getName()},
        BookModelImpl.PUBLISHDATE_COLUMN_BITMASK);

    _finderPathCountBypublishDate = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
        "countBypublishDate", new String[]{Date.class.getName()});

    _finderPathWithPaginationFindByauthor = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByauthor",
        new String[]{
            String.class.getName(),

            Integer.class.getName(), Integer.class.getName(),
            OrderByComparator.class.getName()
        });

    _finderPathWithoutPaginationFindByauthor = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByauthor",
        new String[]{String.class.getName()},
        BookModelImpl.AUTHOR_COLUMN_BITMASK);

    _finderPathCountByauthor = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByauthor",
        new String[]{String.class.getName()});

    _finderPathWithPaginationFindByauthorPublishedOnDate = new FinderPath(
        BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
        "findByauthorPublishedOnDate",
        new String[]{
            String.class.getName(), Date.class.getName(),

            Integer.class.getName(), Integer.class.getName(),
            OrderByComparator.class.getName()
        });

    _finderPathWithoutPaginationFindByauthorPublishedOnDate = new FinderPath(
        BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
        "findByauthorPublishedOnDate",
        new String[]{String.class.getName(), Date.class.getName()},
        BookModelImpl.AUTHOR_COLUMN_BITMASK |
            BookModelImpl.PUBLISHDATE_COLUMN_BITMASK);

    _finderPathCountByauthorPublishedOnDate = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
        BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
        FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
        "countByauthorPublishedOnDate",
        new String[]{String.class.getName(), Date.class.getName()});
  }

  public void destroy () {
    entityCache.removeCache(BookImpl.class.getName());
    finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
    finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
    finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
  }

  @ServiceReference(type = EntityCache.class)
  protected EntityCache entityCache;
  @ServiceReference(type = FinderCache.class)
  protected FinderCache finderCache;

  private Long _getTime (Date date) {
    if (date == null) {
      return null;
    }

    return date.getTime();
  }

  private static final String _SQL_SELECT_BOOK = "SELECT book FROM Book book";
  private static final String _SQL_SELECT_BOOK_WHERE_PKS_IN = "SELECT book FROM Book book WHERE bookId IN (";
  private static final String _SQL_SELECT_BOOK_WHERE = "SELECT book FROM Book book WHERE ";
  private static final String _SQL_COUNT_BOOK = "SELECT COUNT(book) FROM Book book";
  private static final String _SQL_COUNT_BOOK_WHERE = "SELECT COUNT(book) FROM Book book WHERE ";
  private static final String _ORDER_BY_ENTITY_ALIAS = "book.";
  private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Book exists with the primary key ";
  private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Book exists with the key {";
  private static final Log _log = LogFactoryUtil.getLog(BookPersistenceImpl.class);
  private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[]{
      "uuid"
  });
}