package com.amith.cms.exception;

public class ChannelExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChannelExistsException(String message) {
		super(message);
	}
}
