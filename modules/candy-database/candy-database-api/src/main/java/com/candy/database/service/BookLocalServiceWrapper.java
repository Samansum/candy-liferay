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

package com.candy.database.service;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalService
 * @generated
 */
@ProviderType
public class BookLocalServiceWrapper implements BookLocalService,
    ServiceWrapper<BookLocalService> {

  public BookLocalServiceWrapper (BookLocalService bookLocalService) {
    _bookLocalService = bookLocalService;
  }

  /**
   * Adds the book to the database. Also notifies the appropriate model listeners.
   *
   * @param book the book
   * @return the book that was added
   */
  @Override
  public com.candy.database.model.Book addBook (
      com.candy.database.model.Book book) {
    return _bookLocalService.addBook(book);
  }

  /**
   * Creates a new book with the primary key. Does not add the book to the database.
   *
   * @param bookId the primary key for the new book
   * @return the new book
   */
  @Override
  public com.candy.database.model.Book createBook (long bookId) {
    return _bookLocalService.createBook(bookId);
  }

  @Override
  public com.candy.database.model.Book createBook (String bookTitle,
      String authorName, java.util.Date publishedDate) {
    return _bookLocalService.createBook(bookTitle, authorName, publishedDate);
  }

  /**
   * Deletes the book from the database. Also notifies the appropriate model listeners.
   *
   * @param book the book
   * @return the book that was removed
   */
  @Override
  public com.candy.database.model.Book deleteBook (
      com.candy.database.model.Book book) {
    return _bookLocalService.deleteBook(book);
  }

  /**
   * Deletes the book with the primary key from the database. Also notifies the appropriate model
   * listeners.
   *
   * @param bookId the primary key of the book
   * @return the book that was removed
   * @throws PortalException if a book with the primary key could not be found
   */
  @Override
  public com.candy.database.model.Book deleteBook (long bookId)
      throws com.liferay.portal.kernel.exception.PortalException {
    return _bookLocalService.deleteBook(bookId);
  }

  /**
   * @throws PortalException
   */
  @Override
  public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel (
      com.liferay.portal.kernel.model.PersistedModel persistedModel)
      throws com.liferay.portal.kernel.exception.PortalException {
    return _bookLocalService.deletePersistedModel(persistedModel);
  }

  @Override
  public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery () {
    return _bookLocalService.dynamicQuery();
  }

  /**
   * Performs a dynamic query on the database and returns the matching rows.
   *
   * @param dynamicQuery the dynamic query
   * @return the matching rows
   */
  @Override
  public <T> java.util.List<T> dynamicQuery (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
    return _bookLocalService.dynamicQuery(dynamicQuery);
  }

  /**
   * Performs a dynamic query on the database and returns a range of the matching rows.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}
   * will return the full result set. If <code>orderByComparator</code> is specified, then the query
   * will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and
   * pagination is required (<code>start</code> and <code>end</code> are not {@link
   * com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default
   * ORDER BY logic from {@link com.candy.database.model.impl.BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param dynamicQuery the dynamic query
   * @param start        the lower bound of the range of model instances
   * @param end          the upper bound of the range of model instances (not inclusive)
   * @return the range of matching rows
   */
  @Override
  public <T> java.util.List<T> dynamicQuery (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
      int end) {
    return _bookLocalService.dynamicQuery(dynamicQuery, start, end);
  }

  /**
   * Performs a dynamic query on the database and returns an ordered range of the matching rows.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}
   * will return the full result set. If <code>orderByComparator</code> is specified, then the query
   * will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and
   * pagination is required (<code>start</code> and <code>end</code> are not {@link
   * com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default
   * ORDER BY logic from {@link com.candy.database.model.impl.BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param dynamicQuery      the dynamic query
   * @param start             the lower bound of the range of model instances
   * @param end               the upper bound of the range of model instances (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching rows
   */
  @Override
  public <T> java.util.List<T> dynamicQuery (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
      int end,
      com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
    return _bookLocalService.dynamicQuery(dynamicQuery, start, end,
        orderByComparator);
  }

  /**
   * Returns the number of rows matching the dynamic query.
   *
   * @param dynamicQuery the dynamic query
   * @return the number of rows matching the dynamic query
   */
  @Override
  public long dynamicQueryCount (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
    return _bookLocalService.dynamicQueryCount(dynamicQuery);
  }

  /**
   * Returns the number of rows matching the dynamic query.
   *
   * @param dynamicQuery the dynamic query
   * @param projection   the projection to apply to the query
   * @return the number of rows matching the dynamic query
   */
  @Override
  public long dynamicQueryCount (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
      com.liferay.portal.kernel.dao.orm.Projection projection) {
    return _bookLocalService.dynamicQueryCount(dynamicQuery, projection);
  }

  @Override
  public com.candy.database.model.Book fetchBook (long bookId) {
    return _bookLocalService.fetchBook(bookId);
  }

  @Override
  public java.util.List<com.candy.database.model.Book> findAllBooks ()
      throws com.candy.database.exception.NoSuchBookException {
    return _bookLocalService.findAllBooks();
  }

  @Override
  public java.util.List<com.candy.database.model.Book> findBookByAuthor (
      String authorName)
      throws com.candy.database.exception.NoSuchBookException {
    return _bookLocalService.findBookByAuthor(authorName);
  }

  @Override
  public java.util.List<com.candy.database.model.Book> findBookByPublishedDate (
      java.util.Date date)
      throws com.candy.database.exception.NoSuchBookException {
    return _bookLocalService.findBookByPublishedDate(date);
  }

  @Override
  public java.util.List<com.candy.database.model.Book> findByAuthorAndPublishedDate (
      String authorName, java.util.Date publishedDate)
      throws com.candy.database.exception.NoSuchBookException {
    return _bookLocalService.findByAuthorAndPublishedDate(authorName,
        publishedDate);
  }

  @Override
  public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery () {
    return _bookLocalService.getActionableDynamicQuery();
  }

  /**
   * Returns the book with the primary key.
   *
   * @param bookId the primary key of the book
   * @return the book
   * @throws PortalException if a book with the primary key could not be found
   */
  @Override
  public com.candy.database.model.Book getBook (long bookId)
      throws com.liferay.portal.kernel.exception.PortalException {
    return _bookLocalService.getBook(bookId);
  }

  /**
   * Returns a range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}
   * will return the full result set. If <code>orderByComparator</code> is specified, then the query
   * will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and
   * pagination is required (<code>start</code> and <code>end</code> are not {@link
   * com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default
   * ORDER BY logic from {@link com.candy.database.model.impl.BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end   the upper bound of the range of books (not inclusive)
   * @return the range of books
   */
  @Override
  public java.util.List<com.candy.database.model.Book> getBooks (int start,
      int end) {
    return _bookLocalService.getBooks(start, end);
  }

  /**
   * Returns the number of books.
   *
   * @return the number of books
   */
  @Override
  public int getBooksCount () {
    return _bookLocalService.getBooksCount();
  }

  @Override
  public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery () {
    return _bookLocalService.getIndexableActionableDynamicQuery();
  }

  /**
   * Returns the OSGi service identifier.
   *
   * @return the OSGi service identifier
   */
  @Override
  public String getOSGiServiceIdentifier () {
    return _bookLocalService.getOSGiServiceIdentifier();
  }

  @Override
  public com.liferay.portal.kernel.model.PersistedModel getPersistedModel (
      java.io.Serializable primaryKeyObj)
      throws com.liferay.portal.kernel.exception.PortalException {
    return _bookLocalService.getPersistedModel(primaryKeyObj);
  }

  /**
   * Updates the book in the database or adds it if it does not yet exist. Also notifies the
   * appropriate model listeners.
   *
   * @param book the book
   * @return the book that was updated
   */
  @Override
  public com.candy.database.model.Book updateBook (
      com.candy.database.model.Book book) {
    return _bookLocalService.updateBook(book);
  }

  @Override
  public com.candy.database.model.Book updateBook (long bookId,
      String bookTitle, String authorName, java.util.Date publishedDate)
      throws com.candy.database.exception.NoSuchBookException {
    return _bookLocalService.updateBook(bookId, bookTitle, authorName,
        publishedDate);
  }

  @Override
  public BookLocalService getWrappedService () {
    return _bookLocalService;
  }

  @Override
  public void setWrappedService (BookLocalService bookLocalService) {
    _bookLocalService = bookLocalService;
  }

  private BookLocalService _bookLocalService;
}