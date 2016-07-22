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

package org.opencps.notificationmgt.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.notificationmgt.NoSuchNotificationConfigException;
import org.opencps.notificationmgt.model.NotificationConfig;
import org.opencps.notificationmgt.model.impl.NotificationConfigImpl;
import org.opencps.notificationmgt.model.impl.NotificationConfigModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the notification config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungdk
 * @see NotificationConfigPersistence
 * @see NotificationConfigUtil
 * @generated
 */
public class NotificationConfigPersistenceImpl extends BasePersistenceImpl<NotificationConfig>
	implements NotificationConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationConfigUtil} to access the notification config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
			NotificationConfigModelImpl.FINDER_CACHE_ENABLED,
			NotificationConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
			NotificationConfigModelImpl.FINDER_CACHE_ENABLED,
			NotificationConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
			NotificationConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NotificationConfigPersistenceImpl() {
		setModelClass(NotificationConfig.class);
	}

	/**
	 * Caches the notification config in the entity cache if it is enabled.
	 *
	 * @param notificationConfig the notification config
	 */
	@Override
	public void cacheResult(NotificationConfig notificationConfig) {
		EntityCacheUtil.putResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
			NotificationConfigImpl.class, notificationConfig.getPrimaryKey(),
			notificationConfig);

		notificationConfig.resetOriginalValues();
	}

	/**
	 * Caches the notification configs in the entity cache if it is enabled.
	 *
	 * @param notificationConfigs the notification configs
	 */
	@Override
	public void cacheResult(List<NotificationConfig> notificationConfigs) {
		for (NotificationConfig notificationConfig : notificationConfigs) {
			if (EntityCacheUtil.getResult(
						NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
						NotificationConfigImpl.class,
						notificationConfig.getPrimaryKey()) == null) {
				cacheResult(notificationConfig);
			}
			else {
				notificationConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notification configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotificationConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotificationConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationConfig notificationConfig) {
		EntityCacheUtil.removeResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
			NotificationConfigImpl.class, notificationConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NotificationConfig> notificationConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificationConfig notificationConfig : notificationConfigs) {
			EntityCacheUtil.removeResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
				NotificationConfigImpl.class, notificationConfig.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notification config with the primary key. Does not add the notification config to the database.
	 *
	 * @param notificationConfigId the primary key for the new notification config
	 * @return the new notification config
	 */
	@Override
	public NotificationConfig create(long notificationConfigId) {
		NotificationConfig notificationConfig = new NotificationConfigImpl();

		notificationConfig.setNew(true);
		notificationConfig.setPrimaryKey(notificationConfigId);

		return notificationConfig;
	}

	/**
	 * Removes the notification config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationConfigId the primary key of the notification config
	 * @return the notification config that was removed
	 * @throws org.opencps.notificationmgt.NoSuchNotificationConfigException if a notification config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationConfig remove(long notificationConfigId)
		throws NoSuchNotificationConfigException, SystemException {
		return remove((Serializable)notificationConfigId);
	}

	/**
	 * Removes the notification config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification config
	 * @return the notification config that was removed
	 * @throws org.opencps.notificationmgt.NoSuchNotificationConfigException if a notification config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationConfig remove(Serializable primaryKey)
		throws NoSuchNotificationConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NotificationConfig notificationConfig = (NotificationConfig)session.get(NotificationConfigImpl.class,
					primaryKey);

			if (notificationConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificationConfig);
		}
		catch (NoSuchNotificationConfigException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected NotificationConfig removeImpl(
		NotificationConfig notificationConfig) throws SystemException {
		notificationConfig = toUnwrappedModel(notificationConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificationConfig)) {
				notificationConfig = (NotificationConfig)session.get(NotificationConfigImpl.class,
						notificationConfig.getPrimaryKeyObj());
			}

			if (notificationConfig != null) {
				session.delete(notificationConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificationConfig != null) {
			clearCache(notificationConfig);
		}

		return notificationConfig;
	}

	@Override
	public NotificationConfig updateImpl(
		org.opencps.notificationmgt.model.NotificationConfig notificationConfig)
		throws SystemException {
		notificationConfig = toUnwrappedModel(notificationConfig);

		boolean isNew = notificationConfig.isNew();

		Session session = null;

		try {
			session = openSession();

			if (notificationConfig.isNew()) {
				session.save(notificationConfig);

				notificationConfig.setNew(false);
			}
			else {
				session.merge(notificationConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
			NotificationConfigImpl.class, notificationConfig.getPrimaryKey(),
			notificationConfig);

		return notificationConfig;
	}

	protected NotificationConfig toUnwrappedModel(
		NotificationConfig notificationConfig) {
		if (notificationConfig instanceof NotificationConfigImpl) {
			return notificationConfig;
		}

		NotificationConfigImpl notificationConfigImpl = new NotificationConfigImpl();

		notificationConfigImpl.setNew(notificationConfig.isNew());
		notificationConfigImpl.setPrimaryKey(notificationConfig.getPrimaryKey());

		notificationConfigImpl.setNotificationConfigId(notificationConfig.getNotificationConfigId());
		notificationConfigImpl.setCompanyId(notificationConfig.getCompanyId());
		notificationConfigImpl.setGroupId(notificationConfig.getGroupId());
		notificationConfigImpl.setUserId(notificationConfig.getUserId());
		notificationConfigImpl.setCreateDate(notificationConfig.getCreateDate());
		notificationConfigImpl.setModifiedDate(notificationConfig.getModifiedDate());
		notificationConfigImpl.setEventPattern(notificationConfig.getEventPattern());
		notificationConfigImpl.setNotificationURL(notificationConfig.getNotificationURL());

		return notificationConfigImpl;
	}

	/**
	 * Returns the notification config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification config
	 * @return the notification config
	 * @throws org.opencps.notificationmgt.NoSuchNotificationConfigException if a notification config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationConfigException, SystemException {
		NotificationConfig notificationConfig = fetchByPrimaryKey(primaryKey);

		if (notificationConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificationConfig;
	}

	/**
	 * Returns the notification config with the primary key or throws a {@link org.opencps.notificationmgt.NoSuchNotificationConfigException} if it could not be found.
	 *
	 * @param notificationConfigId the primary key of the notification config
	 * @return the notification config
	 * @throws org.opencps.notificationmgt.NoSuchNotificationConfigException if a notification config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationConfig findByPrimaryKey(long notificationConfigId)
		throws NoSuchNotificationConfigException, SystemException {
		return findByPrimaryKey((Serializable)notificationConfigId);
	}

	/**
	 * Returns the notification config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification config
	 * @return the notification config, or <code>null</code> if a notification config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NotificationConfig notificationConfig = (NotificationConfig)EntityCacheUtil.getResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
				NotificationConfigImpl.class, primaryKey);

		if (notificationConfig == _nullNotificationConfig) {
			return null;
		}

		if (notificationConfig == null) {
			Session session = null;

			try {
				session = openSession();

				notificationConfig = (NotificationConfig)session.get(NotificationConfigImpl.class,
						primaryKey);

				if (notificationConfig != null) {
					cacheResult(notificationConfig);
				}
				else {
					EntityCacheUtil.putResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
						NotificationConfigImpl.class, primaryKey,
						_nullNotificationConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NotificationConfigModelImpl.ENTITY_CACHE_ENABLED,
					NotificationConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificationConfig;
	}

	/**
	 * Returns the notification config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationConfigId the primary key of the notification config
	 * @return the notification config, or <code>null</code> if a notification config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationConfig fetchByPrimaryKey(long notificationConfigId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificationConfigId);
	}

	/**
	 * Returns all the notification configs.
	 *
	 * @return the notification configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificationConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.notificationmgt.model.impl.NotificationConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification configs
	 * @param end the upper bound of the range of notification configs (not inclusive)
	 * @return the range of notification configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificationConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.notificationmgt.model.impl.NotificationConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification configs
	 * @param end the upper bound of the range of notification configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notification configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificationConfig> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<NotificationConfig> list = (List<NotificationConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTIFICATIONCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONCONFIG;

				if (pagination) {
					sql = sql.concat(NotificationConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificationConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificationConfig>(list);
				}
				else {
					list = (List<NotificationConfig>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notification configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NotificationConfig notificationConfig : findAll()) {
			remove(notificationConfig);
		}
	}

	/**
	 * Returns the number of notification configs.
	 *
	 * @return the number of notification configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATIONCONFIG);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the notification config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.notificationmgt.model.NotificationConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NotificationConfig>> listenersList = new ArrayList<ModelListener<NotificationConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NotificationConfig>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(NotificationConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTIFICATIONCONFIG = "SELECT notificationConfig FROM NotificationConfig notificationConfig";
	private static final String _SQL_COUNT_NOTIFICATIONCONFIG = "SELECT COUNT(notificationConfig) FROM NotificationConfig notificationConfig";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificationConfig exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotificationConfigPersistenceImpl.class);
	private static NotificationConfig _nullNotificationConfig = new NotificationConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NotificationConfig> toCacheModel() {
				return _nullNotificationConfigCacheModel;
			}
		};

	private static CacheModel<NotificationConfig> _nullNotificationConfigCacheModel =
		new CacheModel<NotificationConfig>() {
			@Override
			public NotificationConfig toEntityModel() {
				return _nullNotificationConfig;
			}
		};
}