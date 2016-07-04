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

package org.duongthuy.tichhop.api.dao.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.duongthuy.tichhop.api.dao.model.MessageFunctionData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MessageFunctionData in entity cache.
 *
 * @author binhth
 * @see MessageFunctionData
 * @generated
 */
public class MessageFunctionDataCacheModel implements CacheModel<MessageFunctionData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{messagePackagesId=");
		sb.append(messagePackagesId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", messageFunction=");
		sb.append(messageFunction);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", messageFileIdData=");
		sb.append(messageFileIdData);
		sb.append(", sendDate=");
		sb.append(sendDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MessageFunctionData toEntityModel() {
		MessageFunctionDataImpl messageFunctionDataImpl = new MessageFunctionDataImpl();

		messageFunctionDataImpl.setMessagePackagesId(messagePackagesId);
		messageFunctionDataImpl.setUserId(userId);

		if (userName == null) {
			messageFunctionDataImpl.setUserName(StringPool.BLANK);
		}
		else {
			messageFunctionDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			messageFunctionDataImpl.setCreateDate(null);
		}
		else {
			messageFunctionDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			messageFunctionDataImpl.setModifiedDate(null);
		}
		else {
			messageFunctionDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (messageFunction == null) {
			messageFunctionDataImpl.setMessageFunction(StringPool.BLANK);
		}
		else {
			messageFunctionDataImpl.setMessageFunction(messageFunction);
		}

		if (messageId == null) {
			messageFunctionDataImpl.setMessageId(StringPool.BLANK);
		}
		else {
			messageFunctionDataImpl.setMessageId(messageId);
		}

		messageFunctionDataImpl.setMessageFileIdData(messageFileIdData);

		if (sendDate == Long.MIN_VALUE) {
			messageFunctionDataImpl.setSendDate(null);
		}
		else {
			messageFunctionDataImpl.setSendDate(new Date(sendDate));
		}

		messageFunctionDataImpl.resetOriginalValues();

		return messageFunctionDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messagePackagesId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		messageFunction = objectInput.readUTF();
		messageId = objectInput.readUTF();
		messageFileIdData = objectInput.readLong();
		sendDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(messagePackagesId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (messageFunction == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageFunction);
		}

		if (messageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageId);
		}

		objectOutput.writeLong(messageFileIdData);
		objectOutput.writeLong(sendDate);
	}

	public long messagePackagesId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String messageFunction;
	public String messageId;
	public long messageFileIdData;
	public long sendDate;
}