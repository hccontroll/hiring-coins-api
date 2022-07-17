package com.hiringcoders.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {

	@Schema(example = "400")
	private Integer status;

	@Schema(example = "2022-07-17T12:48:55.516Z")
	private OffsetDateTime timestamp;

	@Schema(example = "Recurso não encontrado")
	private String title;

	@Schema(example = "Não foi encontrado Cliente com UUID 1711f651-b98c-43cc-936c-a1968e6de8cd")
	private String detail;

	@Schema(example = "Não foi encontrado Cliente com UUID 1711f651-b98c-43cc-936c-a1968e6de8cd")
	private String userMessage;

	@Schema(description = "Lista de objetos ou campos que geraram o erro (opcional)")
	private List<Object> objects;

	@Getter
	@Builder
	public static class Object {

		private String name;

		private String userMessage;

	}

}