/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.apache.taverna.activities.externaltool.manager;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * @author alanrw
 *
 */
public abstract class InvocationMechanism {
	
	protected static XMLOutputter outputter = new XMLOutputter();


	public static String UNIX_SHELL = "/bin/sh -c";

	public static String UNIX_LINK = "/bin/ln -s %%PATH_TO_ORIGINAL%% %%TARGET_NAME%%";
	
	public static String UNIX_COPY = "/bin/cp %%PATH_TO_ORIGINAL%% %%TARGET_NAME%%";
	
	
	private String name;

	public final String getXML() {
		Document document = new Document(getXMLElement());
		String result = null;
		synchronized (outputter) {
			result = outputter.outputString(document);
		}
		return result;
	}
	
	public abstract Element getXMLElement();

	public abstract String getType();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return getName();
	}

}
