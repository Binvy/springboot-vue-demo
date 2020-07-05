package com.binvi.springboot.demo03.book.howtomcatworks.chapter3;

import org.eclipse.jetty.http.HttpHeader;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/26 22:29
 */
public class SocketInputStream extends InputStream {


	// -------------------------------------------------------------- Constants


	/**
	 * CR.
	 */
	private static final byte CR = (byte) '\r';


	/**
	 * LF.
	 */
	private static final byte LF = (byte) '\n';


	/**
	 * SP.
	 */
	private static final byte SP = (byte) ' ';


	/**
	 * HT.
	 */
	private static final byte HT = (byte) '\t';


	/**
	 * COLON.
	 */
	private static final byte COLON = (byte) ':';


	/**
	 * Lower case offset.
	 */
	private static final int LC_OFFSET = 'A' - 'a';


	/**
	 * Internal buffer.
	 */
	protected byte buf[];


	/**
	 * Last valid byte.
	 */
	protected int count;


	/**
	 * Position in the buffer.
	 */
	protected int pos;


	/**
	 * Underlying input stream.
	 */
	protected InputStream is;


	// ----------------------------------------------------------- Constructors


	/**
	 * Construct a servlet input stream associated with the specified socket
	 * input.
	 *
	 * @param is socket input stream
	 * @param bufferSize size of the internal buffer
	 */
	public SocketInputStream(InputStream is, int bufferSize) {

		this.is = is;
		buf = new byte[bufferSize];

	}


	// -------------------------------------------------------------- Variables



	/**
	 * Read byte.
	 */
	public int read()
			throws IOException {
		if (pos >= count) {
			fill();
			if (pos >= count)
				return -1;
		}
		return buf[pos++] & 0xff;
	}


	/**
	 *
	 */
    /*
    public int read(byte b[], int off, int len)
        throws IOException {

    }
    */


	/**
	 *
	 */
    /*
    public long skip(long n)
        throws IOException {

    }
    */


	/**
	 * Returns the number of bytes that can be read from this input
	 * stream without blocking.
	 */
	public int available()
			throws IOException {
		return (count - pos) + is.available();
	}


	/**
	 * Close the input stream.
	 */
	public void close()
			throws IOException {
		if (is == null)
			return;
		is.close();
		is = null;
		buf = null;
	}


	// ------------------------------------------------------ Protected Methods


	/**
	 * Fill the internal buffer using data from the undelying input stream.
	 */
	protected void fill()
			throws IOException {
		pos = 0;
		count = 0;
		int nRead = is.read(buf, 0, buf.length);
		if (nRead > 0) {
			count = nRead;
		}
	}


}
