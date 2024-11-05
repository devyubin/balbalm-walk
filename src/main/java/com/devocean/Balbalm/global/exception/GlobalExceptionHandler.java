package com.devocean.Balbalm.global.exception;

import com.devocean.Balbalm.global.exception.CommonResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public CommonResponse<?> badRequestErrorHandler(HttpServletResponse response, HttpMessageNotReadableException e) {
		response.setStatus(ErrorCode.BAD_REQUEST.getCode());
		log.error("[BadRequest] {}", e.getMessage());
		return new CommonResponse<>(ErrorCode.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public CommonResponse<?> handleMissingParams(HttpServletResponse response, MissingServletRequestParameterException e) {
		response.setStatus(ErrorCode.BAD_REQUEST.getCode());
		log.error("[MissingParameter] {}", e.getMessage());
		return new CommonResponse<>(ErrorCode.BAD_REQUEST);
	}

	@ExceptionHandler(BalbalmException.class)
	public CommonResponse<?> handleBalbalmException(HttpServletResponse response, BalbalmException e) {
		response.setStatus(e.getErrorCode().getCode());
		log.error("[BalbalmException] {}", e.getMessage());
		return new CommonResponse<>(e.getErrorCode());
	}
}