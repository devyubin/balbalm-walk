package com.devocean.Balbalm.global.exception;

import lombok.Getter;

@Getter
public class BalbalmException extends RuntimeException {
	private final ErrorCode errorCode;

	public BalbalmException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}