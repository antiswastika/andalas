package com.wd.andalas.server.backend.models.core;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CoreMUserIdGenerator implements IdentifierGenerator {

	/********** Main Methods **********/
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "USR";
		String customId = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();

		customId = prefix + dateFormat.format(date);

		return customId;
	}

}
