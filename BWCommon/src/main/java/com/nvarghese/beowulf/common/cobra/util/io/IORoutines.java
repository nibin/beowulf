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
 * Created on Mar 19, 2005
 */
package com.nvarghese.beowulf.common.cobra.util.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author J. H. S.
 */
public class IORoutines {

	public static final byte[] LINE_BREAK_BYTES = { (byte) 13, (byte) 10 };

	public static String loadAsText(final InputStream in, final String encoding) throws IOException {

		return loadAsText(in, encoding, 4096);
	}

	public static String loadAsText(final InputStream in, final String encoding, final int bufferSize) throws IOException {

		InputStreamReader reader = new InputStreamReader(in, encoding);
		char[] buffer = new char[bufferSize];
		int offset = 0;
		for (;;) {
			int remain = buffer.length - offset;
			if (remain <= 0) {
				char[] newBuffer = new char[buffer.length * 2];
				System.arraycopy(buffer, 0, newBuffer, 0, offset);
				buffer = newBuffer;
				remain = buffer.length - offset;
			}
			int numRead = reader.read(buffer, offset, remain);
			if (numRead == -1) {
				break;
			}
			offset += numRead;
		}
		return new String(buffer, 0, offset);
	}

	public static byte[] load(final File file) throws IOException {

		long fileLength = file.length();
		if (fileLength > Integer.MAX_VALUE) {
			throw new IOException("File '" + file.getName() + "' too big");
		}
		InputStream in = new FileInputStream(file);
		try {
			return loadExact(in, (int) fileLength);
		} finally {
			in.close();
		}
	}

	public static byte[] load(final InputStream in) throws IOException {

		return load(in, 4096);
	}

	public static byte[] load(final InputStream in, final int initialBufferSize) throws IOException {

		int intBufferSize;
		if (initialBufferSize == 0) {
			intBufferSize = 1;
		} else {
			intBufferSize = initialBufferSize;
		}
		byte[] buffer = new byte[intBufferSize];
		int offset = 0;
		for (;;) {
			int remain = buffer.length - offset;
			if (remain <= 0) {
				int newSize = buffer.length * 2;
				byte[] newBuffer = new byte[newSize];
				System.arraycopy(buffer, 0, newBuffer, 0, offset);
				buffer = newBuffer;
				remain = buffer.length - offset;
			}
			int numRead = in.read(buffer, offset, remain);
			if (numRead == -1) {
				break;
			}
			offset += numRead;
		}
		if (offset < buffer.length) {
			byte[] newBuffer = new byte[offset];
			System.arraycopy(buffer, 0, newBuffer, 0, offset);
			buffer = newBuffer;
		}
		return buffer;
	}

	public static byte[] loadExact(final InputStream in, final int length) throws IOException {

		byte[] buffer = new byte[length];
		int offset = 0;
		for (;;) {
			int remain = length - offset;
			if (remain <= 0) {
				break;
			}
			int numRead = in.read(buffer, offset, remain);
			if (numRead == -1) {
				throw new IOException("Reached EOF, read " + offset + " expecting " + length);
			}
			offset += numRead;
		}
		return buffer;
	}

	public static boolean equalContent(final File file, final byte[] content) throws IOException {

		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			throw new IOException("File '" + file + "' too big");
		}
		InputStream in = new FileInputStream(file);
		try {
			byte[] fileContent = loadExact(in, (int) length);
			return java.util.Arrays.equals(content, fileContent);
		} finally {
			in.close();
		}
	}

	public static void save(final File file, final byte[] content) throws IOException {

		FileOutputStream out = new FileOutputStream(file);
		try {
			out.write(content);
		} finally {
			out.close();
		}
	}

	/**
	 * Reads line without buffering.
	 */
	public static String readLine(final InputStream in) throws IOException {

		int b;
		StringBuffer sb = null;
		OUTER: while ((b = in.read()) != -1) {
			if (sb == null) {
				sb = new StringBuffer();
			}
			switch (b) {
				case (byte) '\n':
					break OUTER;
				case (byte) '\r':
					break;
				default:
					sb.append((char) b);
					break;
			}
		}
		return sb == null ? null : sb.toString();
	}

	public static void touch(final File file) {

		long currentTime = System.currentTimeMillis();
		if (currentTime > 0) {
			try {
				file.setLastModified(currentTime);
			} catch (SecurityException e) {
				// do nothing
			}

		}

	}

	public static void saveStrings(final File file, final java.util.Collection list) throws IOException {

		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(bout);
			java.util.Iterator i = list.iterator();
			while (i.hasNext()) {
				String text = (String) i.next();
				writer.println(text);
			}
			writer.flush();
		} finally {
			writer.close();
			bout.close();
		}
	}

	public static java.util.List loadStrings(final File file) throws IOException {

		java.util.List list = new java.util.LinkedList();
		InputStream in = new FileInputStream(file);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			return list;
		} finally {
			reader.close();
		}
	}

}
