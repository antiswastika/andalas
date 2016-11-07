package com.wd.andalas.client.frontend.models.core;

import java.util.Date;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface CoreMVarstaticDTOProperties extends PropertyAccess<CoreMVarstaticDTO> {

	/********** Main Methods **********/
	@Path("varstat_id")
	ModelKeyProvider<CoreMVarstaticDTO> varstat_id();
	ValueProvider<CoreMVarstaticDTO, Date> created_at();
	ValueProvider<CoreMVarstaticDTO, String> created_by();
	ValueProvider<CoreMVarstaticDTO, Date> updated_at();
	ValueProvider<CoreMVarstaticDTO, String> updated_by();
	ValueProvider<CoreMVarstaticDTO, String> varstat_desc();
	ValueProvider<CoreMVarstaticDTO, String> varstat_name();
	ValueProvider<CoreMVarstaticDTO, Integer> varstat_seq();
	ValueProvider<CoreMVarstaticDTO, String> varstat_group();
	ValueProvider<CoreMVarstaticDTO, String> varstat_parentid();
	ValueProvider<CoreMVarstaticDTO, String> varstat_icon();
	ValueProvider<CoreMVarstaticDTO, Byte> varstat_lock();
	ValueProvider<CoreMVarstaticDTO, Byte> varstat_deleteable();
	ValueProvider<CoreMVarstaticDTO, Date> varstat_activedate();
	ValueProvider<CoreMVarstaticDTO, Date> varstat_expiredate();

}
