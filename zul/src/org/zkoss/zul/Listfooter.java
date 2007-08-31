/* Listfooter.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Jan 13 12:42:38     2006, Created by tomyeh
}}IS_NOTE

Copyright (C) 2006 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zul;

import java.util.List;
import java.util.Iterator;

import org.zkoss.xml.HTMLs;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zul.impl.LabelImageElement;

/**
 * A column of the footer of a list box ({@link Listbox}).
 * Its parent must be {@link Listfoot}.
 *
 * <p>Unlike {@link Listheader}, you could place any child in a list footer.
 * <p>Note: {@link Listcell} also accepts children.
 * 
 * @author tomyeh
 */
public class Listfooter extends LabelImageElement {
	private int _span = 1;

	public Listfooter() {
	}
	public Listfooter(String label) {
		setLabel(label);
	}
	public Listfooter(String label, String src) {
		setLabel(label);
		setImage(src);
	}

	/** Returns the listbox that this belongs to.
	 */
	public Listbox getListbox() {
		final Component comp = getParent();
		return comp != null ? (Listbox)comp.getParent(): null;
	}
	/** Returns the set of footers that this belongs to.
	 * @deprecated As of release 2.4.1, due to confusion
	 */
	public Listfoot getListfoot() {
		return (Listfoot)getParent();
	}
	/** Returns the column index, starting from 0.
	 */
	public int getColumnIndex() {
		int j = 0;
		for (Iterator it = getParent().getChildren().iterator();
		it.hasNext(); ++j)
			if (it.next() == this)
				break;
		return j;
	}
	/** Returns the list header that is in the same column as
	 * this footer, or null if not available.
	 */
	public Listheader getListheader() {
		final Listbox listbox = getListbox();
		if (listbox != null) {
			final Listhead lcs = listbox.getListhead();
			if (lcs != null) {
				final int j = getColumnIndex();
				final List lcschs = lcs.getChildren();
				if (j < lcschs.size())
					return (Listheader)lcschs.get(j);
			}
		}
		return null;
	}

	/** Returns number of columns to span this footer.
	 * Default: 1.
	 */
	public int getSpan() {
		return _span;
	}
	/** Sets the number of columns to span this footer.
	 * <p>It is the same as the colspan attribute of HTML TD tag.
	 */
	public void setSpan(int span) {
		if (_span != span) {
			_span = span;
			smartUpdate("colspan", Integer.toString(_span));
		}
	}

	//-- super --//
	public String getOuterAttrs() {
		final StringBuffer sb =
			new StringBuffer(80).append(super.getOuterAttrs());

		final String clkattrs = getAllOnClickAttrs(false);
		if (clkattrs != null) sb.append(clkattrs);

		final Listheader header = getListheader();
		if (header != null) sb.append(header.getColAttrs());

		if (_span != 1)
			HTMLs.appendAttribute(sb, "colspan", _span);

		return sb.toString();
	}

	//-- Component --//
	public void setParent(Component parent) {
		if (parent != null && !(parent instanceof Listfoot))
			throw new UiException("Wrong parent: "+parent);
		super.setParent(parent);
	}
}
