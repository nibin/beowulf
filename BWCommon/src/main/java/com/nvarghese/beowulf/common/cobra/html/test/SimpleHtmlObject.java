package com.nvarghese.beowulf.common.cobra.html.test;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.w3c.dom.html2.HTMLElement;

import com.nvarghese.beowulf.common.cobra.html.HtmlObject;

/**
 * Simple implementation of
 * {@link com.nvarghese.beowulf.common.cobra.html.HtmlObject}.
 */
public class SimpleHtmlObject extends JComponent implements HtmlObject {

	protected final HTMLElement element;

	public SimpleHtmlObject(HTMLElement element) {

		this.element = element;
		this.setLayout(new FlowLayout());
		this.add(new JLabel("[" + element.getTagName() + "]"));
	}

	public void reset(int availWidth, int availHeight) {

		// nop
	}

	public void destroy() {

	}

	public Component getComponent() {

		return this;
	}

	public void resume() {

	}

	public void suspend() {

	}
}
