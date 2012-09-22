/*
 * GNU LESSER GENERAL PUBLIC LICENSE Copyright (C) 2006 The Lobo Project
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
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Contact info: lobochief@users.sourceforge.net
 */
/*
 * Created on Oct 9, 2005
 */
package com.nvarghese.beowulf.common.cobra.html.domimpl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;

public class DOMConfigurationImpl implements DOMConfiguration {

	private final Map parameters = new HashMap();

	public DOMConfigurationImpl() {

		super();
	}

	public void setParameter(String name, Object value) throws DOMException {

		synchronized (this) {
			this.parameters.put(name, value);
		}
	}

	public Object getParameter(String name) throws DOMException {

		synchronized (this) {
			return this.parameters.get(name);
		}
	}

	public boolean canSetParameter(String name, Object value) {

		// TODO
		return true;
	}

	public DOMStringList getParameterNames() {

		synchronized (this) {
			return new DOMStringListImpl(parameters.keySet());
		}
	}
}
