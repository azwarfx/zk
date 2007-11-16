/* ColumnTag.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2007/11/16  12:25:57 , auto generated by Ian Tsai
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.jsp.zul;

import org.zkoss.zul.Column;
import org.zkoss.jsp.zul.impl.BranchTag;

/**
 * The JSP tag to represent "Column" component in ZK's component definition.
 * @author Ian Tsai
 *
 */
public class ColumnTag extends BranchTag {
	/**
	 * 
	 * @return the UI component name: "column".
	 */
	protected String getJspTagName(){
		return "column";
	}

}
